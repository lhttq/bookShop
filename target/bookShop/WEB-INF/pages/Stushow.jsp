<%--
  Created by IntelliJ IDEA.
  User: lhttq
  Date: 2020/2/28
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="cn.lht.entity.BsPassword" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${bsBooks.bsBookname}</title>
    <script src="../static/js/jquery-1.12.4.min.js"></script>
    <script src="../static/layui/layui.js"></script>
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <link rel="stylesheet" href="../static/css/show.css">
    <script src="../static/js/show.js"></script>
    <script>
        $(function () {
            $("#btn01").click(function () {
                <%
                   HttpSession httpSession = request.getSession();
                   String sessionID = request.getRequestedSessionId();
                   BsPassword bsPassword = (BsPassword) httpSession.getAttribute("user" + sessionID);
                   String userLogin = bsPassword.getBsLoginname();
                %>
                var bsBookid = "${bsStubooks.bsBookid}";
                var bsBuylogin = "<%=userLogin%>";
                var data = '{"bsBookid":'+bsBookid+',"bsBuylogin":"'+bsBuylogin+'"}';
                $.ajax({
                    url:"../bsStubooks/UpdateStuBook",
                    contentType:"application/json;charset=UTF-8",
                    data:data,
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        if(data>0){
                            alert("锁定成功，请等出售者联系");
                        }else{
                           alert("失败");
                        }
                    },
                    error:function () {
                        alert("数据错误");
                    }
                });
            });

        });
    </script>
</head>
<body>
<div class="body" >
    <div class="hender">
        <ul id="nav" class="layui-nav">
            <li class="layui-nav-item">
                <a href="../index.jsp">首页<span class="layui-badge">9</span></a>
            </li>
            <li class="layui-nav-item">
                <a href="">个人中心<span class="layui-badge-dot"></span></a>
            </li>
            <li id="my" class="layui-nav-item" lay-unselect="">
                <a id = "admin" href="javascript:;"><img src="//t.cn/RCzsdCq" class="layui-nav-img layui-anim-rotate">我</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">修改信息</a></dd>
                    <dd><a href="../bsCarts/SelectAllByUserId">购物车</a></dd>
                    <dd><a href="javascript:;">登出</a></dd>
                </dl>
            </li>
        </ul>
        <!--搜索-->
        <div class="search">
            <form action="selectM" id="sr" method="post">
                <input type="text" name="bsBookname" placeholder="搜索..">
            </form>
        </div>
    </div>
    <div class="context">
        <div class="card">
            <img src="${bsStubooks.bsBookcover}" alt="Avatar" style="width:100%">
            <div class="container">
                <h4><b>${bsStubooks.bsBookname}</b></h4>
            </div>
        </div>
        <div class="infrom">
            <p class = "font">价格：${bsStubooks.bsBookprice} </p>
            <p class="font">优惠价：</p>
            <p><span>配送至:</span>
                <select id="province" onchange="provinceSelect(this)">
                </select>
                <select id="city" onchange="citySelect(this)">
                </select>
                <select id="region" onchange="">
                </select>
            </p>
            <button id="btn01" class="layui-btn layui-btn-primary">立即购买</button>
        </div>
        <div class="show">
            <div class="layui-tab">
                <ul class="layui-tab-title">
                    <li class="layui-this">商品介绍</li>
                    <li>售后保障</li>
                    <li>商品评价</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <table class="layui-table e" lay-size="sm">
                            <colgroup>
                                <col width="100">
                                <col>
                                <col width="100">
                            </colgroup>
                            <tbody>
                            <tr>
                                <td>出版社</td>
                                <td></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="layui-tab-item">运费险</div>
                    <div class="layui-tab-item">无</div>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">

    </div>
</div>
</body>
</html>