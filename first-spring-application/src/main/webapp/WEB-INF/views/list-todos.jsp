<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
HI ${name }  <br>

<table class="table table-striped">
  <caption>Your Todos are : </caption>
  
  <thead>
  	<tr>
  		<th> Description </th>
  		<th>Target  Date  </th>
  		<th>Is Completd? </th>
  	</tr>
  </thead>
  
  <tbody>
  <c:forEach items="${todos}" var="todo">
  		<tr>
  			<td> ${todo.desc } </td>
  			<td> <fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" />  </td>
  			<td> ${todo.done }  </td>
  			<td>
  			<a href="/spring-mvc/update-todo?id=${todo.id}" class="btn btn-success">Update</a>
  			<a href="/spring-mvc/delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
  		</tr>
  	</c:forEach>
  </tbody>
</table>


 </BR>




<br>
<div>
	<a class="btn btn-success" href="/spring-mvc/add-todo">Add</a>
</div>


</div>

<%@ include file="common/footer.jspf" %>

