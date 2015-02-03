<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<tiles:importAttribute name="javascripts" />
<tiles:importAttribute name="stylesheets" />
<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<c:forEach var="css" items="${stylesheets}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
</c:forEach>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<!------ Slider ------------>
	<tiles:insertAttribute name="slider" />
	<!------End Slider ------------>
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
	<c:if test="${lztuser!=null}">
		<tiles:insertAttribute name="friendList" />
	</c:if>
	<c:forEach var="script" items="${javascripts}">
		<script src="<c:url value="${script}"/>"></script>
	</c:forEach>
</body>
</html>



