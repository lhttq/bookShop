<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="enen">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>校内出售书籍</title>
    <link rel="stylesheet" href="../static/css/order.css">
    < <link rel="stylesheet" href="../static/layui/css/layui.css"  media="all">
    <script src="../static/js/jquery-2.2.4.min.js"></script>
    <script src="../static/layui/layui.js"></script>
    <script>
        $(function () {
            var tbody = $("#tbody");
            var loginName = [];
            var a = 0;
            <c:forEach var="b" items="${list}">
                loginName[a] = "${b.bsBuylogin}";
                var url = "${b.bsBookcover}";
                var bookname = "${b.bsBookname}";
                var press = "${b.bsPressname}";
                var price = "${b.bsBookprice}";
                var num = "${b.bsBooknum}";
                var buyLogin = "${b.bsBuylogin}";
                 a++;
                if(num == 0 && buyLogin != null){
                    var $tr = $("<tr>\n" +
                    "                <td>\n" +
                    "                    <span class = \"image\"><img src="+url+" alt=\"\"></span>\n" +
                    "                    <span>\n" +
                    "                        <h6 class = \"bookName\">"+bookname+"</h6>\n" +
                    "                        <span class=\"press\">"+press+"</span>\n" +
                    "                    </span>\n" +
                    "                </td>\n" +
                    "                <td>￥ "+price+"</td>\n" +
                    "                <td>"+num+"</td>\n" +
                    "                <td><a class=\"layui-btn layui-btn-danger layui-btn-xs\">获取购买者联系方式</a>" +
                    "            </tr>");
                tbody.append($tr);
                }else{
                  var $tr = $("<tr>\n" +
                    "                <td>\n" +
                    "                    <span class = \"image\"><img src="+url+" alt=\"\"></span>\n" +
                    "                    <span>\n" +
                    "                        <h6 class = \"bookName\">"+bookname+"</h6>\n" +
                    "                        <span class=\"press\">"+press+"</span>\n" +
                    "                    </span>\n" +
                    "                </td>\n" +
                    "                <td>￥ "+price+"</td>\n" +
                    "                <td>"+num+"</td>\n" +
                    "                <td>已出售或已删除</td>\n" +
                    "            </tr>");
                  tbody.append($tr);
                }
            </c:forEach>
            $("#tbody").on('click','.layui-btn.layui-btn-danger.layui-btn-xs',function () {
                let $tr = $(this).parent().parent();
               let index = $tr.index();
               var data = '{"bsLoginname":"'+loginName[index]+'"}';
                $.ajax({
                        url:"../bsUsers/SelectByUserLoginName1",
                        contentType:"application/json;charset=UTF-8",
                        data:data,
                        dataType:"json",
                        type:"post",
                        success:function (data) {
                            alert("购书人电话"+data.bsUserphone);
                        },
                         error:function (data) {
                             console.log(data);
                            alert("数据错误");
                         },
                    });
            });
        });

    </script>
</head>
<body>
    <table id="demo" class="layui-table"  lay-skin="nob" lay-filter="test">
        <colgroup>
            <col width="200">
            <col width="200">
            <col width="150">
            <col width="100">
        </colgroup>
        <thead>
        <tr>
            <th>图片</th>
            <th>价格</th>
            <th>数量</th>
            <th>删除</th>
        </tr>
        </thead>
        <tbody id="tbody">

        </tbody>
    </table>
</body>
</html>
