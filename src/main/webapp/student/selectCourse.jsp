<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/18
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选课</title>
</head>
<body>
<h1>学生选课</h1>
<table border="1">
    <tr>
        <th></th>
        <th>COURSE NAME</th>
        <th>OPERATION</th>
    </tr>
    <c:forEach var="course" items="${sessionScope.courses}">
        <tr>
            <td><input type="checkbox" value="${course.id}"></td>
            <td>${course.cname}</td>
            <td><a href="${ctx}/student/selectCourse/${course.id}">SELECT</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
