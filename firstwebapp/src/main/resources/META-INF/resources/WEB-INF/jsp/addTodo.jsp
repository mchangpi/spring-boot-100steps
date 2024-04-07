<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css"
	rel="stylesheet" />
<title>Add Todo Page</title>
</head>
<body>
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

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'yyyy-mm-dd'
		});
	</script>
</body>
</html>
