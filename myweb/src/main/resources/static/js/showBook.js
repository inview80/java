document.write("<script  type='text/javascript' src='/webjars/jquery/1.11.1/jquery.js'></script>");
document.write("<script  type='text/javascript' src='/webjars/bootstrap/3.3.5/js/bootstrap.js'></script>");
document.write("<script  type='text/javascript' src='/webjars/bootstrap-table/1.9.1-1/bootstrap-table.js'></script>");

function setup() {
    $("#dg").bootstrapTable({
        // url: "/book/list",
        // type: "post",
        clickToSelect: true,//是否启用点击选中行
        toggle: true,
        locale: "zh-CN",
        // showRefresh: true,                  //是否显示刷新按钮
        pagination: true,                   //是否显示分页（*）
        striped: true,                      //是否显示行间隔色
        // queryParams: {
        //     csrfmiddlewaretoken: '{{ csrf_token }}',
        //     bookName: $("#bookName").val(),
        //     publishment: $("#publishment").val()
        // },
        onDblClickRow: function (row, $element) {
            var id = row.bookID;
            alert(id);
        },
        columns: [{
            checkbox: true,
            visible: true                  //是否显示复选框
        }, {
            field: 'bookID', title: '编号', width: 40
        }, {
            field: 'bookName', title: '名称', width: 200
        }, {
            field: 'bookTypeID', title: '类型ID'
        }, {
            field: 'publishment', title: '出版社'
        }, {
            field: 'publishDate', title: '出版时间', formatter: dateFormat
        }, {
            field: 'price', title: '价格'
        }, {
            field: 'userCode', title: '用户ID'
        }, {
            field: 'borrowDate', title: '出版时间', formatter: dateFormat
        },]
    });
    flushTable();
}

function dateFormat(value, row, index) {
    if(value==null) return null;
    return formatDate(value);
    // var date = new Date(value);
    // return value.substring(0, 10);
}

// function showData(data) {
//     console.log("接收到数据，填充表格");
//     $("#dg tbody").html('');
//     console.log("找到table");
//     $.each(data, function (index, item) {
//         var checkBox = $("<td><input type='checkbox' class='checkbox'/></td>");
//         var bookID = $("<td></td>").append(item.bookID);
//         var bookName = $("<td></td>").append(item.bookName);
//         var bookTypeID = $("<td></td>").append(item.bookTypeID);
//         var publishment = $("<td></td>").append(item.publishment);
//         var publishDate = $("<td></td>").append(formatDate(item.publishDate));
//         var author = $("<td></td>").append(item.author);
//         var price = $("<td></td>").append(item.price);
//         var userCode = $("<td></td>").append(item.userCode);
//         var borrowDate = $("<td></td>").append(formatDate(item.borrowDate));
//         $("<tr></tr>").append(checkBox).append(bookID).append(bookName).append(bookTypeID).append(publishment).append(publishDate)
//             .append(author).append(price).append(userCode).append(borrowDate).appendTo("#dg tbody");
//     });
// var trtd = "<td>";
// var trtdEnd = "</td>" + trtd;
// for (var i = 0; i < data.length; i++) {
//     str = "<tr>" + trtd + data[i].bookID + trtdEnd + data[i].bookName + trtdEnd + data[i].bookTypeID + trtdEnd
//     + data[i].publishment + trtdEnd +formatDate(data[i].publishDate) + trtdEnd + data[i].author + trtdEnd + data[i].price +
//     trtdEnd + data[i].userCode + trtdEnd + formatDate(data[i].borrowDate) + "</td></tr>";
//     tb.append(str);
// }
// }
// function readData() {
//     console.log("开始发送提交信息");
//     var name = $("#bookName").val();
//     var pub = $("#publishment").val();
//     var parms = {bookName: name, publishment: pub};
//     console.log("name:" + name + ",pub:" + pub);
//     $.ajax({
//         url: "/book/list",
//         type: "post",
//         dataType: "json",
//         // data: JSON.stringify(parms),
//         // type: "get",
//         data: {"bookName": name, "publishment": pub, csrfmiddlewaretoken: '{{ _csrf.token }}'},//"${_csrf.parameterName}":"${_csrf.token}",
//         success: function (data) {
//             showData(data);
//         },               /*这个方法里是ajax发送请求成功之后执行的代码*///我们仅做数据展示
//         error: function (msg) {
//             alert("ajax连接异常：" + msg);
//         }
//     });
// }
//
function formatDate(dateArg) {
    var date = new Date(dateArg);
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var formatMonth = month < 10 ? '0' + month : month;
    var formatDay = day < 10 ? '0' + day : day;

    return year + "-" + formatMonth + "-" + formatDay;
}

function flushTable() {
    var opt = {
        url: "/book/list", silent: true, query: {bookName: $("#bookName").val(), publishment: $("#publishment").val()}
    };
    $("#dg").bootstrapTable('refresh', opt);
}

// $(document).ready(loadup());
// $(function () {
//     var token = $("meta[name='_csrf']").attr("content");
//     var header = $("meta[name='_csrf_header']").attr("content");
//     $(document).ajaxSend(function(e, xhr, options) {
//         xhr.setRequestHeader(header, token);
//     });
// });
