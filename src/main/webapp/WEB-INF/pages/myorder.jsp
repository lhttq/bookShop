<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="enen">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="../static/css/order.css">
    < <link rel="stylesheet" href="../static/layui/css/layui.css"  media="all">
    <script src="../static/js/jquery-2.2.4.min.js"></script>
    <script src="../static/js/order.js"></script>
    <script src="../static/layui/layui.js"></script>
    <script>
        $(function () {
            var demo = $("#demo");
            var orderno = [];
            var sum = [];
            var name = [];
            var a = 0;
            <c:forEach var="b" items="${bsOrderList}">
                orderno[a] = "${b.bsOrderno}";
                name[a] = "${b.bsUsername}"
                sum[a] = "${b.bsBooksmoney}"
                a++;
            </c:forEach>
            a = 0;
            let $tr;
            <c:forEach items="${lists}" var="list">
                $tr = $("<thead>\n" +
                    "            <tr>\n" +
                    "                <th>订单号："+orderno[a]+"</th>\n" +
                    "                <th>数量</th>\n" +
                    "                <th>总价 "+sum[a]+"</th>\n" +
                    "                <th>收货人 "+name[a]+"</th>\n" +
                    "            </tr>\n" +
                    "            </thead>\n");
                demo.append($tr);
                a++;
                let price1 = null;
                let num = null;
                let $tr1;
                let img;
                <c:forEach items="${list}" var="l">
                     price1 = "${l.bsGoodsprice}";
                     num = "${l.bsGoodsnum}";
                     img = "${l.bsGoodimg}"
                     $tr1 = $( "<tbody>\n" +
                        "            <tr>\n" +
                        "                <td><img src=\""+img+"\" alt=\"\"></td>\n" +
                        "                <td>"+num+"</td>\n" +
                        "                <td>￥ "+price1+"</td>\n" +
                        "                <td></td>\n" +
                        "            </tr>\n" +
                        "            </tbody>");
                demo.append($tr1);
                </c:forEach>
            </c:forEach>

        });

    </script>
</head>
<body>

        <table id="demo" class="layui-table"  lay-skin="nob" lay-filter="test">
            <colgroup>
                <col width="200">
                <col width="200">
                <col width="150">
                <col width="150">
                <col width="100">
            </colgroup>
        </table>
</body>
</html>
