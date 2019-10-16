<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/15
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <%--<script src="webjars/jquery/3.4.1/dist/jquery.js"></script>--%>
    <script src="webjars/jquery-easyui/1.5.21/js/jquery.easyui.min.js"></script>
    <script src="webjars/jquery-easyui/1.5.21/js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="webjars/jquery-easyui/1.5.21/css/easyui.css">
</head>
<body>
<div id="tableP">
    <table border="1" class="datagrid">
        <thead>
        <tr>
            <th width="80">编号</th>
            <th width="150">名称</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookTypes}" var="bt">
            <tr>
                <td>${bt.bookTypeID}</td>
                <td>${bt.bookTypeName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
</body>
</html>
