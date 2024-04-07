<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Login Page</title>
</head>
<body>
	<div class="container">
		<h1 class="mt-3 mb-1">Welcome to Milton Todo List Page</h1>
		<h1 class="mt-1">Please log in:</h1>
		<pre>${errorMessage}</pre>
		<form method="post" class="d-flex flex-column align-items-center w-75 gap-3">
			<div
				class="d-flex flex-nowrap justify-content-between align-items-center w-100 gap-2">
				<div class="d-flex flex-wrap w-50 gap-2">
					<label class="w-25 text-center">Name:</label> 
					<input type="text" name="name" value="Milton" class="flex-grow-1" />
				</div>
				<div class="d-flex flex-wrap w-50 gap-2">
					<label class="w-25 text-center">Password:</label> 
					<input type="password" name="password" value="test" class="flex-grow-1" />
				</div>
			</div>
			<input type="submit" value="Login" class="btn btn-success w-100" />
		</form>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
