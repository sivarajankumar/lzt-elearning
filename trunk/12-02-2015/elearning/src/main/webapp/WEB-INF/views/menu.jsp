<%@ include file="layout/taglib.jsp" %>
<div>
   
   <c:if test="${sessionScope.userLogin != null}">
           Hello  <c:out value="${sessionScope.userLogin.firstName}" />
		<ul>
			<li><br /> <a href="<%=request.getContextPath()%>/categoris">
					Course Category</a> <br /> <br /></li>
			<li><a href="<%=request.getContextPath()%>/courses"> Courses</a>
				<br /> <br /></li>
			<li><a href="<%=request.getContextPath()%>/createtest"> Test</a> <br />
				<br /></li>
			<li><a href="<%=request.getContextPath()%>/users"> Users</a> <br />
				<br /></li>
			<li><a href="<%=request.getContextPath()%>/contents"> Contents</a> <br />
				<br /></li>
			<li><a href="<%=request.getContextPath()%>/logout"> Logout</a> <br />
				<br /></li>

		</ul>
	</c:if>
</div>