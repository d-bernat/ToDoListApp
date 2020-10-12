<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dbernat
  Date: 12.10.2020
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Welcome</title>
    </head>
    <body>
        <h1>Welcome :-)</h1>
        <ul>
            <li>${user.name}</li>
            <li>${user.surName}</li>
            <li>${user.address}</li>
        </ul>
        <br>
        <form:form method="GET" action="/ToDoListApp/welcome" modelAttribute="user">
            <form:label path="name">Name</form:label>
            <form:input path="name" />
            <br>
            <form:label path="surName">Surname</form:label>
            <form:input path="surName"/>
            <br>
            <form:label path="address">Address</form:label>
            <form:input path="address"/>
            <br>
            <input type="submit" value="Submit" />
        </form:form>
    </body>
</html>
