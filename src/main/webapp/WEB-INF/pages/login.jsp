<%@ page import="cn.lht.entity.BsPassword" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="../static/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="../static/js/jquery-1.12.4.min.js"></script>
<link href="../static/css/login.css" rel="stylesheet" type="text/css" media="all">
	<script type="text/javascript">
		$(function () {
			 	<%
                   HttpSession httpSession = request.getSession();
                   String sessionID = request.getRequestedSessionId();
                   BsPassword bsPassword = (BsPassword) httpSession.getAttribute("user" + sessionID);
                   Integer i = -1;
                   if(bsPassword == null){
                   		i = 0;
                   }
                %>
			var is = "<%=i%>";
			if(is == 0){
				if("${msg}" == 0){
				alert("您还没有登录，请先登录，没有账号请注册！");
			}else {
				if("${msg}" == 1){
					alert("注册成功，请登录！");
				}
				if("${msg}" == -1){
					alert("该邮箱已注册，请登录");
				}
			}
			}
			$('.toggle').click(function(){
				$(this).children('i').toggleClass('fa-pencil');
				$('.form').animate({height: "toggle",'padding-top': 'toggle','padding-bottom': 'toggle',opacity: "toggle"}, "slow");
			});

		});

	</script>
</head>
<body>

<div class="main">
	<div class="w3_login">
		<div class="w3_login_module">
			<div class="module form-module">
				<div class="toggle">
					<i class="fa fa-times"></i>
					<div class="tooltip">点击切换</div>
				</div>
				<div class="form" style="display: block;">
					<h2>登录账号</h2>
					<form action="../bsPassword/QueryByLoginName" method="post">
						<input type="text" name="Username" placeholder="用户名" required=" ">
						<input type="password" name="Password" placeholder="密码" required=" ">
						<input type="submit" value="登录">
					</form>
				</div>
				<div class="form" style="display: none;">
					<h2>创建一个账号</h2>
					<form action="../bsPassword/InsertUser" method="post">
						<input type="text" name="Username" placeholder="用户名" required=" ">
						<input type="password" name="Password" placeholder="密码" required=" ">
						<input type="submit" value="注册">
					</form>
				</div>
				<div class="cta"><a href="../bsPassword/Skip">忘记密码?</a></div>
			</div>
		</div>
	</div>
</div>
</body></html>