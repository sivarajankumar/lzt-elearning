<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>My Page</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/lib/jquery/jquery-ui.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/external/jquery/jquery.js"></script>
	<script src="<%=request.getContextPath()%>/resources/lib/jquery/jquery-ui.min.js"></script>
</head>
<body>
<h1>
	Private Page!
</h1>
<ul>
<c:forEach var="item" items="${lstUser}">
   <li>
   	<a href="javascript:void(0)" data-id="${item.getId()}" class="item-user">${item.getFirstName()}</a>
   </li>
</c:forEach>
</ul>
<h1>
	Your notify!
</h1>
<ul>
<c:forEach var="item" items="${lstMessage}">
   <li>
   	<div  data-id="${item.getId()}" class="item-message">${item.getMessage()}</div>
   </li>
</c:forEach>
</ul>
<div id="dialog" title="Basic dialog">
<form action="/sendMessage" id="message">
	<textarea name="message"></textarea>
	<input name="toUser" type="hidden"/>
	<div class="clearfix"></div><br>
	<input type="submit" value="send"/>
</form>
</div>
<script src="<%=request.getContextPath()%>/resources/js/app.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/websocket.js"></script>
</body>
</html>
