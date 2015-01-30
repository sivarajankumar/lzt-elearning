<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="header">
	<div class="status-bar">
		<div class="wrap">
		<c:if test="${lztuser!=null}">
			<a href="/elearning/user/logout">LogOut</a>
			<h2>WellCome ${lztuser.getFirstName()}</h2>
		</c:if>
		<c:if test="${lztuser==null}">
			<a href="/elearning/user/index">LogIn</a>
		</c:if>
		</div>
	</div>
	<div class="header-top">
		<div class="wrap">
			<div class="logo">
				<a href="index.html"><img
					src="<%=request.getContextPath()%>/resources/theme/strickly/images/logo.png"
					alt=""></a>
			</div>
			<div class="search_box">
				<form>
					<input type="text" value="Search" onfocus="this.value = '';"
						onblur="if (this.value == '') {this.value = 'Search';}"><input
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
					<li class='active'><a href='index.html'><span>Home</span></a></li>
					<li><a href='about.html'><span>About</span></a></li>
					<li class='has-sub'><a href='services.html'><span>Services</span></a>
						<ul>
							<li class='has-sub'><a href='services.html'><span>Service
										1</span></a></li>
							<li class='has-sub'><a href='services.html'><span>Service
										2</span></a></li>
						</ul></li>
					<li><a href='gallery.html'><span>Gallery</span></a></li>
					<li><a href='blog.html'><span>Blog</span></a></li>
					<li class='last'><a href='contact.html'><span>Contact</span></a></li>

				</ul>
				<div class="clear"></div>
			</div>
		</div>
	</div>
</div>