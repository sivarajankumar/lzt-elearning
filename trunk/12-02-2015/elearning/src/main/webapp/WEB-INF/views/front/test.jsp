<%@ include file="../layout/taglib.jsp" %>
 <div class="content-top">
			<div class="wrap">
				 
				<div class="section group">
				 <div class="col span_2_of_contact">
				  <div class="contact-form">
				  	<h3>${test.title}</h3>
					    <div>
						    <span>${test.description}</span>
						</div>
						
					</div>
  				</div>
				<div class="col span_1_of_contact">
				  <div class="company_address">
				     	<h3><t:message code="test_information"/> :</h3>
						    	<p><div class="boxImage"><img src="<%=request.getContextPath()%>/photoTestf/${test.id}" alt="${test.title}"/></div></p>
						<p><t:message code="teacher"/>: ${test.user.firstName} </p>
				 	 	<div  class="contact-form">
				 	 	  <form action="do_test" method="POST">
				 	 	      <input type="hidden" value="${test.id}" name="idTest"/>
				 	 	      <c:if test="${empty sessionScope.userFLogin}">
							      <span><input type="submit" value="<t:message code="do_test"/>"/></span>
							  </c:if>
				 	 	    
				 	 	  </form>
				 	 	</div>
				   </div>
				 </div>
				 <div class="clear"></div>
			  </div>
			</div>
	</div>