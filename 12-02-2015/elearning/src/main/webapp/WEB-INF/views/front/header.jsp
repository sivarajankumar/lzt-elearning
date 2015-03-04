<%@ include file="../layout/taglib.jsp" %>
<div class="header" id="header_id">
	<div class="header-top">
		<div class="wrap">
			<div class="logo">
				<a href="<%=request.getContextPath()%>/lstcourses/index"><img
					src="<%=request.getContextPath()%>/resources/images/front/logo.png"
					alt=""></a>
			</div>
			<div class=flag>
			   <span><a href="<%=request.getContextPath()%>/lstcourses/index?language=en">
			     		<img src="<%=request.getContextPath()%>/resources/images/front/gb.png" alt="">
			     </a>|<a href="<%=request.getContextPath()%>/lstcourses/index?language=jp"><img src="<%=request.getContextPath()%>/resources/images/front/jp.png" alt=""></a></span>  
			 </div>
			 </br>
			<div class="search_box">
				<form>
					<input type="text" value="<t:message code="search"/>" onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = '<t:message code="search"/>';}"><input
						type="submit" value="">
				</form>
			</div>
			
			<div class="clear"></div>
		</div>
	</div>
	<div class="header-bottom">
		<div class="wrap">
			<div id='cssmenu'>
				<ul>
					<li class='active'><a href='<%=request.getContextPath()%>/lstcourses/index'><span><t:message code="home"/></span></a></li>
					<li><a href='<%=request.getContextPath()%>/lstcourses/about'><span><t:message code="about"/></span></a></li>
					<li><a href='<%=request.getContextPath()%>/lstcourses/allcourses'><span><t:message code="courses"/></span></a></li>
					<li><a href='<%=request.getContextPath()%>/listTest/alltests'><span><t:message code="test"/></span></a></li>
					<li><a href='<%=request.getContextPath()%>/contact'><span><t:message code="contact"/></span></a></li>
                     <c:if test="${sessionScope.userFLogin.typeUser == 'teacher' || sessionScope.userFLogin.typeUser == 'admin' }">
                          <li class='has-sub'><a href='<%=request.getContextPath()%>/courses_management?page=0'><span><t:message code="management"/></span></a>
								<ul>
									<li class='has-sub'><a href='<%=request.getContextPath()%>/courses_management?page=0'><span><t:message code="courses"/></span></a></li>
									<li class='has-sub'><a href='<%=request.getContextPath()%>/test_management'><span><t:message code="testmanagement"/></span></a></li>
									<li class='has-sub'><a href='<%=request.getContextPath()%>/statistic'><span><t:message code="statistic"/></span></a></li>
								</ul>
						   </li>
                     </c:if>
					<c:choose>
						<c:when test="${not empty sessionScope.userFLogin}">
							

							<li class='has-sub'><a href='<%=request.getContextPath()%>/profile'><span><t:message code="account"/></span></a>
								<ul>
									<li class='has-sub'><a href='<%=request.getContextPath()%>/profile'><span><t:message code="profile"/></span></a></li>
									<li class='has-sub'><a href='<%=request.getContextPath()%>/settings'><span><t:message code="settings"/></span></a></li>
									<li class='has-sub'><a href='<%=request.getContextPath()%>/lstcourses/flogout'><span><t:message code="logout"/></span></a></li>
								</ul>
						   </li>

						</c:when>
						<c:otherwise>
							<p>
							<li><a href='<%=request.getContextPath()%>/lstcourses/login'><span><t:message code="login"/></span></a></li>
							</p>
							<p>
							<li class='last'><a
								href='<%=request.getContextPath()%>/lstcourses/register'><span><t:message code="signup"/></span></a></li>
							</p>
						</c:otherwise>
					</c:choose>


					<div class="clear"></div>

				</ul>

			</div>
		</div>
	</div>
</div>