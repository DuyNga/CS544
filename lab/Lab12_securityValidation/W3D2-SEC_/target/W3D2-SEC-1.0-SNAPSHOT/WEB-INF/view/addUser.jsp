<%--
  Created by IntelliJ IDEA.
  User: duynga
  Date: 7/9/19
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New User</title>
</head>
<body>
<form:form modelAttribute="user">
    <table>
        <tr>
            <td>User Name: </td>
            <td><form:input path="userName"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td>Roles:</td>
            <td><form:select path="roles" itemLabel="name" itemValue="id" items="${authorities}"/></td>
        </tr>
        <input type="submit"/>
    </table>
</form:form>
</body>
</html>
