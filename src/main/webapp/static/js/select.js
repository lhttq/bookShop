$(function () {
//引入新的插件
    layui.config({
        base: 'static/js/'//拓展模块的根目录
    }).extend({
        pca: 'pca'
    });
//使用自定义的插件pca
    layui.use(['form', 'layedit', 'laydate', 'upload', "jquery", "pca"], function () {
        var $ = layui.$
            , form = layui.form
            , pca = layui.pca;
        //带初始值进行初始化
        pca.init('select[name=P1]', 'select[name=C1]', 'select[name=A1]', '北京', '北京', '东城区');

        //不带初始值
        // pca.init('select[name=P1]', 'select[name=C1]', 'select[name=A1]');

        //输入提示
        $("#address").bind('input propertychange', function () {
                var address = document.getElementById("address").value;
                if (address == "") {
                    document.getElementById("addressTip").style.display = "none";
                    return;
                }
                var html = '';
                var province = document.getElementById("province").value;
                if (province == "全部") {
                    province = '';
                }
                var city = document.getElementById("city").value;
                if (city == "全部") {
                    city = '';
                }
                var area = document.getElementById("area").value;
                if (area == "全部") {
                    area = '';
                }

                //查询关键字
                var keywords = address;
                //此处使用的是高德地图服务
                    //用ajax向高德地图的服务器发送请求
                $.ajax({
                    type: "GET",
                    url: "https://restapi.amap.com/v3/assistant/inputtips?key=d4c940ccfa2aed4152a4885de4c5387a",
                    cache: false,
                    async: false,
                    data: {
                        "keywords": keywords,
                        "city":city
                    },
                    dataType: "json",
                    contentType: 'application/x-www-form-urlencoded',
                    success: function (data) {
                        //将从服务器获取到的数据添加到页面中
                        for (var i = 0; i < data.tips.length; i++) {
                            html += '<dd lay-value="" class="addressDd" onclick="ddclick(this)">' +
                                data.tips[i].name + '<span style="color:#9c9a9a;font-size:5px;">&nbsp' +
                                data.tips[i].address + '</span>' + '</dd>';
                        }
                    },
                    error:function () {
                        alert("请求失败");
                    }
                });
                document.getElementById("addressTip").innerHTML = html;
                var s = document.getElementById("addressTip").innerHTML;
                if (html == "") {
                    document.getElementById("addressTip").style.display = "none";
                } else {
                    document.getElementById("addressTip").style.display = "block";
                }

                var lis = document.getElementById("addressDetail").getElementsByTagName("dd");
                for (var i = 0; i < lis.length; i++) {
                    if (lis[i].tagName == "DD") {
                        lis[i].onclick = (function () {//增加单击事件
                                return function () {
                                    document.getElementById("address").value = this.innerText.trim().split(/\s+/)[0];
                                    document.getElementById("addressTip").style.display = "none";
                                }
                            }
                        )
                        (i);
                    }

                }

            }
        );

    });

});
