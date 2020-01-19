<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HARDIK
  Date: 06-01-2020
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>User login page</title>
</head>
<body>
    <center>
        <h1>User Login page</h1>
        <br>
        <hr>
        <br>
        <form:form action="show_user" method="get" >
            <table cellspacing="10px" cellpadding="10px">
                <tr><td>Username : </td><td><input class="form-control" type="text" name="username"/></td></tr>
            <br>
                <tr><td>Password : </td><td><input class="form-control" name="password" type="password"/></td></tr>
            <br>
            <br>
            <tr><td colspan="2"><center><input class="btn btn-success" type="submit" value="Click me"></center></td></tr>
            </table>
        </form:form>
    </center>
</body>
</html>
