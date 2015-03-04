<%@ include file="layout/taglib.jsp" %>
	<div class="cadre">${message}</div>
	<div id="formCat" class="cadre">
		<f:form modelAttribute="user" action="authen" method="post">
			<table>
			   <tr>
					<td>Username</td>
					<td><f:input path="username" /></td>
					<td><f:errors path="username" cssClass="errors"></f:errors>
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td><f:input path="password" type="password"/></td>
					<td><f:errors path="password" cssClass="errors"></f:errors></td>
				</tr>
                <tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</f:form>
	</div>
