<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<script type="text/javascript" src="${contextPath}/resource/js/form.js" ></script>
<div class="container-fluid">
	<div class="row no-gutters">
		<div class="col-sm-3 col-md-4 col-lg-3">
			<div class="profile">
				<ul>
					<h2>${user.username}</h2>
					<p>${user.email}</p>
					<p>${user.address}</p>
				</ul>
			</div>
		</div>
		<div class="col-sm-9 col-md-8 col-lg-6">
		<h1 style="text-align:center;">Write your day</h1>
		 <hr style="border: 1px solid  #999;">
			<div class="form">
				<form:form modelAttribute="diary" method="post"
					enctype="multipart/form-data">
						  <form:hidden path="id" ></form:hidden>
						
					<div class="row form-group">
						<div class="col-6 col-md-4 form-label">Your day</div>
						<div class="col-12 col-md-8">
					
							<form:textarea class="form-control" name="description"
								path="description" placeholder="Your day..." required="required" id="post-text"></form:textarea>
								<div id="counter">
                                    <p id="counter-line"><span id="characters-number">150</span> symbols left.</p>
                                </div>

						</div>
					</div>
					<div class=" row form-group" style="display: flex;">
						<div class="col-6 col-md-4 ">
							<form:label path="image">Upload image</form:label>
						</div>
						<div class="col-12 col-md-8">
							<div class="input-group">
								<label class="input-group-btn"> <span
									class="btn btn-primary"><span class="fa fa-image"></span>
									<form:input id="file" type="file" style="display:none;" name="image" path="image"></form:input>
								</span>
								</label>
								 <form:input type="text" class="form-control" path="image" ></form:input>
							</div>
						</div>
					</div>

					<div class="row justify-content-end">

						<div class="col-12 col-md-8">
							<button id="create-post-button" type="submit" class="btn btn-primary btn-lg btn-block">Record</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="col-sm-3 col-md-4 col-lg-3"></div>


	</div>
</div>

<%@ include file="common/footer.jsp"%>