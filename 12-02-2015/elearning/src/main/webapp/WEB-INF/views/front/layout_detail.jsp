<%@ include file="../layout/taglib.jsp" %>
<tiles:importAttribute name="javascripts" />
<tiles:importAttribute name="stylesheets" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><c:if test="${pageTitle!=null}">
		<c:out value="${pageTitle}"></c:out>
	</c:if> <c:if test="${pageTitle==null}">
		<tiles:insertAttribute name="title" ignore="true" />
	</c:if></title>
<c:forEach var="css" items="${stylesheets}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
</c:forEach>

</head>
<body>
	<tiles:insertAttribute name="header_id" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer_id" />
	<c:if test="${lztuser!=null}">
		<tiles:insertAttribute name="friendList" />
	</c:if>
</body>
<c:forEach var="script" items="${javascripts}">
	<script src="<c:url value="${script}"/>"></script>
</c:forEach>
</html>
