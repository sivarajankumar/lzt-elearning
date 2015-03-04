<%@ include file="../layout/taglib.jsp" %>
<div class="content-middle" id="content-middle">
			<div class="wrap">
			   <div class="middle-content">
                    <h2> <c:out value='${content_middle.title}' /> </h2>
                    <hr class="hr1"><br>
                    <hr class="hr2">
                    <p><c:out value='${content_middle.description}'/>
                    </p>
                </div>
           <div class="section group">
           
              <c:forEach items="${courses}" var="course">
                  	<div class="col_1_of_4 span_1_of_4">
					<div class="homeBox">
						<div class="one_fourth">	
							<div class="boxImage"><img src="<%=request.getContextPath()%>/photoCorfront/${course.idCourse}" alt=""/></div>	
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