<%@ include file="../layout/taglib.jsp"%>
<div class="header" id="header_id">

	<div class="header-top">
		<div class="wrap">
			<div class="logo">
				<a href="<%=request.getContextPath()%>/lstcourses/index"><img
					src="<%=request.getContextPath()%>/resources/images/front/logo.png"
					alt=""></a>
			</div>



			<div class="clear"></div>
		</div>
	</div>
	<div class="header-fix">
		<div class="wrap">

			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
				<div class="logo-e">E</div>
				<div class="menu">
					<a href="/elearning/lstcourses/index"><span
						class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
				</div>
				<div class="search_box">
					<form>
						<input type="text" value="<t:message code="search"/>"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = '<t:message code="search"/>';}"><input
							type="submit" value="">
					</form>
				</div>
			</div>
			<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
				<div class="left">
					<div class="mypage col-xs-3 col-sm-3 col-md-3 col-lg-3">
						<a href="/elearning/viewUser?id=${lztuser.getIdUser()}"><img
							alt="Avarta"
							src="/elearning/resources/images/front/${lztuser.getPhoto()}" /></a>
					</div>
				</div>
				<div class="right">
					<div class="request-friend col-xs-2 col-sm-2 col-md-2 col-lg-2">
						<c:if test='${notify.get("friend").size()>0}'>
							<span data-content='${notify.get("friend").size()}'></span>
						</c:if>
						<div class="mask-as-parent"></div>
					</div>
					<div class="messagenf col-xs-2 col-sm-2 col-md-2 col-lg-2">
						<c:if test='${notify.get("mesage").size()>0}'>
							data-content='${notify.get("mesage").size()}'
						</c:if>
					</div>
					<div class="event col-xs-2 col-sm-2 col-md-2 col-lg-2"></div>
					<div
						class="option glyphicon glyphicon-triangle-bottom col-xs-1 col-sm-1 col-md-1 col-lg-1">
					</div>
				</div>
			</div>
		</div>
		<div class=flag>
			<span><a
				href="<%=request.getContextPath()%>/lstcourses/index?language=en">
					<img
					src="<%=request.getContextPath()%>/resources/images/front/gb.png"
					alt="">
			</a>|<a href="<%=request.getContextPath()%>/lstcourses/index?language=jp"><img
					src="<%=request.getContextPath()%>/resources/images/front/jp.png"
					alt=""></a></span>
		</div>
	</div>
</div>
<div class="template">
	<ul id="friend-list">
		<li><a>duan</a></li>
	</ul>
</div>