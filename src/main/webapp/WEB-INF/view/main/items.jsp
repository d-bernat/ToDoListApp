<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="de.itbernat.springmvc.utils.Mappings" %>
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
        <div align="center">
            <c:url var="itemsLink" value="${Mappings.TODO_ITEM_ADD_ITEM_PATH}"/>
            <h2><a href="${itemsLink}">New Todo Item</a></h2>
        </div>
        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h3>Todo Items</h3></caption>
                <tr>
                    <th>Title</th>
                    <th>Details</th>
                    <th>Deadline</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${itemsWrapper.items}" var="item">
                    <c:url var="deleteUrl" value="${Mappings.TODO_ITEM_REMOVE_ITEM_PATH}">
                        <c:param name="id" value="${item.id}"/>
                    </c:url>
                    <c:url var="editUrl" value="${Mappings.TODO_ITEM_EDIT_ITEM_PATH}">
                        <c:param name="id" value="${item.id}"/>
                    </c:url>
                    <tr>
                        <td><c:out value="${item.title}"/></td>
                        <td><c:out value="${item.details}"/></td>
                        <td><c:out value="${item.deadline}"/></td>
                        <td><a href="${editUrl}"/>Edit</td>
                        <td><a href="${deleteUrl}"/>Delete</td>
                    </tr>
                </c:forEach>

            </table>
            <ul>
            </ul>
        </div>
    </body>
</html>
