<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>student edit page</title>
    </head>
    <body>
        <h1>EDIT Student</h1>
        <form action="${ctx}/student/modify" method="post">
            <input type="hidden" name="id" value="${sessionScope.student.id}">
            SNAME: <input name="sname" value="${sessionScope.student.sname}"><br>
            DEAPRTMENTID: <input name="deaprtmentId" value="${sessionScope.student.deaprtmentId}"><br>
            <input type="submit" value="SAVE">
        </form>
    </body>
</html>