<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Create an account</title>

<link href="${contextPath}/resource/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resource/css/style.css"
	rel="stylesheet"></head>

<body>

	

<div class="login-form">   

		<form:form method="POST" modelAttribute="user">
			<h4 class="modal-title">Create your account</h4>
			
				<div class="form-group ">
					<form:input type="text" path="username" class="form-control"
						placeholder="Username" autofocus="true" required="required"></form:input>
					<form:errors path="username" cssClass="text-warning"></form:errors>
				</div>
			

			
				<div class="form-group ">
					<form:input type="password" path="password" class="form-control"
						placeholder="Password" required="required"></form:input>
					<form:errors path="password" cssClass="text-warning"></form:errors>
				</div>
			


		
				<div class="form-group ">
					<form:input type="text" path="email" class="form-control"
						placeholder="Email" required="required"></form:input>
					<form:errors path="email" cssClass="text-warning"></form:errors>
				</div>
	

			
				<div class="form-group ">
					<form:input type="text" path="address" class="form-control"
						placeholder="Address" required="required"></form:input>
					<form:errors path="address" cssClass="text-warning"></form:errors>
				</div>
		

			<input type="submit" class="btn btn-primary btn-block btn-lg" value="Signup"> 
			
			 <div class="text-center small">Already have an account? <a href="/login">Login</a> here!</div> 
		</form:form>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resource/js/bootstrap.min.js"></script>
</body>
</html>