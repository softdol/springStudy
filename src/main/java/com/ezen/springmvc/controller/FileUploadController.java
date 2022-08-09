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
		log.info("파일 업로드");
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
			log.error("비어있는 파일을 저장할 수 없습니다.");
			return "redirect:/message"; 
		}
		
		// Path.resolve() : 해당 Path로 부터 넘겨준 상대 경로를 적용한 인스턴스를 반환
		// Path.normalize() : 해당 Path의 ./, ../같은 상대 경로들을 최소화한 경로를 반환
		// 파일 이름이 겹치지 않도록 앞에 최대한 겹치지 않는 숫자를 넣어주는 것이 좋다.
		//Path destFile = root.resolve(Paths.get(Math.abs(new Random().nextLong()) + "_" + file.getOriginalFilename())).normalize();
		
		// UUID 클래스를 사용할 수도 있다
		UUID uuid = UUID.randomUUID();	// 고유 식별자
		Path destFile = root.resolve(uuid + "_" + Paths.get(file.getOriginalFilename()));
		
//		log.info("destFile : " + destFile);
		
		//파일 쓰기
		try (
				InputStream in = file.getInputStream()
				){
			
			// nio의 mkdirs(해당 경로에 필요한 모든 상위 디렉토리들을 생성한다
			Files.createDirectories(root);
			
			// 파일을 그대로 복사
			// StandardCopyOption.REPLACE_EXISTING : 덮어쓰기				
			Files.copy(in, destFile, StandardCopyOption.REPLACE_EXISTING);
			log.info("파일 복사 성공 : " + destFile.toAbsolutePath());
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info("파일 복사 실패");
		}
		
//		log.info("file : " + file);		
//		log.info("filename : " + file.getOriginalFilename());
//		log.info("filesize : " + file.getSize());
		
		//log.info(file.getInputStream());
		
		return "redirect:/fileupload/form";
	}
	
	
	@GetMapping({"/",""})
	public String listUploadFiles(Model model) {
		// 컨트롤러에서 어트이뷰트를 실을 때 model을 활용할 수 있다.
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
			
			// 파일을 다운받으라고 할때는 헤더의 content-disposition 항목을 attachment로 바꿔야한다		
			//return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"").body(res);
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"\"").body(res);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("다운로드 실패 : " + file);
			//throw new Exception("파일 다운로드 중 문제가 발생했습니다.");
			return (ResponseEntity<Resource>)ResponseEntity.notFound();
		}
		
	}

}























