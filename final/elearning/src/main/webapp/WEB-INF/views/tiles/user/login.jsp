<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<div class="wrap">
<f:form modelAttribute="user" action="index" method="post">
	<table>
		<tr>
			<td>Username :</td>
			<td><f:input path="firstName" /></td>
			<td><f:errors path="firstName" cssClass="errors"></f:errors></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><f:input path="password" /></td>
			<td><f:errors path="password" cssClass="errors"></f:errors></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save"></td>
		</tr>
	</table>
</f:form>
</div>