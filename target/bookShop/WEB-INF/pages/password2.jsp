<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Author" contect="http://www.webqin.net">
<title>忘记密码</title>
    <link rel="stylesheet" href="../static/css/password2.css">
    <script src="../static/js/jquery-2.2.4.min.js"></script>
    <script src="../static/layui/layui.js"></script>
    <script src="../static/js/password2.js"></script>
</head>

<body>
  <div class="content">
   <div class="web-width">
     <div class="for-liucheng">
      <div class="liulist for-cur"></div>
      <div class="liulist for-cur"></div>
      <div class="liulist"></div>
      <div class="liutextbox">
       <div class="liutext for-cur"><em>1</em><br><strong>填写账户名</strong></div>
       <div class="liutext for-cur"><em>2</em><br><strong>设置新密码</strong></div>
       <div class="liutext"><em>3</em><br><strong>完成</strong></div>
      </div>
     </div>
     <form action="" method="get" class="forget-pwd">
       <dl>
        <dt>用户名：</dt>
        <dd><input id="name" type="text"></dd>
        <div class="clears"></div>
       </dl> 
       <dl>
        <dt>新密码：</dt>
        <dd><input id="oldpassword" type="password"></dd>
        <div class="clears"></div>
       </dl> 
       <dl>
        <dt>确认密码：</dt>
        <dd><input id="newpassword" type="password"></dd>
        <div class="clears"></div>
       </dl> 
       <div class="subtijiao"><input id="submit" type="submit" value="提交"></div>
      </form>
   </div>
  </div>
</body></html>