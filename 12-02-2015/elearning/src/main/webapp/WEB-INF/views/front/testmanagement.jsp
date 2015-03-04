<%@ include file="../layout/taglib.jsp"%>

<div class="content-top">
	<div class="wrap">
		<div class="section group">
			<div class="col span_2_of_contact">
				<div class="contact-form">
					<h3>
						<t:message code="test_management" />
					</h3>
					<c:if test="${createtest.id!=null}">
						<div>
							<span> <a
								href="<%=request.getContextPath()%>/test_management"><t:message
										code="add_new_test" /></a>
							</span>
						</div>
					</c:if>
					<f:form modelAttribute="createtest" method="POST" action="savef"
						enctype="multipart/form-data">

						<div>
							<f:input path="user.idUser" type="hidden"
								value="${sessionScope.userFLogin.idUser}" />
							<f:input path="id" type="hidden" id="idT"/>
							<span><label><t:message code="title" /></label></span> <span>
								<f:input path="title" />
							</span> <span><f:errors path="title" cssClass="errors"></f:errors></span>
						</div>

						<div>
							<span><label><t:message code="description" /></label></span> <span>
								<f:textarea path="description" rows="15" cols="100" />
							</span> <span><f:errors path="description" cssClass="errors"></f:errors></span>
						</div>
						<div>
							<span><label><t:message code="photo" /></label></span> <span>
								<c:if test="${createtest.id!=null}">
									<img
										src="<%=request.getContextPath()%>/photoTestf/${createtest.id}"
										width="125px" height="125px" />
								</c:if>
							</span> <span><input type="file" name="file" /></span>
						</div>

						<div>
							<span><label><t:message code="pdf_link" /></label></span> <span><a
								href="photoPdf">linkpdf</a></span> <span><input type="file"
								name="filepdf" /></span>
						</div>


						<div>
							<span><input type="submit"
								value="<t:message code="save"/>"></span>
						</div>


					</f:form>

				</div>

				<div class="contact-form">
					<table>
						<tr>
							<th><t:message code="id" /></th>
							<th><t:message code="title" /></th>
							<th><t:message code="description" /></th>
							<th><t:message code="pdf_link" /></th>
							<th><t:message code="delete" /></th>
							<th><t:message code="edit" /></th>
						</tr>
						<c:forEach items="${listtest}" var="test">
							<tr>
								<td>${test.id}</td>
								<td>${test.title}</td>
								<td>${test.description}</td>
								<td>${test.videolink}</td>
								<td><a href="delTestf?idTest=${test.id}"><t:message
											code="delete" /></a></td>
								<td><a href="editTestf?idTest=${test.id}"><t:message
											code="edit" /></a></td>
							</tr>
						</c:forEach>
					</table>
				</div>

			</div>
		</div>
		<c:if test="${createtest.id!=null}">
			<div class="col span_1_of_contact">
				<div>
					<a href="#" id="addques">Add a question to this test</a>
				</div>
				<div class="contact-form">
					<table>
						<tr>
							<th><t:message code="id" /></th>
							<th><t:message code="question" /></th>
							<th><t:message code="choice1" /></th>
							<th><t:message code="choice2" /></th>
							<th><t:message code="choice3" /></th>
							<th><t:message code="choice4" /></th>
							<th><t:message code="answer" /></th>
							<th><t:message code="delete" /></th>
							<th><t:message code="edit" /></th>
						</tr>
						<c:forEach items="${listques}" var="ques">
							<tr>
								<td>${ques.qestId}</td>
								<td><input id="content${ques.qestId}" type="hidden" value="${ques.questContent}"> 
								  ${ques.questContent}
								</td>
								<td>${ques.collect1}</td>
								<td>${ques.collect2}</td>
								<td>${ques.collect3}</td>
								<td>${ques.collect4}</td>
								<td>${ques.answer}</td>
								<td>
								 <a href="question/remove/${ques.test.id}/${ques.qestId}"  class="btn btn-danger triggerRemove"><t:message code="delete" /></a>
								</td>
								<td><a href="question?idT=${ques.test.id}&idQ=${ques.qestId}" ><t:message code="edit" /></a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<f:form commandName="question" cssClass="form-horizontal"
					action="addQuestion" method="POST">

					<div class="modal fade" id="add">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title">Add a question to Test</h4>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label for="questContent" class="col-sm-2 control-label">Question:</label>
										<div class="col-sm-10">
											<f:input path="questContent" cssClass="form-control" id="ques"/>
											<f:input path="test.id"  id="testid" type="hidden"/>
										</div>
									</div>

									<div class="form-group">
										<label for="collect1" class="col-sm-2 control-label">Choice
											1:</label>
										<div class="col-sm-10">
											<f:input path="collect1" cssClass="form-control" />
										</div>
									</div>

									<div class="form-group">
										<label for="collect2" class="col-sm-2 control-label">Choice
											2:</label>
										<div class="col-sm-10">
											<f:input path="collect2" cssClass="form-control" />
										</div>
									</div>

									<div class="form-group">
										<label for="collect3" class="col-sm-2 control-label">Choice
											3:</label>
										<div class="col-sm-10">
											<f:input path="collect3" cssClass="form-control" />
										</div>
									</div>

									<div class="form-group">
										<label for="collect4" class="col-sm-2 control-label">Choice
											4:</label>
										<div class="col-sm-10">
											<f:input path="collect4" cssClass="form-control" />
										</div>
									</div>

									<div class="form-group">
										<label for="answer" class="col-sm-2 control-label">Answer:</label>
										<div class="col-sm-10">
											 <f:select path="answer">
												<f:option value="0" label="--- Select ---" />
												<f:option value="1" label="Choice 1" />
												<f:option value="2" label="Choice 2" />
												<f:option value="3" label="Choice 3" />
												<f:option value="4" label="Choice 4" />
											</f:select>
										</div>
									</div>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
									<input type="submit" class="btn btn-primary"
										value="<t:message code="save"/>">
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
				</f:form>
				
					<div class="modal fade" id="modalRemove">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title">Remove question</h4>
								</div>
								<div class="modal-body">
								 Really remove ?
								 <input  id="testid_del" name="idt_del" type="hidden"/>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Cancel</button>
									<a href="" class="btn btn-danger removeBtn">Remove</a>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
				
			</div>
		</c:if>
		<div class="clear"></div>
		<div class="wrap"></div>
	</div>
</div>
