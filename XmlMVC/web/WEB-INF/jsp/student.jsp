<%--
  Created by IntelliJ IDEA.
  User: twx
  Date: 2017/3/19
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
    <h2>Student Information</h2>
    <sf:form method = "POST" action = "/addStudent" commandName="student">
        <table>
            <tr>
                <td>Name</td>
                <td><sf:input path = "name" /></td>
            </tr>
            <sf:errors path="name"/>
            <tr>
                <td>Age</td>
                <td><sf:input path = "age" /></td>
            </tr>
            <tr>
                <td>Id</td>
                <td><sf:input path = "id" /></td>
            </tr>
            <tr>
                <td colspan = "2">
                    <input type = "submit" value = "Submit"/>
                </td>
            </tr>
        </table>
    </sf:form>
</body>
</html>
