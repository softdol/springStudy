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

	<h3>���ε� ���� ���</h3>
	
	<ul>
	<c:forEach items="${files }" var="file">
		<li>
			${file.getName() }
		</li>
		<li>
			<a href="${file }">${file.absolutePath }</a>
			<!-- �ٿ�ε带 ������ �Ŀ� �̹��� �±׷� �����ϸ� �� �������� ��ȸ�� �� �ִ� -->
			<img src="${file }" alt="${file.getName() }" /> 
		</li>
		<li><hr /></li>
	</c:forEach>
	</ul>

</body>
</html>