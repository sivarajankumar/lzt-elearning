<%@ include file="../layout/taglib.jsp"%>

<div class="content-top">
	<div class="wrap">
		<div class="section group">
			<div class="col span_2_of_contact">
				<div class="contact-form">
					<h3>
						<t:message code="modify_question" />
					</h3>
				
					<f:form modelAttribute="question_edit" method="POST" action="saveq">
						<div>
						    <f:input path="qestId" type="hidden"/>
						    <f:input path="test.id"  id="testid" type="hidden"/>
						    <input type="hidden" name="testid" value="${testid}"/>
							<span><label><t:message code="question" /></label></span> <span>
								<f:textarea path="questContent" rows="15" cols="100" />
							</span> <span><f:errors path="questContent" cssClass="errors"></f:errors></span>
						</div>
						
						<div>
							<span><label><t:message code="choice1" /></label></span> <span>
								<f:input path="collect1" />
							</span> <span><f:errors path="collect1" cssClass="errors"></f:errors></span>
						</div>
						<div>
							<span><label><t:message code="choice2" /></label></span> <span>
								<f:input path="collect2" />
							</span> <span><f:errors path="collect2" cssClass="errors"></f:errors></span>
						</div>
						<div>
							<span><label><t:message code="choice3" /></label></span> <span>
								<f:input path="collect3" />
							</span> <span><f:errors path="collect3" cssClass="errors"></f:errors></span>
						</div>
						<div>
							<span><label><t:message code="choice4" /></label></span> <span>
								<f:input path="collect4" />
							</span> <span><f:errors path="collect4" cssClass="errors"></f:errors></span>
						</div>
						
						<div>
							<span><label><t:message code="answer" /></label></span> 
							<span>
							  <f:select path="answer">
												<f:option value="0" label="--- Select ---" />
												<f:option value="1" label="Choice 1" />
												<f:option value="2" label="Choice 2" />
												<f:option value="3" label="Choice 3" />
												<f:option value="4" label="Choice 4" />
							  </f:select>
							</span>
						</div>
						
					    <div>
							<span><input type="submit"
								value="<t:message code="save"/>"></span>
						</div>


					</f:form>

				</div>

				
           </div>
		</div>
	
		<div class="clear"></div>
		<div class="wrap"></div>
	</div>
</div>
