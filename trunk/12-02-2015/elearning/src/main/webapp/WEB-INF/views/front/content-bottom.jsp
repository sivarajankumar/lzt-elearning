<%@ include file="../layout/taglib.jsp" %>
<div class="content-bottom" id="content-bottom_id">
	<div class="wrap">
		<div class="middle-content">
			<h2><t:message code="our_teachers"/></h2>
			<hr class="hr1">
			<br>
			<hr class="hr2">
		</div>
		<div class="section group example">
			<div class="col_1_of_2 span_1_of_2">
				<ul class="list3">
				 <c:forEach items="${users}" var="user">
				    	<li>
						<figure>
							<img src="photoUser?idUser=${user.idUser}" alt="${user.firstName}">
						</figure>
						<div class="extra-wrap1">
							<p>${user.description}</p>
							<p class="lnk">
								<a href="#"><t:message code="more"/> </a>
							</p>
						</div>
					</li>
				  </c:forEach>
				
					
				</ul>
			</div>
			
			<div class="clear"></div>
		</div>
	</div>
</div>