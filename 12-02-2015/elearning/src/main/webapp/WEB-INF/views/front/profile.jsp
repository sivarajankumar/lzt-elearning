<%@ include file="../layout/taglib.jsp" %>
	<div class="content-top">
		<div class="wrap">

			<div class="section group">
				<div class="col span_2_of_contact">
					<div class="contact-form">
						<h3>Your profile</h3>
						<f:form modelAttribute="user" method="post" action="registration"
							enctype="multipart/form-data">
							<div>
								
								<span><label>First Name</label></span> <span> <f:input
										path="firstName" />
								</span> <span><f:errors path="firstName" cssClass="errors"></f:errors></span>
							</div>
							<div>
								<span><label>Last Name</label></span> <span> <f:input
										path="lastName" />
								</span> <span><f:errors path="lastName" cssClass="errors"></f:errors></span>
							</div>

							<div>
								<span><label>Login</label></span> <span> <f:input
										path="username" id="username" />
								</span> <span><f:errors path="username" cssClass="errors"></f:errors></span>
							</div>

							<div>
								<span><label>Password</label></span> <span> <f:input
										path="password" />
								</span> <span><f:errors path="password" cssClass="errors"></f:errors></span>
							</div>

							<div>
								<span><label>Email</label></span> <span> <f:input
										path="email" />
								</span> <span><f:errors path="email" cssClass="errors"></f:errors></span>
							</div>

							<div>
								<span><label>Address</label></span> <span> <f:textarea
										path="address" />
								</span> <span><f:errors path="address" cssClass="errors"></f:errors></span>
							</div>

							<div>
								<span><label>Photo</label></span> <span> <input
									type="file" name="file" />
								</span>

							</div>


							<div>
								<span><input type="submit" value="Register"></span>
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