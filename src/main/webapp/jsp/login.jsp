<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Log in with your account</title>

<link href="${contextPath}/resource/css/bootstrap.min.css"
	rel="stylesheet">
	<link href="${contextPath}/resource/css/style.css"
	rel="stylesheet">

</head>
<body>
	<div class="login-form">    
    <form action="${contextPath}/login" method="post">
		
    	<h4 class="modal-title">Login to Your Account</h4>
			<div class="form-group ${error != null ? 'has-error' : ''}"><span>${message}</span>
            <input type="text" class="form-control" name="username" placeholder="Username" required="required" autofocus="true">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" required="required">
            <span style="color:red;">${error}</span> 
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
         
        <input type="submit" class="btn btn-primary btn-block btn-lg" value="Login"> 
        
         <div class="text-center small">Don't have an account? <a href="/signup">Sign up</a></div>             
    </form>	
    </div>

	<script src="${contextPath}/resource/js/jquery-3.3.1.min.js"></script>
	<script src="${contextPath}/resource/js/bootstrap.min.js"></script>
</body>
</html>