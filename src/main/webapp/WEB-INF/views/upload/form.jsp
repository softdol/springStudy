<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>File ���ε�</title>
</head>
<body>

	<h3>/fileupload/form</h3>

	<!-- 
		������ ������ ���ؼ���
			method�� POST�� �����ϰ� 
			enctype�� multipart/form-data�� �����ؾ� �Ѵ�.		 
	-->	
	<form action="./" method="POST" enctype="multipart/form-data">
		���ϴ� ���� ���� : <input type="file" name="file" />
		<input type="submit" value="���" />
		
	</form>

</body>
</html>