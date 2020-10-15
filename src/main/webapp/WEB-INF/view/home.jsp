<%--
  Created by IntelliJ IDEA.
  User: dbernat
  Date: 15.10.2020
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="de.itbernat.springmvc.utils.Mappings" %>
<html>
<head>
    <title>Todo List Application</title>
</head>
<body>
    <div align="center">
        <c:url var="itemsLink" value="${Mappings.TODO_ITEM_ITEMS_PATH}"/>
        <h2><a href="${itemsLink}">Show Todo Items</a></h2>
    </div>
</body>
</html>
