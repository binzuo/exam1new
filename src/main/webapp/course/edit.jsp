<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>course edit page</title>
    </head>
    <body>
        <h1>EDIT Course</h1>
        <form action="${ctx}/course/modify" method="post">
            <input type="hidden" name="id" value="${sessionScope.course.id}">
            CNAME: <input name="cname" value="${sessionScope.course.cname}"><br>
            <input type="submit" value="SAVE">
        </form>
    </body>
</html>