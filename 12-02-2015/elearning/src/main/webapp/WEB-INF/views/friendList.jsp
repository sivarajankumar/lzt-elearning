<%@ include file="layout/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="friendList-bot">
	<div class="wrap-content">
		<div class="friendList tab-friend">
			<h1 class="friend-status show-friend">
				<t:message code="click_to_chat"/> <b class="close none">X</b><b>^</b>
			</h1>
			<h1 class="friend-status hide-friend">
				<t:message code="click_to_off_chat"/> <b class="close none">X</b><b>v</b>
			</h1>
			<ul class="friends">
			</ul>
		</div>
	</div>
</div>
<div class="template">
	<div class="wrap-content" id="tab-friend">
		<div class="tab-friend">
			<h1 class="friend-status show-friend">
				Show chatter<b class="close">X</b>
			</h1>
			<h1 class="friend-status hide-friend">
				Hide chatter <b class="close">X</b> 
			</h1>
			<div class="message">
				<ul class="logchat"></ul>
			</div>
			<div class="message-wrap">
				<input name="message" class="message-input" /> <input type="button"
					value="Gui" class="message-button" />
			</div>
		</div>
	</div>
</div>