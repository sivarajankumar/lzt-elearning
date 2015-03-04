<%@ include file="../layout/taglib.jsp" %>
<div class="content-allcourse" id="content-allcourse">
			<div class="wrap">
			  
           <div class="section group">
           
              <c:forEach items="${tests}" var="test">
                  	<div class="col_1_of_4 span_1_of_4">
					<div class="homeBox">
						<div class="one_fourth">	
							<div class="boxImage">
								<img
										src="<%=request.getContextPath()%>/photoTestf/${test.id}"
										width="125px" height="125px" alt="${test.title}"/>  
							    
							</div>	
						</div>
						 <div class="caption">
						   ${test.title}
						 </div>
						 <p class="lnk">
								<a href="test?idTest=${test.id}">More </a>
						 </p>
					</div>
				</div>
              </c:forEach>
           
        
				<div class="clear"></div> 
			</div>
			</div>
		</div>