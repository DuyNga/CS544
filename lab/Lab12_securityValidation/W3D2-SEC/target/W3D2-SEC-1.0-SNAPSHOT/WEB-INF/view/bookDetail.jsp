<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${msg} a Book</title>
</head>

<body>
<form:form modelAttribute="book" action="../books">
    <table>
        <tr>
            <td></td>
            <td><form:hidden path="id"></form:hidden></td>

        </tr>
        <tr>
            <td>Title:</td>
            <td><form:input path="title"></form:input></td>

        </tr>
        <tr>
            <td>ISBN:</td>
            <td><form:input path="ISBN"></form:input></td>
        </tr>
        <tr>
            <td>Author:</td>
            <td><form:input path="author"></form:input></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><form:input path="price"></form:input></td>
        </tr>
    </table>
    <input type="submit"/>
</form:form>
<c:if test="${msg == 'Update'}">
    <form action="delete?bookId=${book.id}" method="post">
        <button type="submit">Delete</button>
    </form>
</c:if>
</body>

</html>