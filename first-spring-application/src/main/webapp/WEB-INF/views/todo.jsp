<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h1>Add To Do</h1>
<form:form    method="Post" commandName="todo">
<form:hidden path="id"/>
<form:hidden path="user"/>

<fieldset class="form-group">
<form:label path="desc">Description</form:label>
<form:input class="form-control"  type="text" path="desc" required="required" minlength="5"></form:input>

</fieldset>

<fieldset class="form-group">
<form:label path="targetDate">Target Date</form:label>
<form:input class="form-control"  type="text" path="targetDate" required="required" ></form:input>

</fieldset>


<input  class="btn btn-success" type="submit" value="Submit">
</form:form>


<hr>
<div >
<a class="btn btn-success" href="/spring-mvc/list-todos">Back</a>
</div>

</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</body>
</html>