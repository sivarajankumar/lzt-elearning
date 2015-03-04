<%@ include file="../layout/taglib.jsp" %>
<div class="content-top" id="content-top_id">
			<div class="wrap">
				<div class="section group">
				
				<c:forEach items="${categoris}" var="categoris">
				
				<div class="col_1_of_top span_1_of_top">
					<img src="photoCat?idCat=${categoris.idCategory}" alt="${categoris.nameCat}"/>
					<h3>${categoris.descriptionCat}</h3>
					<h4>${categoris.nameCat}</h4>
				</div>
				
				</c:forEach>
				
				 <div class="clear"></div> 
			</div>
			</div>
		</div>