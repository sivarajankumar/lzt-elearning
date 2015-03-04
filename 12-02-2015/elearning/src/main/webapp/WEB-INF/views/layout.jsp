<%@ include file="layout/taglib.jsp" %>
<tiles:importAttribute name="javascripts" />
<tiles:importAttribute name="stylesheets" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<c:forEach var="css" items="${stylesheets}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
</c:forEach>
</head>
<body>
	<table align="center">
		<tr>
			<td colspan="2" id="headerTD"><tiles:insertAttribute
					name="header" /></td>
		</tr>
		<tr>
			<td id="menu"><tiles:insertAttribute name="menu" /></td>
			<td>
				<div id="body">
					<tiles:insertAttribute name="body" />
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
	<c:forEach var="script" items="${javascripts}">
		<script src="<c:url value="${script}"/>"></script>
	</c:forEach>
</body>
</html>
