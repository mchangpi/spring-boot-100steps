<html>
	<head>
		<title> My Login Page - JSP</title>
	</head>
	<body>
		Welcome to Login page with JSP
		<pre>${errorMessage}</pre>
		<form method="post">
			Name: <input type="text" name="name" value="milton">
			Password: <input type="password" name="password" value="test">
			<input type="submit">
		</form>
	</body>
</html>