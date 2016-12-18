<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>department list page</title>
        <script>
            function del() { return confirm('REMOVE?'); }
        </script>
    </head>
    <body>
        <c:import url="add.jsp"/>
        <hr/>
        <h1>LIST Department</h1>
        <hr/>
        <table border="1">
            <tr>
                <th>INDEX</th>
                <th>DNAME</th>
                <th>STUDENTS</th>
                <th colspan="2">OPERATION</th>
            </tr>
            <c:forEach var="department" items="${sessionScope.pagination.list}" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${department.dname}</td>
                <td>
                    <ol>
                        <c:forEach var="student" items="${department.students}">
                            <li>${student.sname}</li>
                        </c:forEach>
                    </ol>
                </td>
                <td><a href="${ctx}/department/search/${department.id}">EDIT</a></td>
                <td><a class="delete" href="${ctx }/department/remove/${department.id}" onclick="return del()">REMOVE</a></td>
            </tr>
            </c:forEach>
        </table>
        <c:import url="${ctx}/commons/page.jsp">
            <c:param name="path" value="department/${sessionScope.pagination.selectId}"/>
        </c:import>
    </body>
</html>