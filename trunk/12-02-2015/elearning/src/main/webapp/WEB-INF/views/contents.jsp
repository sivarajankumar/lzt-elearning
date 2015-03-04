<%@ include file="layout/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Content category management</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<body>
	<div class="cadre">Content Management</div>
	<div id="formCat" class="cadre">
		<f:form modelAttribute="content" action="saveCon" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td><f:input path="idContent" type="hidden" /></td>
				</tr>
				<tr>
					<td>Title</td>
					<td><f:input path="title" size="20" maxlength="50" /></td>
					<td><f:errors path="title" cssClass="error"></f:errors></td>
				</tr>

				<tr>
					<td>Description</td>
					<td><f:textarea path="description" rows="20" cols="80" /></td>
					<td><f:errors path="description" cssClass="error"></f:errors>
					</td>
				</tr>
				
				<tr>
					<td>Type user</td>
				
					<td>
					<f:select path="typeContent">
					 <f:option value="banner" selected="selected">Banner</f:option>  
                  	 <f:option value="middle_content">Middle Content</f:option>
                  	 <f:option value="about">About</f:option>
                  	 <f:option value="text_about_right">History</f:option>
                  	 <f:option value="text_about_bottom">About bottom</f:option>  
                  </f:select>  
					
					</td>
				</tr>
				
				<tr>
					<td>Photo</td>
					<td><c:if test="${content.idContent!=null}">
							<img src="photoCon?idCon=${content.idContent}" width="125px"
								height="125px" />
						</c:if></td>
					<td><input type="file" name="file" /></td>
				</tr>
                 <tr>
					<td>active</td>
					<td><f:checkbox path="active" value="false"  ></f:checkbox></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save"></td>
				</tr>
			</table>
		</f:form>
	</div>


	<div id="tabContent" class="cadre">
		<table class="tab1">
			<tr>
				<th>ID</th>
				<th>Content Name</th>
				<th>Description</th>
				<th>PHOTO</th>
				<th></th>
				<th></th>
			</tr>

			<c:forEach items="${contents}" var="contents">
				<tr>
					<td>${contents.idContent}</td>
					<td>${contents.title}</td>
					<td>${fn:substring(contents.description, 0, 50)}...</td>
					<td><img src="photoCon?idCon=${contents.idContent}"
						width="125px" height="125px" /></td>
					<td><a href="delCon?idCon=${contents.idContent}">Delete</a></td>
					<td><a href="editCon?idCon=${contents.idContent}">Edit</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>