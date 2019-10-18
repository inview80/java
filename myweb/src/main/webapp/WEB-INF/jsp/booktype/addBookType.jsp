<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/17
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <c:set var="base" value="${pageContext.request.contextPath}"/>
    <script src="${base}/webjars/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>
<form>
    <table>
        <tr>
            <td>类型编号</td>
            <td>
                <input id="bookTypeID" name="bookTypeID">
            </td>
        </tr>
        <tr>
            <td>类型名称</td>
            <td>
                <input id="bookTypeName" name="bookTypeName">
            </td>
        </tr>
        <tr>
            <td/>
            <td align="right">
                <input id="submit" type="button" value="提交" onclick="submitBtn()">
            </td>
        </tr>
    </table>
</form>
</body>
<script>
    function submitBtn() {
        alert("开始");
        var id = $("#bookTypeID").val();
        var name = $("#bookTypeName").val();
        if ($.trim(id) == '' || id == 0) {
            alert('图书类型ID不能为0或空');
            return;
        }
        if ($.trim(name) == '') {
            alert('图书类型名称不能为空');
            return;
        }
        alert("post前");
        $.ajax({
            type: "POST",
            contentType: "application/json;charset=UTF-8",
            url: "./insert",
            data: JSON.stringify({bookTypeID: id, bookTypeName: name}),
            dataType: "json",
            success: [function (result) {
                console.log(result);
                if (result == null) {
                    alert("插入失败");
                    return;
                }
                alert("插入成功:" + data);
            }]
        });
    }
</script>
</html>
