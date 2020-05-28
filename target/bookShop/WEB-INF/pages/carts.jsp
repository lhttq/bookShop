
<!DOCTYPE html>
<%@ page import="cn.lht.entity.BsPassword" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>购物车</title>
    <link rel="stylesheet" href="../static/css/cart.css" />
    <script src="../static/js/jquery-1.12.4.min.js"></script>
    <script>
        $(function () {
            var bsBookId = 0;
            var $cartContainer = $('<div class="mzContainer">\
                            <div class= "check-container" >\
                                <div class="shop-cart-nav">\
                                    <table>\
                                        <tr>\
                                            <td class="check-area">\
                                                <a href="javascript:;" class="check-label check-all">\
                                                    <i class="checkbox">\
                                                        <span class="check-mark"></span>\
                                                    </i>\
                                                    <em class="check-name">全选</em>\
                                                </a>\
                                            </td>\
                                            <td class="singal-price">\
                                                单价(元)\
                                            </td>\
                                            <td class="volumes">\
                                                数量\
                                            </td>\
                                            <td class="small-total">\
                                                小计(元)\
                                            </td>\
                                            <td class="edit-area">\
                                                <span class="edit">编辑</span>\
                                            </td>\
                                        </tr>\
                                    </table>\
                                </div>\
                                <ul class="goods-ul">\
                                </ul>\
                            </div >\
                            <div class="shop-cart-footer">\
                                <div class="cart-foot clearfix">\
                                    <div class="cart-foot-left">\
                                        <a href="javascript:;" class="check-label check-all">\
                                            <i class="checkbox">\
                                                <span class="check-mark"></span>\
                                            </i>\
                                            <em class="check-name">全选</em>\
                                        </a>\
                                        <em class="goods-delete">删除选中的商品</em>\
                                        <em class="goods-num">\
                                            共<span class="sum"></span>件商品，\
                                            已选择&nbsp;<span class="sum-selected"></span>&nbsp;件\
                                        </em>\
                                    </div>\
                                    <div class="cart-foot-right">\
                                        <em class="total-bill">\
                                            合计(不含运费)：\
                                        <span class="bill-price"></span>\
                                        </em>\
                                        <a href="../bsCarts/SelectAllByIs" class="order-btn ban-order">去结算</a>\
                                    </div>\
                                </div>\
                            </div>\
                        </div >');
    $(".header").after($cartContainer);
    var datas = {
        '书籍': []
    };
    var temp = [];
    var a = 0;
     var is = [];
    <c:forEach var="l" items="${bsBooksList}">
             var t = {};
            t.name = "${l.bsBookname}";
            t.img = "${l.bsBookcover}";
            t.bookId = "${l.bsBookid}";
            t.goodTip = "平装"
            t.singalPrice = "￥"+"${l.bsBookprice}";
            temp[a] = t;
            a++;
    </c:forEach>
            a = 0;
    <c:forEach items="${bsCartsList}" var="b">
            var t = {};
            is[a] = "${b.bsIscheck}";
            t = temp[a];
            t.num = "${b.bsCartnum}";
            console.log(t);
            temp[a] = t;
            a++;
    </c:forEach>
            for (var j = 0;j<a;j++){
                datas["书籍"].push(temp[j]);
            }
    $.each(datas, function (i, e) {
        var newTr = '';
        var $newLi = $('<li class="goods-list">\
                        <table class= "goods-header" >\
                            <tr>\
                                <td colspan="5">\
                                    <a href="javascript:;" class="check-label check-local-part">\
                                        <i class="checkbox">\
                                            <span class="check-mark"></span>\
                                        </i>\
                                        <em class="check-name">' + i + '</em>\
                                    </a>\
                                </td>\
                            </tr>\
                        </table >\
                        <table class="goods-body">\
                        </table>\
                    </li>');

        $(e).each(function (i, e) {
            newTr += '<tr>\
                        <td class="goods-col-select">\
                            <a href="javascript:;" class="check-label check-product">\
                                <i class="checkbox">\
                                    <span class="check-mark"></span>\
                                </i>\
                                <input class="bookId" type="hidden" value=\"'+e.bookId+'\"/>\
                            </a>\
                            <a href="javascript:;" class="goods-img">\
                                <img src="'+ e.img + '"\
                                    alt="">\
                            </a>\
                            <a href="javascript:;" class="goods-info">\
                                <h4 class="goods-info-title">'+ e.name + '</h4>\
                                <p class="goods-info-tips">'+ e.goodTip + '</p>\
                            </a>\
                        </td>\
                        <td class="goods-col-price">\
                            <span>'+ e.singalPrice + '</span>\
                        </td>\
                        <td class="goods-col-volumes">\
                            <div class="num-ctrl-area clearfix">\
                                <button class="minus">-</button>\
                                <input type="text" value= \"'+e.num+'\" class="input"/>\
                                <button class="plus">+</button>\
                                 <input class="bookId" type="hidden" value=\"'+e.bookId+'\"/>\
                                <em class="hint">限购10件</em>\
                            </div>\
                        </td>\
                        <td class="goods-col-total">\
                            <span></span>\
                        </td>\
                        <td class="goods-col-ctrl">\
                            <span>- -</span>\
                            <i class="del-product">\
                            <input class="bookId" type="hidden" value=\"'+e.bookId+'\"/>\
                                <span class="line-left"></span>\
                                <span class="line-right"></span>\
                            </i>\
                        </td>\
                    </tr>';
        });

        $newLi.children("table.goods-body").append(newTr);
        $newLi.appendTo($("ul.goods-ul"));
    });
    (function (win, undefined) {
        var ShopCart = function () {
            this.judge = '';
            this.curUnitBtn = null;
            this.fixedObj();
            this.dynamic1Obj();
            this.calcInfo();
            this.singalDel();
            this.globalDel();

            this.orderBtnCss();
            this.twoBtn();
            this.floatDelBtn();
            this.checkBox();
            this.inputChange();
            this.fixed();
            this.init();
        };
        ShopCart.prototype = {
            constructor: ShopCart,
            //初始化事件
            init: function () {
                var shopCart = this;

                this.input.each(function (i, e) {
                    var $thisButton = $(e).parent().find(shopCart.button);
                    shopCart.buttonCss($thisButton, $(e).val());
                });

                /*编辑按钮*/
                this.editBtn.parent().on("click", function () {

                    shopCart.editBtn.toggleClass(shopCart.edit);
                    if (shopCart.editBtn.hasClass(shopCart.edit)) {
                        shopCart.editBtn.text("编辑");
                        shopCart.delCtrl.show().siblings().fadeOut(100);
                    } else {
                        shopCart.editBtn.text("完成");
                        shopCart.delCtrl.hide().siblings().fadeIn(100);
                    };
                });
                /*弹出框取消按钮*/
                this.cancelBtn.on("click", function () {
                    shopCart.floatBox.fadeOut(200);
                });
                /*弹出框关闭按钮*/
                this.closeBtn.on("click", function () {
                    shopCart.floatBox.fadeOut(200);
                });

                $(window).on("resize scroll", function () {
                    shopCart.fixed();
                });
            },

            //获取固定的元素
            fixedObj: function () {
                this.mzContainer = $(".mzContainer");
                this.cartFoot = this.mzContainer.find("div.shop-cart-footer");
                this.checkAll = this.mzContainer.find("a.check-all");//全选按钮
                this.sum = this.mzContainer.find("span.sum");//总件数
                this.bookId = this.mzContainer.find(".bookId");//商品Id
                this.sumed = this.mzContainer.find("span.sum-selected");//已选总件数
                this.billPrice = this.mzContainer.find("span.bill-price");//合计价格
                this.orderBtn = this.mzContainer.find("a.order-btn");//结算按钮
                this.editBtn = this.mzContainer.find("td.edit-area>span.edit");//编辑按钮
                this.delSelected = this.mzContainer.find("em.goods-delete");//删除选中商品按钮
                //悬浮提示框区域
                this.floatBox = $(".float-box");
                this.delBtn = this.floatBox.find("a.delete");
                this.cancelBtn = this.floatBox.find("a.cancel");
                this.closeBtn = this.floatBox.find("i.close-btn");
                this.confirmTitle = this.floatBox.find("h4.confirm-title>span");
                this.confirmCon = this.floatBox.find("div.confirm-content");
                //class样式
                this.checked = 'checked';
                this.forbid = 'forbid';
                this.fixSite = 'fixed';
                this.banOrder = 'banOrder';
                this.edit = 'edit';
            },
            //获取当存在删除添加商品时的变动元素
            dynamic1Obj: function () {
                this.checkLabelAll = $("a.check-label");
                this.checkContainer = $(".check-container");
                this.cartNav = this.checkContainer.children(".shop-cart-nav");
                this.goodsList = this.checkContainer.find("li.goods-list");
                this.goodsHeader = this.goodsList.children("table.goods-header");
                this.goodsBody = this.goodsList.children("table.goods-body");
                this.checkLocalPart = this.goodsHeader.find("a.check-local-part");//某个品类的头部按钮
                this.goodsTr = this.goodsBody.find("tr");//商品卡片
                this.checkProduct = this.goodsBody.find("a.check-product");//单个商品勾选按钮
                this.button = this.goodsBody.find("button");
                this.plus = this.goodsBody.find(".plus");//加号按钮
                this.minus = this.goodsBody.find(".minus");//减号按钮
                this.input = this.goodsBody.find(".input");//输入框
                this.singalPrice = this.goodsBody.find("td.goods-col-price>span");//单价
                this.smallTotal = this.goodsBody.find("td.goods-col-total>span");//小计
                this.delCtrl = this.goodsBody.find("td.goods-col-ctrl>span");//小计后面的编辑区
                this.delProduct = this.goodsBody.find("i.del-product");
                this.bookId = this.goodsBody.find("input.bookId");
            },

            //获取选中与未选中变化时的元素
            dynamic2Obj: function () {
                this.checkLocalPartEd = $("a.check-local-part.checked");//某个品类中已经选中的全选按钮
                this.checkProductEd = $("a.check-product.checked");//单个商品中已经选中的勾选按钮
            },
            //总计、总件数、已选件数、小计计算
            calcInfo: function () {
                var shopCart = this;
                this.dynamic2Obj();
                var sum = 0,
                    sumed = 0,
                    total = 0;
                this.goodsTr.each(function (i, e) {
                    var $e = $(e),
                        numVal = parseInt($e.find(shopCart.input).val()),//输入框值
                        unitPrice = parseInt($e.find(shopCart.singalPrice).text().slice(1)),//单价
                        $smalltotalTxt = $e.find(shopCart.smallTotal);//小计
                    sum += numVal;//计算总件数
                    $smalltotalTxt.text("￥" + (numVal * unitPrice).toFixed(2));//计算小计价格
                });
                this.checkProductEd.closest(shopCart.goodsTr).each(function (i, e) {
                    var $e = $(e),
                        numVal = parseInt($e.find(shopCart.input).val()),
                        unitPrice = parseInt($e.find(shopCart.singalPrice).text().slice(1));//单价
                    sumed += numVal;//已选总件数
                    total += unitPrice * numVal;//计算总价价格
                });
                this.sum.text(sum);
                this.sumed.text(sumed);
                this.billPrice.text('￥' + total.toFixed(2));
            },
            //当输入框的值<=1或者>=10时，旁边的button变成禁止样式
            buttonCss: function (button, value) {
                var shopCart = this;
                button.each(function () {
                    $(this).removeClass(shopCart.forbid);
                });
                if (value == 1) {
                    button.eq(0).addClass(shopCart.forbid);
                };
                if (value == 10) {
                    button.eq(1).addClass(shopCart.forbid);
                };
            },
            //button按钮的点击事件
            twoBtn: function (i,e) {
                  <%
                   HttpSession httpSession = request.getSession();
                   String sessionID = request.getRequestedSessionId();
                   BsPassword bsPassword = (BsPassword) httpSession.getAttribute("user" + sessionID);
                   Integer userId = bsPassword.getBsUserid();
                    %>
                var shopCart = this;
                //加号事件
                shopCart.plus.on("click", function () {
                     var $this = $(this);
                     var value = parseInt($this.prev().val());
                    //点击减号发送ajax请求，将数据库值加一，并将值加一
                    //获取元素中的值
                     var bookId = $this.next().val();
                    var userId = parseInt("<%=userId%>") ;
                    var num = value + 1;
                    var data =
                        '{"bsUserid":'+userId+',"bsIscheck":1,"bsGoodsid":'+bookId+',"bsCartnum":'+ num +'}';
                     $.ajax({
                        url:"../bsCarts/UpdateNum",
                        contentType:"application/json;charset=UTF-8",
                        data:data,
                        dataType:"json",
                        type:"post",
                        success:function (data) {
                            console.log(data);
                            value++;
                            shopCart.buttonCss($this.parent().find(shopCart.button), value);
                            $this.prev().val(value);
                            shopCart.calcInfo();
                        },
                         error:function () {
                            alert("数据错误");
                         },
                    });
                    if (value > 10) {
                        return;
                    };
                });

                /*减号按钮*/
                shopCart.minus.on("click", function () {
                    //点击减号发送ajax请求，将数据库值减一，并将值减一
                    var $this = $(this);
                    var value = parseInt($this.next().val());
                    //点击减号发送ajax请求，将数据库值加一，并将值加一
                    //获取元素中的值
                     var bookId = $this.next().val();
                    var userId = parseInt("<%=userId%>") ;
                    var num = value - 1;
                    var data =
                        '{"bsUserid":'+userId+',"bsIscheck":1,"bsGoodsid":'+bookId+',"bsCartnum":'+ num +'}';
                     $.ajax({
                        url:"../bsCarts/UpdateNum",
                        contentType:"application/json;charset=UTF-8",
                        data:data,
                        dataType:"json",
                        type:"post",
                        success:function (data) {
                            console.log(data);
                            value--;
                            shopCart.buttonCss($this.parent().find(shopCart.button), value);$this.next().val(value);
                            shopCart.calcInfo();
                        },
                         error:function () {
                            alert("数据错误");
                         },
                    });
                    if (value > 10) {
                        return;
                    };
                    if (value < 1) {
                        return;
                    };
                });
            },
            //输入框改变事件
            inputChange: function () {
                var shopCart = this;
                this.input.on("change", function () {
                    var $this = $(this),
                        $thisVal = parseInt($this.val());
                    if ($thisVal > 10) {
                        $this.val(10);
                    } else if ($thisVal < 1 || isNaN($thisVal)) {
                        $this.val(1);
                    } else {
                        $this.val($thisVal);
                    };
                    shopCart.calcInfo();
                    console.log($this.parent().find(shopCart.button))
                    shopCart.buttonCss($this.parent().find(shopCart.button), parseInt($this.val()));
                });
            },
            //结算按钮样式变化
            orderBtnCss: function () {
                if (parseInt(this.sumed.text()) != 0) {
                    this.orderBtn.removeClass(this.banOrder);
                    this.orderBtn.attr('href','../bsCarts/SelectAllByIs');
                } else {
                    this.orderBtn.removeAttr('href');
                    this.orderBtn.addClass(this.banOrder);
                };
            },
            //删除选中商品的点击事件
            globalDel: function () {
                var shopCart = this;
                this.delSelected.on("click", function () {
                    shopCart.judge = "global";
                    shopCart.floatBox.fadeIn(200);
                    if (shopCart.checkProductEd.length != 0) {
                        shopCart.confirmTitle.text("删除");
                        shopCart.confirmCon.text("您确定要删除选中商品吗？");
                        shopCart.delBtn.show();
                        shopCart.cancelBtn.text("取消");
                    } else {
                        shopCart.confirmTitle.text("提示");
                        shopCart.confirmCon.text("请选择您要删除的商品");
                        shopCart.delBtn.hide();
                        shopCart.cancelBtn.text("确定");
                    };
                });
            },
            //删除单个商品的点击事件
            singalDel: function () {
                var shopCart = this;
                this.delProduct.on("click", function () {
                    bsBookId = $(this).find("input.bookId").val();
                    shopCart.judge = "singal";
                    shopCart.curUnitBtn = $(this);
                    shopCart.floatBox.fadeIn(200);
                    shopCart.confirmTitle.text("删除");
                    shopCart.confirmCon.text("您确定要删除该商品吗？");
                    shopCart.delBtn.show();
                    shopCart.cancelBtn.text("取消");
                });
            },
            //悬浮提示框中的确定删除点击事件
            floatDelBtn: function () {
                var shopCart = this;
                shopCart.delBtn.on("click", function () {
                    var userId = parseInt("<%=userId%>") ;
                     var data =
                        '{"bsUserid":'+userId+',"bsGoodsid":'+bsBookId+'}';
                    $.ajax({
                        url:"../bsCarts/DelByBookidandUserId",
                        contentType:"application/json;charset=UTF-8",
                        data:data,
                        dataType:"json",
                        type:"post",
                        success:function (data) {
                            alert("成功移出购物车");
                        },
                         error:function () {
                            alert("数据错误");
                         },
                    });
                    shopCart.floatBox.fadeOut(200);
                    if (shopCart.judge == "global") {
                        shopCart.checkProductEd.closest(shopCart.goodsTr).remove();
                        if (shopCart.checkLocalPart.hasClass(shopCart.checked)) {
                            shopCart.checkLocalPartEd.closest(shopCart.goodsList).remove();
                            if (shopCart.checkAll.hasClass(shopCart.checked)) {
                                shopCart.mzContainer.html("").css("height", '25rem');
                            };
                        };
                    } else if (shopCart.judge == "singal") {
                        var curLiIndex = shopCart.curUnitBtn.closest(shopCart.goodsList).index();
                        shopCart.curUnitBtn.closest(shopCart.goodsTr).remove();

                        if (shopCart.goodsList.eq(curLiIndex).find(shopCart.goodsTr).length == 0) {
                            console.log(1)
                            shopCart.goodsList.eq(curLiIndex).remove();
                        };
                    };
                    shopCart.dynamic1Obj();
                    shopCart.dynamic2Obj();
                    shopCart.calcInfo();
                    shopCart.orderBtnCss();
                    shopCart.fixed();
                    if (shopCart.goodsTr.length == 0) {
                        shopCart.mzContainer.html("").css("height", '25rem');
                    };
                });
            },
            //checkbox勾选框点击事件
            checkBox: function () {
                var shopCart = this;
                /*全选按钮*/
                shopCart.checkAll.on("click", function () {
                    var $this = $(this);
                    $this.toggleClass(shopCart.checked);
                    shopCart.dynamic2Obj();
                    if ($this.hasClass(shopCart.checked)) {
                        shopCart.checkLabelAll.addClass(shopCart.checked);
                    } else {
                        shopCart.checkLabelAll.removeClass(shopCart.checked);
                    };
                    shopCart.calcInfo();
                    shopCart.orderBtnCss();
                });

                /*分类勾选按钮*/
                shopCart.checkLocalPart.on("click", function () {
                    var $this = $(this);
                    $this.toggleClass(shopCart.checked);
                    shopCart.dynamic2Obj();
                    var $thisChildCheck = $this.closest(shopCart.goodsList).find(shopCart.checkProduct);//某一品类的单个商品勾选按钮
                    if ($this.hasClass(shopCart.checked)) {
                        $thisChildCheck.addClass(shopCart.checked);
                    } else {
                        $thisChildCheck.removeClass(shopCart.checked);
                    };
                    if (shopCart.checkLocalPartEd.length == shopCart.checkLocalPart.length) {
                        shopCart.checkAll.addClass(shopCart.checked);
                    } else {
                        shopCart.checkAll.removeClass(shopCart.checked);
                    }
                    shopCart.calcInfo();
                    shopCart.orderBtnCss();
                });
                /*具体商品勾选按钮*/
                var num = [0,0];
                shopCart.checkProduct.on("click", function () {
                    var $this = $(this);
                    var userId = "<%=userId%>";
                   let index = $(this).parent().parent().index();
                   num[index]++;
                    bsBookId = $(this).find("input.bookId").val();
                    $this.toggleClass(shopCart.checked);
                    shopCart.dynamic2Obj();
                    var $siblings = $this.closest(shopCart.goodsBody).find(shopCart.checkProduct),
                        $siblingsEd = $this.closest(shopCart.goodsBody).find(shopCart.checkProductEd),
                        $thisPart = $this.closest(shopCart.goodsList).find(shopCart.checkLocalPart);

                    if ($siblings.length == $siblingsEd.length) {
                        $thisPart.addClass(shopCart.checked);
                    } else {
                        $thisPart.removeClass(shopCart.checked);
                    };
                    if (shopCart.checkProduct.length == shopCart.checkProductEd.length) {
                        shopCart.checkAll.addClass(shopCart.checked);
                    } else {
                        shopCart.checkAll.removeClass(shopCart.checked);
                    };
                    if(num[index] == 1 && is[index] == 1){

                    }else if(num[index] == 1 && is[index] == 0){
                        is[index] = 1;
                        var data =
                        '{"bsUserid":'+userId+',"bsIscheck":'+is[index]+',"bsGoodsid":'+bsBookId+'}';
                        $.ajax({
                        url:"../bsCarts/UpdateNum",
                        contentType:"application/json;charset=UTF-8",
                        data:data,
                        dataType:"json",
                        type:"post",
                        success:function (data) {
                           if(data>0){

                           }else{

                           }
                        },
                         error:function () {
                            alert("数据错误");
                         },
                    });
                    }else{
                        if(is[index] == 1){
                            is[index] = 0;
                        }else{
                            is[index] = 1;
                        }
                        var data =
                        '{"bsUserid":'+userId+',"bsIscheck":'+is[index]+',"bsGoodsid":'+bsBookId+'}';
                        $.ajax({
                        url:"../bsCarts/UpdateNum",
                        contentType:"application/json;charset=UTF-8",
                        data:data,
                        dataType:"json",
                        type:"post",
                        success:function (data) {
                           if(data>0){
                           }else{
                           }
                        },
                         error:function () {
                            alert("数据错误");
                         },
                    });
                    }

                    shopCart.calcInfo();
                    shopCart.orderBtnCss();
                });
            },
            //foot结算区域位置变化
            fixed: function () {
                var offsetHeight = this.checkContainer.offset().top + this.checkContainer.outerHeight() + this.cartFoot.outerHeight() - $(window).height();
                if (offsetHeight >= $(document).scrollTop()) {
                    this.cartFoot.addClass(this.fixSite);
                } else {
                    this.cartFoot.removeClass(this.fixSite);
                };
            }
        }
        window.ShopCart = ShopCart;
    }(window));
    var shopcart = new ShopCart();
});

    </script>
</head>
<body style="">
<div class="float-box">
    <div class="confirm-box">
        <h4 class="confirm-title"> <span></span> <i class="close-btn"> <span class="line-left"></span> <span class="line-right"></span> </i> </h4>
        <div class="confirm-content">
            请选择您要删除的商品？
        </div>
        <div class="confirm-btn">
            <a href="javascript:;" class="delete">删除</a>
            <a href="javascript:;" class="cancel">取消</a>
        </div>
    </div>
</div>
<div class="header">
    <div class="header-center">
    </div>
</div>
<div class="mz-foot"></div>
</body>
</html>