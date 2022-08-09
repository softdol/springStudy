<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<P> 
	Name : ${coffee.name} <br>
	Price : ${coffee.price} <br>
	HOT : ${coffee.hot} <br>
	${coffee} <br>
	<hr />
	
	Name : ${name} <br>
	Price : ${price} <br>
	HOT : ${hot} <br>
</P>
</body>
</html>
