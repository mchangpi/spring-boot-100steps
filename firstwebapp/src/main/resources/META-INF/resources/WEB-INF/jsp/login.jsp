<!DOCTYPE html>
<html>
  <head>
    <link
      href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <title>Login Page</title>
  </head>
  <body>
    <div class="container">
      <h1 class="mt-3 mb-1">Welcome to Milton Todo List Page</h1>
      <h1 class="mt-1">Please log in:</h1>
      <pre>${errorMessage}</pre>
      <form method="post" class="d-flex flex-nowrap gap-1">
        Name: <input type="text" name="name" value="Milton" /> Password:
        <input type="password" name="password" value="test" />
        <input type="submit" class="px-2"/>
      </form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>
