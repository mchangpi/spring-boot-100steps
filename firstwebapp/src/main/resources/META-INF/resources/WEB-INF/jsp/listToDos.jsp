  	<%@ include file="common/header.jspf" %>
  	<%@ include file="common/navigation.jspf" %>
  	<div class="container">
		<h4>Welcome ${name}</h4>
		<hr>
		<h5>Your ToDo List are</h5>
			<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>		
				<c:forEach items="${toDos}" var="toDo">
					<tr>
						<td>${toDo.description}</td>
						<td>${toDo.targetDate}</td>
						<td>${toDo.done}</td>
						<td><a href="updatetodo?id=${toDo.id}" class="btn btn-success">Update</a></td>
						<td><a href="deletetodo?id=${toDo.id}" class="btn btn-warning">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
			<a href="addtodo" class="btn btn-success">Add ToDo</a>
	</div>
	<%@ include file="common/footer.jspf" %>