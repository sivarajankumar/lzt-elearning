<%@ include file="../layout/taglib.jsp" %>
 <div class="content-top">
			 <div class="content-top">
			<div class="wrap">
				<div class="section group">
				
					<div class="lsidebar span_1_of_3">
					      <h3>About us</h3>
						  <ul class="about-list">
                            <li>
                                <h3>${about.title}</h3>
                                <p>${about.description}</p>
                            </li>
                          
                        </ul>
					</div>
					<div class="cont span_2_of_3">
					       <h3>${text_about_right.title}</h3>
						   	<p>${text_about_right.description}</p>
						   <p>.</p>
					</div>	
					<div class="clear"></div> 			
		        </div>
			</div>
		</div>
		<div class="about-bottom">
			<div class="wrap">
			   <div class="section group">
					<div class="lsidebar span_1_of_3">
					      <h3>${text_about_bottom.title}</h3>
						  <ul class="about-list1">
	                            <li>
	                                <p>${text_about_bottom.description}</p>
	                                
	                            </li>
	                            
                            </ul>
					    </div>
					<div class="cont span_2_of_3">
					       <h3>Courses</h3>
						   <div class="photos">
							   	<ul>
							   	    <c:forEach items="${courses}" var="course">
							   	       <li><img src="photoCor?idCor=${course.idCourse}" alt="${course.titleCourse}"/></li>
							   	    </c:forEach>
							   	</ul>
						   </div>
					</div>				    
					</div>	
					<div class="clear"></div> 			
		        </div>
          </div>
	</div>