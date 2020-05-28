<!DOCTYPE html>
<%@ page import="cn.lht.entity.BsPassword" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>卖书</title>
    <link rel="stylesheet" href="../static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../static/css/stuBook.css">
    <script src="../static/js/jquery-3.3.1.min.js"></script>
    <script src="../static/layui/layui.js"></script>
    <script>
        $(function () {
             <%
                   HttpSession httpSession = request.getSession();
                   String sessionID = request.getRequestedSessionId();
                   BsPassword bsPassword = (BsPassword) httpSession.getAttribute("user" + sessionID);
                   String userName = bsPassword.getBsLoginname();
                    %>

            var url = 'https://api.uomg.com/api/image.ali';
            var imgUrl = null;
            $("input[type='file']").change(function(e) {
                file_upload(this.files)
            });
            var obj = $('body');
            obj.on('dragenter', function(e) {
                e.stopPropagation();
                e.preventDefault()
            });
            obj.on('dragover', function(e) {
                e.stopPropagation();
                e.preventDefault()
            });
            obj.on('drop', function(e) {
                e.preventDefault();
                file_upload(e.originalEvent.dataTransfer.files)
            });
            function file_upload(files){
                if (files.length == 0) return alert('请选择图片文件！');
                for(var j = 0,len = files.length; j < len; j++){
                    console.log(files[j]);
                    let imageData = new FormData();
                    imageData.append("file", 'multipart');
                    imageData.append("Filedata", files[j]);
                    $.ajax({
                        url: url,
                        type: 'POST',
                        data: imageData,
                        cache: false,
                        contentType: false,
                        processData: false,
                        dataType: 'json',
                        // 图片上传成功
                        success: function (result) {
                            if (result.code == 1){
                                imgUrl = result.imgurl;
                                $("#image").attr('src',imgUrl);
                            }else{
                                alert("上传失败，请重新上传");
                            }
                        },
                        // 图片上传失败
                        error: function () {
                            console.log('图片上传失败');
                        }
                    });
                }
            }
            layui.use('form', function(){
                var form = layui.form;
                form.render();
                //监听提交
                form.on('submit', function(data){
                    data = data.field;
                    let img = $("#image").attr('src');
                    data.bsBookcover = img;
                    console.log(data);
                    data =
                        '{"bsLoginname":"'+data.bsLoginname+'",' +
                        '"bsBookname":"'+data.bsBookname+'",' +
                        '"bsBookauthor":"'+data.bsBookauthor+'",' +
                        '"bsPressname":"'+data.bsPressname+'",' +
                        '"bsBookprice":'+data.bsBookprice+',' +
                        '"bsBookcover":"'+data.bsBookcover+'",' +
                        '"bsBooknum":'+data.bsBooknum+',' +
                        '"bsUniversity":"'+data.bsUniversity+'",' +
                        '"bsCratetime":"'+data.bsCratetime+'"}';
                    console.log(data);
                      $.ajax({
                        url:"../bsStubooks/InsertBook",
                        contentType:"application/json;charset=UTF-8",
                        data:data,
                        dataType:"json",
                        type:"post",
                        success:function (data) {
                            if(data>0){
                                layer.alert("数据上传成功，请前往管理我的书籍查看");
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
                    bookName:[   /^[\u4e00-\u9fa5]+$/,
                        "请输入正确的格式"
                    ]
                    ,
                    bookAuthor:[/^[\u4e00-\u9fa5_a-zA-Z0-9]+$/
                    , "请输入正确的格式"
                    ]
                    ,
                    image:function (value) {
                        if($("#image").attr('src') == ""){
                            alert($("#image").attr('src'));
                            return "请上传图片";
                        }
                    }
                    ,
                    price:[/^[0-9]+(.[0-9]{2})?$/
                        ,
                        "请输入正确的格式"
                    ]
                    ,
                    bsBooknum:[/^[0-9]$/
                        , "请输入正确的格式"
                    ]
                    ,
                    bsCratetime:[ /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/
                        , "请输入正确的格式"
                    ]
                    ,
                    press: [ /^[\u4e00-\u9fa5]+$/,
                        "请输入正确的格式"
                    ]
                    ,
                    bsUniversity:[/^[\u4e00-\u9fa5]+$/,
                        "请输入正确的格式"
                    ]
                });
                form.render();
            });
            //日期函数
            layui.use('laydate', function(){
                var laydate = layui.laydate;
                //执行一个laydate实例
                laydate.render({
                    elem: '#test1' //指定元素
                });
            });
        });
    </script>
</head>
<body>
<form class="layui-form" lay-filter="test1" method="post"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
    <input type="hidden" name = "bsLoginname" lay-verify="loginName" value="<%=userName%>"/>
    <div class="layui-form-item">
        <label class="layui-form-label">图书名称*</label>
        <div class="layui-input-block">
            <input type="text" name="bsBookname" lay-verify="bookName" placeholder="请输入"  autocomplete="off" class="layui-input" required/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图书作者</label>
        <div class="layui-input-block">
            <input type="text" name="bsBookauthor" lay-verify="bookAuthor" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">出版社*</label>
        <div class="layui-input-block">
            <input type="text" name="bsPressname" lay-verify="press" placeholder="请输入" autocomplete="off" class="layui-input"  required>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">预期价格*</label>
        <div class="layui-input-block">
            <input type="number" name="bsBookprice" lay-verify="price"  placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <img id="image" name = "image" lay-verify="image" src="" alt="">
        <label class="layui-form-label">图书照片*</label>
        <div class="layui-input-block">
            <input type="file" name = "bsBookcover" value="选择图片" accept="image/*" multiple="">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">书籍数量*</label>
        <div class="layui-input-block">
            <input type="number" name="bsBooknum" lay-verify="bsBooknum"  placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">所在学校*</label>
        <div class="layui-input-block">
            <input type="text" name="bsUniversity" lay-verify="bsUniversity" placeholder="请输入"
                   autocomplete="off" class="layui-input"  required>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">创建时间*</label>
        <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
            <input type="text" name = "bsCratetime" lay-verify="bsCratetime" class="layui-input" id="test1">
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