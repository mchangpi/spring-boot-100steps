
  	<%@ include file="common/header.jspf" %>
  	<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<h4>Enter ToDo Details</h4>
		<hr>
		<form:form method = "post" modelAttribute = "toDo"><!-- 2 way binding -->
			<fieldset>
				<form:label path = "description" cssStyle="width: 90px">Description:</form:label>
				<form:input type = "text" path = "description" required="required" size="50"/>	
				<br>
				<form:errors path="description" cssClass = "text-danger"/>
			</fieldset>
			<br>
			<fieldset>
				<form:label path = "targetDate" cssStyle="width: 90px">Target Date:</form:label>
				<form:input type = "text" path = "targetDate" required="required"/>	
				<br>
				<form:errors path="targetDate" cssClass="text-danger"/>
			</fieldset>
			<form:input type = "hidden" path = "id" />
			<br>
			<fieldset>
				<form:label path="done" cssStyle="width: 90px">Is Done?:</form:label>
				<form:checkbox path="done" value="isDone" cssStyle="width: 20px;height: 20px"/>
			</fieldset>
			<br>
			<input type = "submit" class="btn btn-success" style="width: 80px"/>
			<a href="listtodos" class="btn btn-warning mx-3" style="width: 80px">Cancel</a>
		</form:form>
	</div>
	<%@ include file="common/footer.jspf" %>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format: 'yyyy-mm-dd'
		});
	</script>