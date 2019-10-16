<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/16
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <script src="webjars/jquery-easyui/1.5.21/js/jquery.easyui.min.js"></script>
    <%--<script src="webjars/js/jquery.easyui.min.js"></script>--%>
    <%--<script src="https://code.jquery.com/jquery-3.2.0.js"></script>--%>
    <script src="webjars/jquery/3.4.1/src/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="webjars/css/easyui.css">
</head>
<body>
<div class="layout-panel-east">
    <form id="searchForm" method="post">
        <table>
            <tr>
                <td>图书名称</td>
                <td>
                    <input id="bookName" name="bookName" class="textbox-text" datafld="prompt:'输入图书名称：'"
                           style="width: 100%;height: 32px">
                </td>
                <td>出版社</td>
                <td>
                    <input id="publishment" name="publishment" class="textbox-text">
                </td>
                <td>
                    <a href="#" class="searchbox-button" style="width: 80px" onclick="onSearch()">查询</a>
                </td>
            </tr>
        </table>
    </form>
    <div id="tableP">
        <table id="dg" class="datagrid" border="1">
            <thead>
            <tr>
                <th width="80">编号</th>
                <th width="150">名称</th>
                <th>类名</th>
                <th>出版社</th>
                <th>出版时间</th>
                <th>作者</th>
                <th>价格</th>
                <th>用户编号</th>
                <th>出借时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${bookList}" var="books">
                <tr>
                    <td>${books.bookID}</td>
                    <td>${books.bookName}</td>
                    <td>${books.bookTypeID}</td>
                    <td>${books.publishment}</td>
                    <td>${books.publishDate.toLocaleString()}</td>
                    <td>${books.author}</td>
                    <td>${books.price}</td>
                    <td>${books.userCode}</td>
                    <td>${books.borrowDate.toLocaleString()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
<script>
    function onSearch() {
        alert("start");
        var dg1=$("#dg");
        alert("read dg");
        var opts = dg1.datagrid("options");
        opts.url = "./list";
        alert("datagrid");
        var bookName = $("#bookName").val();
        alert(bookName);

        var pub = $("#publishment").val();
        var params={};
        if (bookName != null && bookName.trim()!=''     ){
            params.bookName=bookName;
        }
        if (pub != null && pub.trim()!=''){
            params.publishment=pub;
        }
        alert("serch:"+bookName+","+pub);
        dg1.datagrid('load',params);
    }
</script>
</html>
<%--bookid, bookName, booktypeid, publishment, publishDate, author, price, userCode, BorrowDate--%>