<%@ page import="cn.lht.entity.BsPassword" %>
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>二手书城</title>
  <script src="static/js/jquery-1.12.4.min.js"></script>
  <script src="static/layui/layui.js"></script>
  <link rel="stylesheet" href="static/layui/css/layui.css">
  <link rel="stylesheet" href="static/css/index.css">
  <script src="static/js/index.js"></script>
</head>
<body>
<div id="body" class="body">
  <div class="hander">
    <ul id="nav" class="layui-nav">
      <li class="layui-nav-item">
        <a href="index.jsp">首页</a>
      </li>
       <li class="layui-nav-item">
        <a href="bsUsers/Skip">登录</a>
      </li>
       <li class="layui-nav-item">
        <a href="bsStubooks/skip">添加本校书籍</a>
      </li>
       <li class="layui-nav-item">
        <a href="bsStubooks/selectPyUniversity">查看本校书籍</a>
      </li>
      <li class="layui-nav-item">
        <a href="bsPublishbooks/selectOne">我要卖书</a>
      </li>
      <li id="my" class="layui-nav-item" lay-unselect="">
        <a id = "admin" href="javascript:;">
          <img src="https://s1.ax1x.com/2020/04/05/GrUblV.jpg"
               class="layui-nav-img layui-anim-rotate">我</a>
        <dl class="layui-nav-child">
          <dd><a href="bsUsers/Select">完善个人信息</a></dd>
          <dd><a id="carts" href="bsCarts/SelectAllByUserId">购物车</a></dd>
          <dd><a href="bsPublishbooks/SelectByBsPublish">管理我的出售</a></dd>
          <dd><a href="bsStubooks/selectPyUniversity2">管理校内出售书籍</a></dd>
          <dd><a href="bsOrder/selectByUserId">我的订单</a></dd>
        </dl>
      </li>
    </ul>
    <!--搜索-->
    <div class="search">
      <form action="bsBooks/selectM" id="sr" method="get">
        <input type="text" id="searchInput" name="bsBookname" placeholder="搜索..">
      </form>
    </div>
  </div>
  <div class="context">
    <!--轮播图：活动位置或广告位-->
    <div class="layui-carousel" id="lb" lay-filter="test1">
      <div carousel-item="" id="lb_img">
        <div><img src="https://s1.ax1x.com/2020/04/05/GrUYz6.png"></div>
        <div><img src="https://s1.ax1x.com/2020/04/05/GrUJRx.png"></div>
        <div><img src="https://s1.ax1x.com/2020/04/05/GrUGJ1.png"></div>
        <div><img src="https://s1.ax1x.com/2020/04/05/GrU8iR.png"></div>
        <div><img src="https://s1.ax1x.com/2020/04/05/GrUldJ.png"></div>
      </div>
    </div>
    <div class="cards">
      <ul id="ul">
      </ul>

    </div>

  </div>
  <div class="footer">

  </div>
</div>
</body>
</html>