// 导航栏
$(function () {
    //从数据库获取展示书籍，可以换成随机数和随机数量
    var ids = [0,4];
    $.ajax({
        url:"bsBooks/queryAllByLimit",
        contentType:"application/json;charset=UTF-8",
        data:{"ids[]":ids},
        dataType:"json",
        type:"get",
        success:function (data) {
            var $ul = $("#ul");
            for(var i = 0;i<data.length;i++){
                var $li = $(" <li>\n" +
                    "          <div class=\"card\">\n" +
                    "            <img src="+data[i].bsBookcover+" alt=\"Avatar\"" +
                    " style=\"width:100%\">\n" +
                    "            <div class=\"container\">\n" +
                    "              <h4><b>"+data[i].bsBookname+"</b></h4>\n" +
                    "              <p>价格:"+data[i].bsBookprice+"</p>\n" +
                    "            </div>\n" +
                    "          </div>\n" +
                    "        </li>");
                $ul.append($li);
            }
            $("#ul").on("click","li",function () {
              // alert($(this));
                var index = $(this).index();
                var url = "bsBooks/selectOne?bsBookid="+data[index].bsBookid;
                window.location = url;
        });
        }
    });
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        //监听导航点击
        element.on('nav', function(elem){
            onsole.log(elem);
        });
    });
    // 轮播图
    layui.use(['carousel', 'form'], function(){
        var carousel = layui.carousel
            ,form = layui.form;
        //常规轮播
        carousel.render({
            elem: '#lb'
            ,arrow: 'always'
            ,interval: 1800
            ,width: '778px'
            ,height: '440px'
        });
        //事件
        carousel.on('change(test1)', function(res){

        });

        var $ = layui.$, active = {
            set: function(othis){
                var THIS = 'layui-bg-normal'
                    ,key = othis.data('key')
                    ,options = {};
                othis.css('background-color', '#5FB878').siblings().removeAttr('style');
                options[key] = othis.data('value');
                ins3.reload(options);
            }
        };

        //监听开关
        form.on('switch(autoplay)', function(){
            ins3.reload({
                autoplay: this.checked
            });
        });

        $('.demoSet').on('keyup', function(){
            var value = this.value
                ,options = {};
            if(!/^\d+$/.test(value)) return;

            options[this.name] = value;
            ins3.reload(options);
        });
    });


});