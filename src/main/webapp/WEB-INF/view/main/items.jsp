<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import=" de.itbernat.springmvc.model.ToDoItemsWrapper" %>

<%--
  Created by IntelliJ IDEA.
  User: dbernat
  Date: 14.10.2020
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>todo list</title>
    </head>
    <body>
        <div>
            <ul>
                <c:forEach items="${itemsWrapper.items}" var="item">
                    <li>${item}</li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
