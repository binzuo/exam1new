<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>student add page</title>
    </head>
    <body>
        <h1>ADD Student</h1>
        <form action="${ctx}/student/add" method="post">
            <input name="sname" placeholder="SNAME"><br>
            <select name="departmentId">
                <c:forEach var="department" items="${sessionScope.departments}">
                    <option value="${department.id}">${department.dname}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="ADD">
        </form>
    </body>
</html>