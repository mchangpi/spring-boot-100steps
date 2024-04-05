<html>
	<head>
		<title> My Login Page - JSP</title>
	</head>
	<body>
		Welcome to Milton Learn Spring Login page 
		<pre>${errorMessage}</pre>
		<form method="post">
			Name: <input type="text" name="name" value="Milton">
			Password: <input type="password" name="password" value="test">
			<input type="submit">
		</form>
	</body>
</html>