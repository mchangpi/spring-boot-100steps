<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>Enter Todo Details:</h1>

	<form:form method="post" modelAttribute="newTodo">
		<fieldset class="mb-2">
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required" />
			<form:input type="hidden" path="id" />
			<form:input type="hidden" path="done" />
		</fieldset>
		<fieldset class="mb-2">
			<form:label path="targetDate">Target Date</form:label>
			<form:input type="text" path="targetDate" required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>

		<div class="d-flex gap-3 my-3">
			<a href="list-todos">
				<button type="button" class="btn btn-warning">Cancel</button>
			</a> <input type="submit" value="Submit" class="btn btn-success" />
		</div>
		<br />
		<form:errors path="description" cssClass="text-danger" />
		<form:errors path="targetDate" cssClass="text-danger" />
	</form:form>
</div>

<%@ include file="common/footer.jspf"%>

<script type="text/javascript">
	$('#targetDate').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>
