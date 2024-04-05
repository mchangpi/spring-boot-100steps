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

    <title>List Todos Page</title>
  </head>
  <body>
    <div>Welcome to Milton Learn Spring Page, ${name}</div>
    <hr />
    <h1>Your Todos are</h1>
    <table>
      <thead>
        <tr>
          <th>id</th>
          <th>Description</th>
          <th>Target Date</th>
          <th>Is Done?</th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${todos}" var="todo">
          <tr>
            <td>${todo.id}</td>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
            <td>
              <a href="delete-todo?id=${todo.id}" class="btn btn-warning"
                >Delete</a
              >
            </td>
            <td>
              <a href="update-todo?id=${todo.id}" class="btn btn-success"
                >Update</a
              >
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
  </body>
</html>
