<%@ include file="layout/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course management</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style1.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
</head>
<body>
	<div class="cadre">Test management</div>
	<div id = "formCat" class="cadre">
		<f:form modelAttribute="createtest" method="POST" action="save"
			enctype="multipart/form-data">
			<f:input path="id" type="hidden" />
			<c:out value="${ds}"></c:out>
			<table>
				<tr>
					<td>Title :</td>
					<td><f:input path="title" /> <f:errors path="title" /></td>
				</tr>
				<tr>
					<td>Description :</td>
					<td><f:input path="description" /> <f:errors
							path="description" /></td>
				</tr>
				<tr>
					<td>Photo :</td>
					<td><input type="file" name="file" /> <img
						src="photoTest?id=${createtest.id}" alt="" width="100"
						height="100" /></td>
				</tr>
				<tr>
					<td>Path :</td>
					<td><input type="file" name="filepdf" /> <img></img> <iframe
							src="photoPdf?id=${createtest.id}"> </iframe></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</f:form>
	</div>
	<div id="tabCategories" class="cadre">
		<table class="tab1">
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Description</th>
				<th>Path</th>
				<th>edit</th>
				<th>delete</th>
			</tr>
			<c:forEach items="${listtest}" var="test">
				<tr>
					<td>${test.id}</td>
					<td>${test.title}</td>
					<td>${test.description}</td>
					<td>${test.videolink}</td>
					<td><a href="delTest?idTest=${test.id}">Delete</a></td>
					<td><a href="editTest?idTest=${test.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</div>
</body>
</html>
