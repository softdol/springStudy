<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Add Coffee Menu</title>
</head>
<body>

<h3>Ŀ�� �޴� �߰��ϱ�</h3>
private String name;
private Integer price;
private Boolean hot;
<form action="<c:url value="/coffee/add" />" method="POST">
	name : <input type="text" name="name" value="�Ƹ޸�ī��" /> <br />
	price : <input type="text" name="price" value="1700" /> <br />
	hot : <input type="radio" name="hot" value="true" checked />
	<input type="radio" name="hot" value="false" /> <br />
	
	<input type="submit" />

</form>

</body>
</html>