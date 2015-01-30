<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="false"%>
<div class="wrap">
	<h1>Private Page!</h1>
	<ul>
		<c:forEach var="item" items="${lstUser}">
			<li><a href="javascript:void(0)" data-id="${item.getId()}"
				class="item-user">${item.getFirstName()}</a></li>
		</c:forEach>
	</ul>
	<h1>Your notify!</h1>
	<ul>
		<c:forEach var="item" items="${lstMessage}">
			<li>
				<div data-id="${item.getId()}" class="item-message">${item.getMessage()}</div>
			</li>
		</c:forEach>
	</ul>
</div>
<div class="template">
	<div id="dialog" title="Basic dialog">
		<form action="/sendMessage" id="message">
			<textarea name="message"></textarea>
			<input name="toUser" type="hidden" />
			<div class="clearfix"></div>
			<br> <input type="submit" value="send" />
		</form>
	</div>
</div>
