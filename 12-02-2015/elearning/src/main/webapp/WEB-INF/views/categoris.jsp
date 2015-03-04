<%@ include file="layout/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course category management</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<body>
	<div class="cadre">Categories Management</div>
	<div id="formCat" class="cadre">
		<f:form modelAttribute="category" action="saveCat" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td><f:input path="idCategory" type="hidden" /></td>
				</tr>
				<tr>
					<td>Category name</td>
					<td><f:input path="nameCat" size="20" maxlength="50" /></td>
					<td><f:errors path="nameCat" cssClass="error"></f:errors></td>
				</tr>

				<tr>
					<td>Description</td>
					<td><f:textarea path="descriptionCat" rows="5" cols="40" /></td>
					<td><f:errors path="descriptionCat" cssClass="error"></f:errors>
					</td>
				</tr>
				<tr>
					<td>Photo</td>
					<td><c:if test="${category.idCategory!=null}">
							<img src="photoCat?idCat=${category.idCategory}" width="125px"
								height="125px" />
						</c:if></td>
					<td><input type="file" name="file" /></td>
				</tr>
                 <tr>
					<td>In home page</td>
					<td><f:checkbox path="inHome" value="false"  ></f:checkbox></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save"></td>
				</tr>
			</table>
		</f:form>
	</div>


	<div id="tabCategories" class="cadre">
		<table class="tab1">
			<tr>
				<th>ID</th>
				<th>Category Name</th>
				<th>Description</th>
				<th>PHOTO</th>
				<th></th>
				<th></th>
			</tr>

			<c:forEach items="${categoris}" var="categoris">
				<tr>
					<td>${categoris.idCategory}</td>
					<td>${categoris.nameCat}</td>
					<td>${categoris.descriptionCat}</td>
					<td><img src="photoCat?idCat=${categoris.idCategory}"
						width="125px" height="125px" /></td>
					<td><a href="delCat?idCat=${categoris.idCategory}">Delete</a></td>
					<td><a href="editCat?idCat=${categoris.idCategory}">Edit</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>