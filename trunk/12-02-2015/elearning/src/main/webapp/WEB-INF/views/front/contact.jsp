<%@ include file="../layout/taglib.jsp" %>
	<div class="content-top">
		<div class="wrap">

			<div class="section group">
				<div class="col span_2_of_contact">
					<div class="contact-form">
						<h3><t:message code="send_msg"/></h3>
						<f:form modelAttribute="contactForm" method="post" action="SendMessage"
							enctype="multipart/form-data">
							<div>
								
								<span><label><t:message code="name"/></label></span> <span> <f:input
										path="name" />
								</span> <span><f:errors path="name" cssClass="errors"></f:errors></span>
							</div>
							<div>
								<span><label><t:message code="email"/></label></span> <span> <f:input
										path="email" />
								</span> <span><f:errors path="email" cssClass="errors"></f:errors></span>
							</div>

							
							<div>
								<span><label><t:message code="message"/></label></span> <span> <f:textarea
										path="message" />
								</span> <span><f:errors path="message" cssClass="errors"></f:errors></span>
							</div>


							<div>
								<span><input type="submit" value="<t:message code="send"/>" ></span>
							</div>


						</f:form>
						
					
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
