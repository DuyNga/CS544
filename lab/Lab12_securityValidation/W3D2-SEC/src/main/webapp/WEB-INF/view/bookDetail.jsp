<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap.min.css"/>">
    <title>${msg} a Book</title>
</head>

<body>
<form:form modelAttribute="book" action="../books">
    <form:errors path="*" cssClass="alert-danger" />
    <table>
        <tr>
            <td></td>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>Title:</td>
            <td><form:input path="title"></form:input></td>
            <td><form:errors path="title" cssClass="alert-danger"/> </td>

        </tr>
        <tr>
            <td>ISBN:</td>
            <td><form:input path="ISBN"></form:input></td>
            <td><form:errors path="ISBN" cssClass="alert-danger"/> </td>
        </tr>
        <tr>
            <td>Author:</td>
            <td><form:input path="author"></form:input></td>
            <td><form:errors path="author" cssClass="alert-danger"/> </td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><form:input path="price"></form:input></td>
            <td><form:errors path="price" cssClass="alert-danger"/> </td>
        </tr>
    </table>
    <input type="submit"/>
</form:form>

<%--<c:if test="${sessionScope.user.role == 'ADMIN'}">--%>
    <c:if test="${msg == 'Update'}">
        <form action="delete?bookId=${book.id}" method="post">
            <button type="submit">Delete</button>
            <sec:csrfInput />
        </form>
    </c:if>
<%--</c:if>--%>

</body>

</html>