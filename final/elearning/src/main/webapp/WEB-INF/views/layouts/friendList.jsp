<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="friendList-bot">
	<div class="wrap-content">
		<div class="friendList tab-friend">
			<h1 class="friend-status show-friend">
				Click to chat <b class="close none">X</b><b>^</b>
			</h1>
			<h1 class="friend-status hide-friend">
				Click to off chat <b class="close none">X</b><b>v</b>
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