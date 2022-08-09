<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>File List</title>
<style>
	a {
		text-decoration: none;
	}
</style>
</head>
<body>

	<h3>업로드 파일 목록</h3>
	
	<ul>
	<c:forEach items="${files }" var="file">
		<li>
			${file.getName() }
		</li>
		<li>
			<a href="${file }">${file.absolutePath }</a>
			<!-- 다운로드를 구현한 후에 이미지 태그로 접근하면 웹 브라우저로 조회할 수 있다 -->
			<img src="${file }" alt="${file.getName() }" /> 
		</li>
		<li><hr /></li>
	</c:forEach>
	</ul>

</body>
</html>