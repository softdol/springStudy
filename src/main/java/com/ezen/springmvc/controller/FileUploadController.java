package com.ezen.springmvc.controller;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping(value= {"/fileupload"})
@Controller
public class FileUploadController {
		
	@GetMapping({"/form"})
	public String uploadForm() {
		log.info("���� ���ε�");
		return "upload/form";
	}
	
	@PostMapping("/")
	public String handleFileUpload(MultipartFile file) {
		
//		ServletContext app = req.getServletContext();		
//		log.info("real path :" + app.getRealPath("/"));
		
		Path root = Paths.get("target/files/");
		
//		log.info("rootLocation : " + root);
//		log.info("abs rootLocation : " + root.toAbsolutePath());
		
		if(file.isEmpty()) {
			log.error("����ִ� ������ ������ �� �����ϴ�.");
			return "redirect:/message"; 
		}
		
		// Path.resolve() : �ش� Path�� ���� �Ѱ��� ��� ��θ� ������ �ν��Ͻ��� ��ȯ
		// Path.normalize() : �ش� Path�� ./, ../���� ��� ��ε��� �ּ�ȭ�� ��θ� ��ȯ
		// ���� �̸��� ��ġ�� �ʵ��� �տ� �ִ��� ��ġ�� �ʴ� ���ڸ� �־��ִ� ���� ����.
		//Path destFile = root.resolve(Paths.get(Math.abs(new Random().nextLong()) + "_" + file.getOriginalFilename())).normalize();
		
		// UUID Ŭ������ ����� ���� �ִ�
		UUID uuid = UUID.randomUUID();	// ���� �ĺ���
		Path destFile = root.resolve(uuid + "_" + Paths.get(file.getOriginalFilename()));
		
//		log.info("destFile : " + destFile);
		
		//���� ����
		try (
				InputStream in = file.getInputStream()
				){
			
			// nio�� mkdirs(�ش� ��ο� �ʿ��� ��� ���� ���丮���� �����Ѵ�
			Files.createDirectories(root);
			
			// ������ �״�� ����
			// StandardCopyOption.REPLACE_EXISTING : �����				
			Files.copy(in, destFile, StandardCopyOption.REPLACE_EXISTING);
			log.info("���� ���� ���� : " + destFile.toAbsolutePath());
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info("���� ���� ����");
		}
		
//		log.info("file : " + file);		
//		log.info("filename : " + file.getOriginalFilename());
//		log.info("filesize : " + file.getSize());
		
		//log.info(file.getInputStream());
		
		return "redirect:/fileupload/form";
	}
	
	
	@GetMapping({"/",""})
	public String listUploadFiles(Model model) {
		// ��Ʈ�ѷ����� ��Ʈ�̺�Ʈ�� ���� �� model�� Ȱ���� �� �ִ�.
		List<File> files = new ArrayList<>();
		
		File root = new File("target/files/");
		
		for(File f : root.listFiles()) {
			if(f.isDirectory()) {
				for(File f2 : f.listFiles()) {
					files.add(f2);
				}
			}else {
				files.add(f);				
			}
//			log.info("path : " + f.getPath());
//			log.info("file : " + f.getName());
		}
		
		model.addAttribute("files", files);
		
		return "upload/list";
	}
	
	@GetMapping("/{path}/{path2}/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(
			//@PathVariable String parent,
			@PathVariable String path,
			@PathVariable String path2,
			@PathVariable String filename
		) throws Exception{
		
//		log.info("path : " + path);
//		log.info("path2 : " + path2);
//		log.info("filename : " + filename);
		
		Path file = Paths.get(path).resolve(path2).resolve(filename);
		
		try {
			Resource res = new UrlResource(file.toUri());
			
			// ������ �ٿ������� �Ҷ��� ����� content-disposition �׸��� attachment�� �ٲ���Ѵ�		
			//return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"").body(res);
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"\"").body(res);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("�ٿ�ε� ���� : " + file);
			//throw new Exception("���� �ٿ�ε� �� ������ �߻��߽��ϴ�.");
			return (ResponseEntity<Resource>)ResponseEntity.notFound();
		}
		
	}

}























