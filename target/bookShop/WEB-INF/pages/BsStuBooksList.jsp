<%--
  Created by IntelliJ IDEA.
  User: lhttq
  Date: 2020/2/28
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${bsBookname}</title>
    <script src="../static/js/jquery-1.12.4.min.js"></script>
    <script src="../static/layui/layui.js"></script>
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <link rel="stylesheet" href="../static/css/list.css">
    <script src="../static/js/list.js"></script>
    <script>
        $(function () {
            var $ul = $("#ul");
            var ids = [];
            var i = 0;
            <c:forEach items="${list}" var="l">
                var num = "${l.bsBooknum}";
                if(num > 0){
                ids[i] = "${l.bsBookid}";
                var url = "${l.bsBookcover}";
                var name = "${l.bsBookname}";
                var price = "${l.bsBookprice}";
                    $("#empty").remove();
                   var $li = $(" <li>\n" +
                    "          <div class=\"card\">\n" +
                    "            <img src="+url+" alt=\"Avatar\"" +
                    " style=\"width:100%\">\n" +
                    "            <div class=\"container\">\n" +
                    "              <h4><b>"+name+"</b></h4>\n" +
                    "              <p>价格:"+price+"</p>\n" +
                    "            </div>\n" +
                    "          </div>\n" +
                    "        </li>");
                $ul.append($li);
                 i++;
            }
            </c:forEach>
            $(".context").on("click","li",function () {
                var index = $(this).index();
                var url = "../bsStubooks/selectOne?bsBookid="+ ids[index];
                window.location = url;
            });
            $("#sr").keyup(
                function (e) {
                    var e = e||event;
                    var keyCode = e.which || e.keyCode;
                    if(keyCode == 13){
                        var bsBookname = $("input[name='search']").val();
                        $.ajax({
                            url:"../bsStubooks/selectPyUniversity",
                            contentType:"application/json;charset=UTF-8",
                            data:{"bsBookname":bsBookname},
                            dataType:"json",
                            type:"get",
                            success:function (data) {
                                $ul.empty();
                                for(var i = 0;i<data.length;i++){
                                    var $li = $(" <li>\n" +
                                        "          <div class=\"card\">\n" +
                                        "            <img src="+data[i].bsBookcover+" alt=\"Avatar\"" +
                                        " style=\"width:100%\">\n" +
                                        "            <div class=\"container\">\n" +
                                        "              <h4><b>"+data[i].bsBookname+"</b></h4>\n" +
                                        "              <p>价格:"+data[i].bsBookprice+"</p>\n" +
                                        "            </div>\n" +
                                        "          </div>\n" +
                                        "        </li>");
                                    $ul.append($li);
                                }
                            }
                        });
                    }

                }
            );
        });
    </script>
</head>
<body>
<div class="body">
    <div class="hander">
        <div class="hender">
            <ul id="nav" class="layui-nav">
                <li class="layui-nav-item">
                    <a href="../index.jsp">首页</a>
                </li>
                <li id="my" class="layui-nav-item" lay-unselect="">
                    <a id = "admin" href="javascript:;"><img src="https://jxjjxy-my.sharepoint.com/personal/0mddqwas_t_odmail_cn/Documents/img/icon/hhh.png"
                                                             class="layui-nav-img layui-anim-rotate">我</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../bsUsers/Select">完善个人信息</a></dd>
                        <dd><a href="../bsCarts/SelectAllByUserId">购物车</a></dd>
                    </dl>
                </li>
            </ul>
            <!--搜索-->
            <div class="search">
                <form action="JavaScript:;" id="sr" method="post">
                    <input type="text" name="search" placeholder="搜索..">
                </form>
            </div>
        </div>
        <div class="context">
            <div class="cards">
                <ul id="ul">
                    <li id="empty">没有书籍</li>
                </ul>
            </div>
        </div>
        <div class="footer"></div>
    </div>
</div>
</body>
</html>