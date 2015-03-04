<%@ include file="layout/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Course management</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style1.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#dateStart").datepicker();
	});
</script>
</head>
<body>
	<div class="cadre">Courses Management</div>
	<div id="formCat" class="cadre">
		<f:form modelAttribute="course" action="saveCor" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td><f:input path="idCourse" type="hidden" /></td>
				</tr>
				<tr>
					<td>Title</td>
					<td><f:input path="titleCourse" /></td>
					<td><f:errors path="titleCourse" cssClass="error"></f:errors>
					</td>
				</tr>
				<tr>
					<td>Category</td>
					<td><f:select path="category.idCategory" items="${categories}"
							itemValue="idCategory" itemLabel="nameCat" /></td>
					<td><f:errors path="category" cssClass="errors"></f:errors></td>
				</tr>
				<tr>
					<td>Teacher</td>
					<td><f:select path="teacher.idUser" items="${teachers}"
							itemValue="idUser" itemLabel="firstName" /></td>
					<td><f:errors path="teacher" cssClass="errors"></f:errors></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><f:textarea path="description" rows="15" cols="100" /></td>
					<td><f:errors path="description" cssClass="error"></f:errors>
					</td>
				</tr>

				<tr>
					<td>Date Start</td>
					<td>
					  <f:input type="text" path="dateStart" value="${fn:substring(course.dateStart, 0, 10)}" id="dateStart" name="dateStart" />
					</td>
					<td><f:errors path="dateStart" cssClass="errors"></f:errors></td>
				</tr>

				<tr>
					<td>Duration</td>
					<td><f:input path="minutes" /></td>
					<td><f:errors path="minutes" cssClass="errors"></f:errors></td>
				</tr>

				<tr>
					<td>Photo</td>
					<td><c:if test="${course.idCourse!=null}">
							<img src="photoCor?idCor=${course.idCourse}" width="125px"
								height="125px" />
						</c:if> <input type="file" name="file" /></td>
					<td></td>
				</tr>

				<tr>
					<td>Video Link</td>
					<td><f:input path="videoLink" /> 
					     <c:if test="${not empty course.videoLink}">
					          <iframe src="${course.videoLink}" width="560" height="315"
								frameborder="0" allowfullscreen></iframe>
						</c:if>
					</td>
					<td><f:errors path="videoLink" cssClass="videoLink"></f:errors>
					</td>
				</tr>

				<tr>
					<td>In home page</td>
					<td><f:checkbox path="inHome" value="false"></f:checkbox></td>
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
				<th>Title</th>
				<th>Category</th>
				<th>Description</th>
				<th>Minutes</th>
				<th>PHOTO</th>
				<th></th>
				<th></th>
			</tr>

			<c:forEach items="${courses}" var="course">
				<tr>
					<td>${course.idCourse}</td>
					<td>${course.titleCourse}</td>
					<td>${course.category.nameCat}</td>
					<td>${fn:substring(course.description, 0, 50)}...</td>
					<td>${course.minutes}</td>
					<td><img src="photoCor?idCor=${course.idCourse}" width="125px"
						height="125px" /></td>
					<td><a href="delCors?idCor=${course.idCourse}">Delete</a></td>
					<td><a href="editCors?idCor=${course.idCourse}">Edit</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>