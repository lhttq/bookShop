$(function () {
    layui.use('layer', function(){
        var layer = layui.layer;
        $("#submit").click(function () {
            var flog = false;
            var oldpassword = $("#oldpassword").val();
            var newpassword = $("#newpassword").val();
            var name = $("#name").val();
            $("#newpassword").blur(function () {
                if(oldpassword != newpassword){
                    layer.alert("两个密码不匹配，请确认");
                }
            });
            if(name == ""){
                layer.alert("用户名不能为空");
            }else if(oldpassword == ""){
                layer.alert("密码不为空");
            }else if(newpassword ==""){
                layer.alert("密码不为空");
            }else{
                var data = '{"bsLoginname":"'+name+'","bsPassword":"'+newpassword+'"}'
               $.ajax({
                url:"../bsPassword/updateByLogiName",
                contentType:"application/json;charset=UTF-8",
                data:data,
                dataType:"json",
                type:"post",
                success:function (data) {
                   if(data == 0){
                       layer.alert("用户名不存在");
                   }else{
                       window.location = '../bsPassword/Skip2';
                   }
                },
                error:function () {
                    layer.alert("新密码不能与最近使用密码一样");
                }
            });
            }
            return flog;
        });
    });
});