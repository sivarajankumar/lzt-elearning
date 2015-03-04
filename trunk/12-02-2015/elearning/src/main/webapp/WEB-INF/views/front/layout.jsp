<%@ include file="../layout/taglib.jsp" %>
<tiles:importAttribute name="javascripts" />
<tiles:importAttribute name="stylesheets" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<c:forEach var="css" items="${stylesheets}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
</c:forEach>


</head>
<body>
	<tiles:insertAttribute name="header_id" />
	<tiles:insertAttribute name="slider_id" />
	<tiles:insertAttribute name="content-top_id" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="content-bottom_id" />
	<tiles:insertAttribute name="footer_id" />
		<c:if test="${lztuser!=null}">
		<tiles:insertAttribute name="friendList" />
	</c:if>
		<c:forEach var="script" items="${javascripts}">
		<script src="<c:url value="${script}"/>"></script>
	</c:forEach>
	<script type="text/javascript">
	$(window).load(function() {
		$('#slider').nivoSlider();
	});</script>
</body>
</html>
