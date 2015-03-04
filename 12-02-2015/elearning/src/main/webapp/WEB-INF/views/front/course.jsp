<%@ include file="../layout/taglib.jsp" %>
 <div class="content-top">
			<div class="wrap">
				 
				<div class="section group">
				 <div class="col span_2_of_contact">
				  <div class="contact-form">
				  	<h3>${course.titleCourse}</h3>
					    <div>
						    <span>${course.description}</span>
						</div>
						<div>  <!-- not empty idCourse_video and  -->
						    <c:if
							test="${not empty sessionScope.userFLogin and not empty course.videoLink}">
							 <iframe src="${course.videoLink}" width="560" height="315"
								frameborder="0" allowfullscreen></iframe>
							</c:if>
						  
						</div>
					</div>
  				</div>
				<div class="col span_1_of_contact">
				  <div class="company_address">
				     	<h3><t:message code="course_information"/> :</h3>
						    	<p><div class="boxImage"><img src="<%=request.getContextPath()%>/photoCorfront/${course.idCourse}" alt="${course.nomPhoto}"/></div></p>
						   
						<p><t:message code="length"/>: ${course.minutes} minutes</p>
				   		<p><t:message code="teacher"/>: ${course.teacher.firstName} </p>
				 	 	<p><t:message code="start_date"/> : <span>${fn:substring(course.dateStart, 0, 10)}</span></p>
				 	 	
				 	 	<div  class="contact-form">
				 	 	  <form action="watch_video" method="POST">
				 	 	      <input type="hidden" value="${course.idCourse}" name="idCourse"/>
				 	 	      <c:if test="${empty sessionScope.userFLogin}">
							      <span><input type="submit" value="<t:message code="watch_video"/>"/></span>
							  </c:if>
				 	 	    
				 	 	  </form>
				 	 	</div>
				   </div>
				 </div>
				 <div class="clear"></div>
			  </div>
			</div>
	</div>