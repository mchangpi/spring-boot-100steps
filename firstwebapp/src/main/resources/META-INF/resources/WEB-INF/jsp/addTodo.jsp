<%@ taglib prefix="c" uri="jakarta.tags.core" %> 

<!DOCTYPE html>
<html>
  <head>
    <link
      href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css"
      rel="stylesheet"
    />
    <title>Add Todo Page</title>
  </head>
  <body>
    <div class="container">
      <h1>Enter Todo Details:</h1>

      <form method="post" >
        Description:
        <input type="text" name="description" />
        <input type="hidden" name="id" />
        <input type="hidden" name="done" />
        <input type="submit" class="btn btn-success" />
      </form>
      <!--
      <form:form method="post" modelAttribute="addTodo">
        Description:
        <form:input type="text" path="description" required="required" />
        <form:input type="hidden" path="id" />
        <form:input type="hidden" path="done" />
        <input type="submit" class="btn btn-success" />
      </form:form>-->
      <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
      <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
      <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    </div>
  </body>
</html>
