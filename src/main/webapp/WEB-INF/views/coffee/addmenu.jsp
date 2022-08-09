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

<h3>커피 메뉴 추가하기</h3>
<form id="frmAdd" method="POST">
	name : <input type="text" name="name" value="아메리카노" /> <br />
	price : <input type="text" name="price" value="1700" /> <br />
	hot : <input type="radio" name="hot" value="true" checked />
	<input type="radio" name="hot" value="false" /> <br />
		
	<button id="btn1">add1</button>
	<button id="btn2" data-url="/springmvc/coffee/add2" form="frmAdd" formaction="/springmvc/coffee/add2">add2</button>
	<button id="btn3" form="frmAdd" formaction="/springmvc/coffee/add3">add3</button>
</form>
	<script>
		// add1을 누르면 /springmvc/coffee/add1
		// add2을 누르면 /springmvc/coffee/add1
		const frmAdd = document.getElementById('frmAdd');
		const btn1 = document.getElementById('btn1');
		btn1.addEventListener('click',() =>{
			frmAdd.action = "/springmvc/coffee/add1";
			frmAdd.submit();
		});
		/*
		const btn2 = document.getElementById('btn2');
		btn2.addEventListener('click',(e) =>{
			frmAdd.action = e.target.dataset.url;
			frmAdd.submit();
		});
		*/
	</script>


</body>
</html>