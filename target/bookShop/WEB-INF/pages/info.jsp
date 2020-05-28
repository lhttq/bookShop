
<!DOCTYPE html>
<%@ page import="cn.lht.entity.BsPassword" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Date" %>
<%@ page import="cn.lht.entity.BsUsers" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>完善个人信息</title>
    <link rel="stylesheet" href="../static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../static/css/info.css">
    <script src="../static/js/jquery-2.2.4.min.js"></script>
    <script src="../static/layui/layui.js"></script>
    <script>
        $(function () {
            var bsuser = "${bsUsers}";
            if(bsuser != null){
                 <%
                   HttpSession httpSession = request.getSession();
                   String sessionID = request.getRequestedSessionId();
                   BsPassword bsPassword = (BsPassword) httpSession.getAttribute("user" + sessionID);
                   String userName = bsPassword.getBsLoginname();
                   BsUsers bsUsers = (BsUsers) request.getAttribute("bsUsers");
                   String formatDate = "";
                   if(bsUsers != null){
                       String time = bsUsers.getBsUserbrithday().toString();
                       SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
                       Date date = simpleDateFormat.parse(time);
                       formatDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
                   }
                 %>
                var userClass = "${bsUsers.bsUsertype}";
                var userSex = "${bsUsers.bsUsersex}";
                var userName = "${bsUsers.bsTruename}";
                var userBrithday = "<%=formatDate%>";
                var userQQ = "${bsUsers.bsUserqq}";
                var userPhone = "${bsUsers.bsUserphone}";
                var userEmail = "${bsUsers.bsUseremail}";
                var stu = "${bsUsers.bsUniversity}";
                var province = "${bsUsers.bsProvince}";
                userBrithday.replace();
                if(userClass == "0"){
                    var $userClass = $("#userClass");
                        var $div = $(" <div class=\"layui-form-item\" id='stu'>\n" +
                            "        <label class=\"layui-form-label\">学校</label>\n" +
                            "        <div class=\"layui-input-block\">\n" +
                            "            <input type=\"text\" name=\"student\" placeholder=\"如果是学校用户请填入学校\" autocomplete=\"off\"\n" +
                            "                   class=\"layui-input\">\n" +
                            "        </div>\n" +
                            "    </div>");
                        $userClass.after($div);
                }
            }
            layui.use('form', function(){
                var form = layui.form;
                form.render();
                //监听用户单选
                form.on('radio(userClass)', function(data){
                    //被点击的radio的value值
                    if(data.value==0){
                        var $userClass = $("#userClass");
                        var $div = $(" <div class=\"layui-form-item\" id='stu'>\n" +
                            "        <label class=\"layui-form-label\">学校</label>\n" +
                            "        <div class=\"layui-input-block\">\n" +
                            "            <input type=\"text\" name=\"student\" placeholder=\"如果是学校用户请填入学校\" autocomplete=\"off\"\n" +
                            "                   class=\"layui-input\">\n" +
                            "        </div>\n" +
                            "    </div>");
                        $userClass.after($div);
                    }else{
                        $("#stu").remove();
                    }
                });
                 //给表单赋值
                form.val("test1", { //formTest 即 class="layui-form" 所在元素属性 lay-filter="" 对应的值
                    "user": userClass   // "name": "value"
                    ,"sex": userSex
                    ,"name": userName
                    ,"birthday":userBrithday
                    ,"QQ": userQQ
                    ,"phone":userPhone
                    ,"email":userEmail
                    ,"province":province
                    ,"student":stu
                });
                //监听提交
                form.on('submit', function(data){
                    data = data.field;
                    console.log(data);
                    data =
                        '{"bsLoginname":"'+data.userName+'",' +
                        '"bsUsertype":'+data.user+',' +
                        '"bsUsersex":'+data.sex+',' +
                        '"bsUsername":"'+data.userName+'",' +
                        '"bsTruename":"'+data.name+'",' +
                        '"bsUniversity":"'+data.student+'",' +
                        '"bsUserbrithday":"'+data.birthday+'",' +
                        '"bsUserqq":"'+data.QQ+'",' +
                        '"bsUserphone":"'+data.phone+'",' +
                        '"bsUseremail":"'+data.email+'",' +
                        '"bsProvince":"'+data.province+'"}';
                    console.log(data);
                      $.ajax({
                        url:"../bsUsers/InsertUser",
                        contentType:"application/json;charset=UTF-8",
                        data:data,
                        dataType:"json",
                        type:"post",
                        success:function (data) {
                            if(data>0){
                                layer.alert("信息修改成功");
                            }else{
                                layer.alert("数据上传失败");
                            }
                        },
                         error:function (data) {
                             console.log(data);
                            alert("数据错误");
                         },
                    });
                    return false;
                });
                form.verify({
                    //我们既支持上述函数式的方式，也支持下述数组的形式
                    //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
                    name:[   /^[\u4e00-\u9fa5]+$/
                        , "请输入正确的格式"
                    ]
                    ,
                    birthday:[ /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/
                        , "请输入正确的格式"
                    ]
                    ,
                    phone: [
                        /^1[3456789]\d{9}$/
                        ,'电话号有误'
                    ]
                });
                form.render();
            });

            //日期函数
            layui.use('laydate', function(){
                var laydate = layui.laydate;
                //执行一个laydate实例
                laydate.render({
                    elem: '#birthday' //指定元素
                });
            });
        });
    </script>
</head>
<body>
<form class="layui-form" lay-filter="test1" method="post"> <!--
 提示：如果你不想用form，你可以换成div
等任何一个普通元素 -->
    <input type="hidden" name="userName" value="<%=userName%>"/>
     <div class="layui-form-item">
        <label class="layui-form-label">性别*</label>
        <div class="layui-input-block">
            <input type="radio" lay-filter="userSex" name="sex" value="0" title="男">
            <input type="radio" lay-filter="userSex" name="sex" value="1" title="女">
        </div>
    </div>
    <div class="layui-form-item" id="userClass">
        <label class="layui-form-label">用户类型*</label>
        <div class="layui-input-block">
            <input type="radio" lay-filter="userClass" name="user" value="0" title="学生">
            <input type="radio" lay-filter="userClass" name="user" value="1" title="普通用户">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">真实姓名*</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="name" placeholder="请输入"  autocomplete="off"
                   class="layui-input" required/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">生日*</label>
        <div class="layui-inline">
            <input type="text" name = "birthday" lay-verify="birthday" class="layui-input" id="birthday">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">QQ号</label>
        <div class="layui-input-block">
            <input type="text" name="QQ" placeholder="请输入QQ号" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号*</label>
        <div class="layui-input-block">
            <input type="text" name="phone" lay-verify="phone" placeholder="请输入手机号" autocomplete="off" class="layui-input"  required >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" name="email" placeholder="请输入邮箱" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
      <div class="layui-form-item">
        <label class="layui-form-label">所在省份</label>
        <div class="layui-input-block">
            <input type="text" name="province" placeholder="请输入您所在的省份" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit lay-filter="*">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</body>
</html>