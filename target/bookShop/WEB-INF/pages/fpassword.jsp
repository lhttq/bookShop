<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>忘记密码</title>
    <link rel="stylesheet" href="../static/css/css.css">
    <script src="../static/js/jquery-2.2.4.min.js"></script>
    <script src="../static/layui/layui.js"></script>
    <script src="../static/js/fpassword.js"></script>
</head>
<body>
  <div class="content">
   <div class="web-width">
     <div class="for-liucheng">
      <div class="liulist for-cur"></div>
      <div class="liulist"></div>
      <div class="liulist"></div>
      <div class="liutextbox">
       <div class="liutext for-cur"><em>1</em><br><strong>填写账户名</strong></div>
       <div class="liutext"><em>2</em><br><strong>设置新密码</strong></div>
       <div class="liutext"><em>3</em><br><strong>完成</strong></div>
      </div>
     </div><!--for-liucheng/-->
     <form action="" method="get" class="forget-pwd">
       <dl>
        <dt>账户名：</dt>
        <dd><input id = "name" type="text"></dd>
        <div class="clears"></div>
       </dl> 
       <dl>
        <dt>验证码：</dt>
        <dd>
         <input type="text" id="ycode" placeholder="验证码大写">
         <div class="yanzma">
             <canvas width="150" height="40" id="canvas"></canvas>
         </div>
        </dd>
        <div class="clears"></div>
       </dl>
       <div class="subtijiao"><input id="submit" type="submit" value="提交"></div>
      </form>
   </div>
  </div>
  


</body></html>