<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style>
.footer{
flex-shrink:0;
background-color:#343a40;
text-align: center;
    padding: 30px;
}
</style>
</head>
<body>

<script src="${contextPath}/resource/js/form.js"></script>
<script src="${contextPath}/resource/js/bootstrap.min.js"></script>
<script>
    $('#targetDate').datepicker({
        format: 'dd/mm/yyyy'
    });
</script>

<footer class="footer">
&copy; Copyright 2018
 </footer>
</body>
</html>