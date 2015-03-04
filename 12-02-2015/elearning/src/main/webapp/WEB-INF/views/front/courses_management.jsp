<%@ include file="../layout/taglib.jsp"%>
<html>
<head>
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
	<div class="content-top">
		<div class="wrap">

			<div class="section group">
				<div class="col span_2_of_contact">
					<div class="contact-form">
						<h3><t:message code="course_management"/></h3>
						
						<c:if test="${course.idCourse!=null}">
						<div>
						  <span>
						      <a href="<%=request.getContextPath()%>/courses_management"><t:message code="add_new_course"/></a>
						  </span>
						</div>
					    </c:if>
						
						<f:form modelAttribute="course" method="POST" action="saveCorsFront" enctype="multipart/form-data">
							<div>
								<f:input path="teacher.idUser" type="hidden"
									value="${sessionScope.userFLogin.idUser}" />
								<f:input path="idCourse" type="hidden" />
								<span><label><t:message code="title"/></label></span> <span> <f:input
										path="titleCourse" />
								</span> <span><f:errors path="titleCourse" cssClass="errors"></f:errors></span>
							</div>
							<div>
								<span><label><t:message code="category"/></label></span> <span> <f:select
										path="category.idCategory" items="${categories}"
										itemValue="idCategory" itemLabel="nameCat" />
								</span>
							</div>

							<div>
								<span><label><t:message code="description"/></label></span> 
								<span> 
								   <f:textarea path="description" rows="15" cols="100" />
								</span> <span><f:errors path="description" cssClass="errors"></f:errors></span>
							</div>

							<div>
								<span><label><t:message code="start_date"/></label></span> <span> <f:input
										type="text" path="dateStart"
										value="${fn:substring(course.dateStart, 0, 10)}"
										id="dateStart" name="dateStart" />
								</span> <span><f:errors path="dateStart" cssClass="errors"></f:errors></span>
							</div>

							<div>
								<span><label><t:message code="duration"/> (<t:message code="minutes"/>)</label></span> <span> <f:input
										path="minutes" />
								</span> <span><f:errors path="minutes" cssClass="errors"></f:errors></span>
							</div>

							<div>
								<span><label><t:message code="photo"/></label></span> <span> <c:if
										test="${course.idCourse!=null}">
										<img
											src="<%=request.getContextPath()%>/photoCorfront/${course.idCourse}"
											width="125px" height="125px" />
									</c:if>
								</span> <span><input type="file" name="file" /></span>
							</div>

							<div>
								<span><label><t:message code="video_link"/></label></span> <span> <f:input
										path="videoLink" /> <c:if
										test="${not empty course.videoLink}">
										<iframe src="${course.videoLink}" width="560" height="315"
											frameborder="0" allowfullscreen></iframe>
									</c:if>
								</span>

							</div>


							<div>
								<span><input type="submit" value="<t:message code="save"/>"></span>
							</div>


						</f:form>
						</br> </br>

					</div>


					<div class="contact-form">
						<table class="tab1">
							<tr>
								<th><t:message code="id"/></th>
								<th><t:message code="title"/></th>
								<th><t:message code="category"/></th>
								<th><t:message code="description"/></th>
								<th><t:message code="minutes"/></th>
								<th><t:message code="photo"/></th>
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
									<td><img
										src="<%=request.getContextPath()%>/photoCorfront/${course.idCourse}"
										width="75px" height="75px" /></td>
									<td><a
										href="<%=request.getContextPath()%>/delCorsFront?idCor=${course.idCourse}&page=${page}"><t:message code="delete"/></a></td>
									<td><a
										href="<%=request.getContextPath()%>/editCorsFront?idCor=${course.idCourse}&page=${page}"><t:message code="edit"/></a></td>
								</tr>
							</c:forEach>

						</table>
						<div id="nav">
						  <p>
							<c:forEach begin="0" end="${nbPage-1}" var="p">
								<c:choose>
									
										<c:when test="${p eq page}">
	                                      <t:message code="page"/> ${p}
	                                    </c:when>
										
									    <c:otherwise>
										   <a href="<%=request.getContextPath()%>/courses_management?page=${p}#nav"><t:message code="page"/> ${p}</a>
										</c:otherwise>
								    
								</c:choose>
                                   

							</c:forEach>
							</p>
						</div>
					</div>
				</div>
				<div class="col span_1_of_contact">
					<div class="company_address">
						<h3>Company Information :</h3>
						<p>500 Lorem Ipsum Dolor Sit,</p>
						<p>22-56-2-9 Sit Amet, Lorem,</p>
						<p>Phone:(00) 222 666 444</p>
						<p>Fax: (000) 000 00 00 0</p>
						<p>
							Email: <span>info[at]mycompany.com</span>
						</p>
						<p>
							Follow on: <span>Facebook</span>, <span>Twitter</span>
						</p>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
</body>
</html>
