<%@ include file="../layout/taglib.jsp" %>
<div class="content-allcourse" id="content-allcourse">
			<div class="wrap">
			  
           <div class="section group">
           
              <c:forEach items="${courses}" var="course">
                  	<div class="col_1_of_4 span_1_of_4">
					<div class="homeBox">
						<div class="one_fourth">	
							<div class="boxImage"><img src="photoCor?idCor=${course.idCourse}" alt=""/></div>	
						</div>
						 <div class="caption">
						   ${course.titleCourse}
						 </div>
						 <p class="lnk">
								<a href="course?idCor=${course.idCourse}"><t:message code="more"/> </a>
						 </p>
					</div>
				</div>
              </c:forEach>
           
        
				<div class="clear"></div> 
			</div>
			</div>
		</div>