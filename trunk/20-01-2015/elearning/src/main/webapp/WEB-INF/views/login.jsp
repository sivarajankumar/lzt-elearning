<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">
</head>
<body>
 <div class="cadre"></div>
 <div  class="cadre">
  <f:form modelAttribute="user" action="authenticate" method="post">
   <table>
    <tr>
     <td>Username : </td>
     <td><f:input path="userName" /></td>
     <td><f:errors path="userName" cssClass="errors"></f:errors>
     </td>
    </tr>
    <tr>
     <td>Password :</td>
     <td><f:input path="password" /></td>
     <td><f:errors path="password" cssClass="errors"></f:errors>
     </td>
    </tr>
    <tr>
     <td><input type="submit" value="Save"></td>
    </tr>
   </table>
  </f:form>

 </div>
</body>
</html>