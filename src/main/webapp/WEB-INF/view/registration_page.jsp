<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HARDIK
  Date: 06-01-2020
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>User Registration Page</title>
</head>
<body>
    <center>
        <h3>Student Registration Page</h3>
        <br>
        <hr>
    <form:form method="post" modelAttribute="user" action="processForm" enctype="multipart/form-data">
        <table cellspacing="10px" cellpadding="10px">
        <tr><td>Enter Username : </td><td><form:input class="form-control" path="username"/></td></tr>
        <tr><td>Enter Email : </td><td><form:input type="email" class="form-control" path="email"/></td></tr>
        <tr><td>Enter Password : </td><td><form:password class="form-control" path="password"/></td></tr>
        <tr><td>Enter dob : </td><td><form:input class="form-control" path="dob" type="date" /></td></tr>
        <tr><td>Profile picture : </td><td><input class="form-control" type="file" name="profilepic" /></td></tr>
        <tr><td colspan="2"><center><input class="btn btn-success" type="submit" value="Register"></center></td></tr>
        </table>
    </form:form>
    </center>
</body>
</html>
