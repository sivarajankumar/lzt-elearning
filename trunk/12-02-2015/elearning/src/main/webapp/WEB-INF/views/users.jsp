<%@ include file="layout/taglib.jsp" %>
   <div class="cadre">
    Users Management
   </div>
	<div id="formCat" class="cadre">
		<f:form modelAttribute="user" action="saveUser" method="post"
			enctype="multipart/form-data">
			<table>
		    	<tr>
					<td><f:input path="idUser" type="hidden"/></td>
				</tr>
				<tr>
					<td>Firstname</td>
					<td><f:input path="firstName" /></td>
					<td><f:errors path="firstName" cssClass="error"></f:errors>
					</td>
				</tr>
				
				<tr>
					<td>Lastname</td>
					<td><f:input path="lastName" /></td>
					<td><f:errors path="lastName" cssClass="error"></f:errors>
					</td>
				</tr>
				
					<tr>
					<td>Username</td>
					<td><f:input path="username" /></td>
					<td><f:errors path="username" cssClass="error"></f:errors>
					</td>
				</tr>
				
				<tr>
					<td>Password</td>
					<td><f:input path="password" /></td>
					<td><f:errors path="password" type="password" cssClass="error"></f:errors>
					</td>
				</tr>
				
				 <tr>
					<td>Type user</td>
					<td>
					
					<f:select path="typeUser">
					
					 <f:option value="User" selected="selected">Admin</f:option>  
                  	 <f:option value="teacher">Teacher</f:option>  
                     <f:option  value="student">Student</f:option>  
                  </f:select>  
					
					</td>
				</tr>
				
				<tr>
					<td>Email</td>
					<td><f:input path="email" /></td>
					<td><f:errors path="email" cssClass="error"></f:errors>
					</td>
				</tr>        
				<tr>
					<td>Address</td>
					<td><f:textarea path="address"  rows="5" cols="40"/></td>
					<td><f:errors path="address" cssClass="error"></f:errors>
					</td>
				</tr>

                <tr>
					<td>Description</td>
					<td><f:textarea path="description"  rows="5" cols="40"/></td>
					<td>
					</td>
				</tr>

				<tr>
					<td>Photo</td>
					<td>
					 <c:if test="${user.idUser!=null}">
					   <img src="photoUser?idUser=${user.idUser}" width="125px" height="125px"/>
					 </c:if>
					</td>
					<td>
					<input type="file" name="file" /></td>
				</tr>
				<tr>
					<td>Active</td>
					<td><f:checkbox path="active" value="true"  ></f:checkbox></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save"></td>
				</tr>
			</table>
		</f:form>
	</div>
	
	
	<div id="tabCategories" class="cadre">
	  <table class="tab1">
	    <tr>
	       <th>ID</th><th>Firstname</th><th>Lastname</th><!-- <th>Username</th><th>Password</th>--><th>Address</th><th>PHOTO</th><th></th><th></th>
	    </tr>
	    
	    <c:forEach items="${users}" var="user">
	      <tr>
	        <td>${user.idUser}</td>
	        <td>${user.firstName}</td>
	        <td>${user.lastName}</td> <!-- 
	        <td>${user.username}</td>
	        <td>${user.password}</td> -->
	        <td>${user.address}</td>
	        <td><img src="photoUser?idUser=${user.idUser}" width="125px" height="125px"/></td>
	        <td> <a href="suppUser?idUser=${user.idUser}">Supp</a></td>
	        <td> <a href="editUser?idUser=${user.idUser}">Edit</a></td>
	      </tr>
	    </c:forEach>
	    
	  </table>
	</div>
