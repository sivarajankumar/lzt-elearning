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
<div class="status-bar">
 <c:if test="${name!=null}">
 		<a href="/elearning/user/logout">LogOut</a>
        <h2>WellCome ${name}</h2>
 </c:if>
  <c:if test="${name==null}">
 		<a href="/elearning/user/index">LogIn</a>
 </c:if>
</div>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
