<%@ page import="cn.lht.entity.BsPassword" %>
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="enen">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>订单信息</title>
    <link rel="stylesheet" href="../static/css/order.css">
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <script src="../static/js/jquery-2.2.4.min.js"></script>
    <script src="../static/layui/layui.all.js"></script>
    <script src="../static/layui/layui.js"></script>
    <style>
        .class1{
            border: 1px solid rgb(0, 195, 245)!important;
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
            var index;
            var $ul = $("#ul");
            var userId = "<%=userId%>"
            var data =
                    '{"bsUserid":'+userId+'}';
            $.ajax({
                    url:"../bsAddress/selectByUserId",
                    contentType:"application/json;charset=UTF-8",
                    data:data,
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        for (let i = 0; i < data.length; i++) {
                            let info = data[i].bsUsername + data[i].bsUserphone;
                            let detailAddress = data[i].bsAreaidpath;
                            var $li = "<li>\n" +
                    "                <div class=\"info\"> "+info+" </div>\n" +
                    "                <div class=\"address\">"+detailAddress+"</div>\n" +
                    "            </li>";
                            $ul.prepend($li);
                        }
                    },
                     error:function () {
                        alert("数据错误");
                        },
            });
             $('#add').on('click', function(){
                layer.open({
                    type: 2,
                    title: '添加新地址',
                    maxmin: true,
                    shadeClose: false, //点击遮罩关闭层
                    area : ['800px' , '364px'],
                    content: '../add.jsp',
                });
             });
             $ul.on('click','li',function () {
                 index = $(this).index();
                 $(this).addClass('class1');
                 $(this).siblings().removeClass('class1');
             });
            layui.use('form', function(){
                var form = layui.form;
                //监听提交
                form.on('submit(formDemo)', function(data){
                    layer.msg(JSON.stringify(data.field));
                    return false;
                });
            });
            var table = $("#tbody");
            var tr = $("#tr");
            var bookImg = [];
            var bookNames = [];
            var bookPress = [];
            var bookPrice = [];
            var bookId = [];
            var num = [];
            var sum = [];
            var Sum = 0;
            var i = 0;
            <c:forEach  var="l" items="${bsBooksList}">
                bookId[i] = "${l.bsBookid}";
                bookImg[i] = "${l.bsBookcover}";
                bookNames[i] = "${l.bsBookname}";
                bookPrice[i] = "${l.bsBookprice}";
                i++;
            </c:forEach>
            i = 0;
            <c:forEach  var="l" items="${bsCartsList}">
                num[i] = "${l.bsCartnum}";
                i++;
            </c:forEach>
            i = 0;
            <c:forEach  var="l" items="${bsPressList}">
                bookPress[i] = "${l.bsPressname}";
                i++;
            </c:forEach>
            for (var i = 0; i < bookPrice.length; i++) {
                sum[i] = num[i] * bookPrice[i];
                Sum = Sum + sum[i];
                var $tr = $(" <tr>\n" +
                "                <td>\n" +
                "                    <span class = \"image\"><img src=\""+bookImg[i]+"\" alt=\"\"></span>\n" +
                "                    <span>\n" +
                "                        <h6 class = \"bookName\">"+bookNames[i]+"</h6>\n" +
                "                        <span class=\"press\">"+bookPress[i]+"</span>\n" +
                "                    </span>\n" +
                "                </td>\n" +
                "                <td>￥ "+bookPrice[i]+"</td>\n" +
                "                <td>"+num[i]+"</td>\n" +
                "                <td>￥ "+sum[i]+"</td>\n" +
                "                <td>免邮</td>\n" +
                "            </tr>");
            table.prepend($tr);
            }
            var $td = $("<td>合：￥ "+Sum+"</td>");
            tr.append($td);
            $("#submit").click(function () {
                var Orderno = random_No(3);
                var payFrom = $("input[name='pay']").val();
                var data = '{"bsOrderno":"'+Orderno+'",' +
                    '"bsUserid":'+userId+',' +
                    '"bsOrderstatus":'+0+',' +
                    '"bsBooksmoney":'+Sum+',' +
                    '"bsLivertype":'+0+',' +
                    '"bsDelivermoney":'+0+',' +
                    '"bsPaytype":'+1+',' +
                    '"bsPayfrom":'+payFrom+',' +
                    '"bsIspay":'+0+',' +
                    '"bsUsername":"'+index+'",' +
                    '"bsUseraddress":"'+index+'",' +
                    '"bsUserphone":"'+index+'",' +
                    '"bsIsinvoice":'+0+',' +
                    '"bsIsrefund":'+0+',' +
                    '"bsIsclosed":'+0+',' +
                    '"bsDataflag":'+1+'}';
                console.log(data);
                $.ajax({
                url:"../bsOrder/insertOne",
                contentType:"application/json;charset=UTF-8",
                data:data,
                dataType:"json",
                type:"post",
                success:function (data) {
                    layer.alert("购买成功");
                    let orderid = data[0].bsOrderid;
                    for(let i = 0;i < bookImg.length;i++){
                        let data1 = '{"bsOrderid":'+orderid+',' +
                            '"bsGoodsid":'+bookId[i]+',' +
                            '"bsGoodsnum":'+num[i]+',' +
                            '"bsGoodsprice":'+bookPrice[i]+',' +
                            '"bsGoodsname":"'+bookNames[i]+'",' +
                            '"bsGoodimg":"'+bookImg[i]+'"}';
                        $.ajax({
                            url:"../bsOrderbooks/insertOne",
                            contentType:"application/json;charset=UTF-8",
                            data:data1,
                            dataType:"json",
                            type:"post",
                            success:function (data) {
                            },
                            error:function () {
                                layer.alert("数据错误");
                            }
                        });
                    }
                    layer.alert("购买成功");
                },
                error:function () {
                    layer.alert("数据异常");
                }
            });

            });
        });
        function random_No(j) {
            var random_no = "";
            for (var i = 0; i < j; i++) //j位随机数，用以加在时间戳后面。
            {
                random_no += Math.floor(Math.random() * 10);
            }
            random_no = new Date().getTime() + random_no;
            return random_no;
        };
    </script>
</head>
<body>
    <div class="order-address">
        <div class="order-address-title">购物车信息</div>
        <ul id="ul">
            <li id="add"><i class="layui-icon layui-icon-add-1"></i></li>
        </ul>
    </div>
    <div class="order-cart">
        <div class="order-product-title">
            确认订单信息
        </div>
        <table class="layui-table"  lay-skin="nob">
            <colgroup>
                <col width="400">
                <col width="200">
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>供应商：魅族</th>
                <th>单价</th>
                <th>数量</th>
                <th>小计</th>
                <th>配送方式</th>
            </tr>
            </thead>
            <tbody id="tbody">
            <tr id="tr">
                <td> <div class="layui-form-item">
                    <label class="layui-form-label">发票抬头</label>
                    <div class="layui-input-block">
                        <input id="a" type="text" name="title" required  lay-verify="required" placeholder="默认抬头" autocomplete="off" class="layui-input">
                    </div>
                </div></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="order-total">
        <div class="order-product-title">
            支付方式
        </div>
        <form class="layui-form" action="JavaScript:;" >
             <div class="layui-input-block">
              <input type="radio" name="pay" value="1" title="支付宝" checked>
              <input type="radio" name="pay" value="2" title="微信" >
            </div>
            <input id="submit" class="layui-btn layui-btn-normal" type="submit" value="提交">
        </form>
    </div>
</body>
</html>
