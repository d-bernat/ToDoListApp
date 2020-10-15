<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page  import="de.itbernat.springmvc.utils.AttributeNames" %>
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
        <form:form method="POST" modelAttribute="${AttributeNames.ITEM_MODEL_ATTRIBUTE}">
            <table>
                <tr>
                    <td><form:label path="title">Title</form:label></td>
                    <td><form:input path="title"/>${title}</td>
                </tr>
                <tr>
                    <td><form:label path="details">Details</form:label></td>
                    <td><form:input path="details"/></td>
                </tr>
                <tr>
                    <td><form:label path="deadline">Deadline</form:label></td>
                    <td><form:input path="deadline"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>
