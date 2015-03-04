<%@ include file="../layout/taglib.jsp" %>
<div class="slider" id="slider_id">
	<div class="wrap">
		<div class="slider-wrapper theme-default">
			<div id="slider" class="nivoSlider">
			     <c:forEach items="${contents}" var="content">
					<img src="photoCon?idCon=${content.idContent}" alt="${content.title}" /> 
				 </c:forEach>
			</div>
		</div>
	</div>
</div>