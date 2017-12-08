<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
</head>
<body>
<form id="regForm" action="registerProcess" method="post">
    <table align="center">
        <tr>
            <td><label for="username">Username</label></td>
            <td><input type="text" name="username" id="username" />
            </td>
        </tr>
        <tr>
            <td><label for="password">Password</label></td>
            <td><input type="password" name="password" id="password" /></td>
        </tr>
        <tr>
            <td><label for="email">Email</label></td>
            <td><input type="email" name="email" id="email" /></td>
        </tr>
        <tr>
            <td></td>
            <td><button id="register" name="register">Register</button>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td></td>
            <td><a href="home.jsp">Home</a></td>
        </tr>
    </table>
</form>
</body>
</html>