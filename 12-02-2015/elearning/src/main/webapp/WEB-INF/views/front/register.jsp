<%@ include file="../layout/taglib.jsp" %>
<html>
<head>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('username').click(function() {
			alert('hello');

		});
	});
</script>
</head>

<body>
	<div class="content-top">
		<div class="wrap">

			<div class="section group">
				<div class="col span_2_of_contact">
					<div class="contact-form">
						<h3><t:message code="registration"/></h3>
						<f:form modelAttribute="user" method="post" action="registration"
							enctype="multipart/form-data">
							<div>
								
								<span><label><t:message code="firstname"/></label></span> <span> <f:input
										path="firstName" />
								</span> <span><f:errors path="firstName" cssClass="errors"></f:errors></span>
							</div>
							<div>
								<span><label><t:message code="lastname"/></label></span> <span> <f:input
										path="lastName" />
								</span> <span><f:errors path="lastName" cssClass="errors"></f:errors></span>
							</div>

							<div>
								<span><label><t:message code="username"/></label></span> <span> <f:input
										path="username" id="username" />
								</span> <span><f:errors path="username" cssClass="errors"></f:errors></span>
							</div>

							<div>
								<span><label><t:message code="password"/></label></span> <span> <f:input
										path="password" />
								</span> <span><f:errors path="password" cssClass="errors"></f:errors></span>
							</div>

							<div>
								<span><label><t:message code="email"/></label></span> <span> <f:input
										path="email" />
								</span> <span><f:errors path="email" cssClass="errors"></f:errors></span>
							</div>

							<div>
								<span><label><t:message code="address"/></label></span> <span> <f:textarea
										path="address" />
								</span> <span><f:errors path="address" cssClass="errors"></f:errors></span>
							</div>

							<div>
								<span><label><t:message code="photo"/></label></span> <span> <input
									type="file" name="file" />
								</span>
							</div>
  							
  						    <div>
								<span><input type="submit" value="<t:message code="register"/>"></span>
							</div>

						</f:form>
						</br>
						</br>
						<p>
							<span>Click here to <a href="register">register</a> if you
								haven't the account
							</span>
						</p>
					</div>
				</div>
				<div class="col span_1_of_contact">
					<div class="company_address">
						<h3>Company Information :</h3>
						<p>500 Lorem Ipsum Dolor Sit,</p>
						<p>22-56-2-9 Sit Amet, Lorem,</p>
						<p>Phone:(00) 222 666 444</p>
						<p>Fax: (000) 000 00 00 0</p>
						<p>
							Email: <span>info[at]mycompany.com</span>
						</p>
						<p>
							Follow on: <span>Facebook</span>, <span>Twitter</span>
						</p>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
</body>
</html>