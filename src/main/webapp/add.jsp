<%@ page import="cn.lht.entity.BsPassword"%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>add</title>
    <link rel="stylesheet" href="static/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="static/css/select.css"/>
    <script src="static/js/jquery-2.2.4.min.js"></script>
    <script src="static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <script src="static/js/select.js" type="text/javascript" charset="utf-8"></script>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            position: relative;
        }
        .add{
            position: absolute;
            width: 760px;
            height: 364px;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            margin: 0 auto;
            border: 1px solid  rgb(239, 239, 239);
        }
    </style>
    <script>
        $(function () {
                    <%
                   HttpSession httpSession = request.getSession();
                   String sessionID = request.getRequestedSessionId();
                   BsPassword bsPassword = (BsPassword) httpSession.getAttribute("user" + sessionID);
                   Integer userId = bsPassword.getBsUserid();
                    %>
            //注意：parent 是 JS 自带的全局对象，可用于操作父页面
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            //给父页面传值
            $('#btn').on('click', function(){
                var name = $("#name").val();
                var phone = $("#phone").val();
                var province = $("#province").val();
                var city = $("#city").val();
                var area = $("#area").val();
                var address = $("#address").val();
                var info = name + phone;
                var detailAddress = province +city + area + address;
                var $li = "<li>\n" +
                    "                <div class=\"info\"> "+info+" </div>\n" +
                    "                <div class=\"address\">"+detailAddress+"</div>\n" +
                    "            </li>";
                parent.$('#ul').prepend($li);
                parent.layer.tips('Look here', '#parentIframe', {time: 5000});
                var userId = "<%=userId%>";
                var data =
                        '{"bsUserid":'+userId+',"bsUsername":"'+name+'","bsUserphone":"'+phone+'","bsAreaidpath":"'+detailAddress+'","bsIsdefault":'+1+'}';
                 $.ajax({
                        url:"bsAddress/insertPyentity",
                        contentType:"application/json;charset=UTF-8",
                        data:data,
                        dataType:"json",
                        type:"post",
                        success:function (data) {

                        },
                         error:function () {
                            alert("数据错误");
                         },
                    });
                  parent.layer.close(index);
            });
        });
    </script>
</head>
<body>
    <div class="add">
        <div class="layui-form" action="">
            <div class="layui-form-item">
            <label class="layui-form-label">收货人姓名</label>
            <div class="layui-input-block">
                <input id="name" type="text" name="title" required  lay-verify="required" placeholder="不超过15个字" autocomplete="off" class="layui-input">
            </div>
        </div>
            <div class="layui-form-item">
                <label class="layui-form-label">收货人联系方式</label>
                <div class="layui-input-block">
                    <input id="phone" type="text" name="title" required  lay-verify="required" placeholder="手机号" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item" id="addressDiv">
                    <label class="layui-form-label">详细地址</label>
                    <div class="layui-input-inline">
                        <select name="P1" lay-filter="province" id="province">
                            <option></option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select name="C1" lay-filter="city" id="city">
                            <option></option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select name="A1" lay-filter="area" id="area">
                            <option></option>
                        </select>
                    </div>
                    <div class="layui-input-inline" id="addressDetail">
                        <input id="address" type="text" name="address" lay-verify="title" autocomplete="off"
                               placeholder="请输入具体地址" class="layui-input" style="width: 120%;">
                        <dl id="addressTip" class="addressDl">
                        </dl>
                    </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button id="btn" class="layui-btn" lay-submit lay-filter="formDemo">确定</button>
                    <button type="reset" class="layui-btn layui-btn-primary">取消</button>
                </div>
            </div>

        </div>
    </div>
</body>
</html>