<%@ include file="../layout/taglib.jsp"%>
<div class="content-top">
	<div class="wrap">

		<div class="section group">
			<div class="col span_2_of_contact">
				<div class="contact-form">
					<h3>
						<t:message code="login" />
					</h3>
					<c:choose>
						<c:when test="${not empty idTest}">
						
							<f:form modelAttribute="user" method="post" action="authentest">

								<input name="idTest" value="${idTest}" type="hidden" />
								<div>
									<span><label><t:message code="username" /></label></span> <span>
										<f:input path="username" />

									</span> <span><f:errors path="username" cssClass="errors"></f:errors></span>
								</div>
								<div>
									<span><label><t:message code="password" /></label></span> <span><f:input
											path="password" type="password" /></span> <span><f:errors
											path="password" cssClass="errors"></f:errors></span>
								</div>

								<div>
									<span><input type="submit"
										value="<t:message code="submit"/>"></span>
								</div>


							</f:form>

						</c:when>
						<c:otherwise>
							<f:form modelAttribute="user" method="post" action="authen">
								<input name="idCourse" value="${idCourse}" type="hidden" />


								<div>
									<span><label><t:message code="username" /></label></span> <span>
										<f:input path="username" />

									</span> <span><f:errors path="username" cssClass="errors"></f:errors></span>
								</div>
								<div>
									<span><label><t:message code="password" /></label></span> <span><f:input
											path="password" type="password" /></span> <span><f:errors
											path="password" cssClass="errors"></f:errors></span>
								</div>

								<div>
									<span><input type="submit"
										value="<t:message code="submit"/>"></span>
								</div>


							</f:form>

						</c:otherwise>
					</c:choose>



					</br> </br>
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