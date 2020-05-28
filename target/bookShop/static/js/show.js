var list=new  Array(2);
list["河南省"]=["洛阳市","郑州市"];
list["湖南省"]=["长沙市","浏阳市"];
list["河南省"]["洛阳市"]=["洛龙区","伊滨区","高新技术开发区","老城区"];
list["河南省"]["郑州市"]=["高新技术开发区","二七区","中原区","金水区"];
list["湖南省"]["长沙市"]=["岳阳区","阳岳区"];
list["湖南省"]["浏阳市"]=["浏阳区","阳浏区"];
//将省份的城市添加到下拉框
function provinceSelect(province){
    $("#city").empty();//清空
    $("#city").append("<option value='请选择城市'>请选择城市</option>");
    var  provinces = $(province).val();
    for(var i=0;i < list[provinces].length;i++){
        $("#city").append("<option value='"+list[provinces][i]+"'>"+list[provinces][i]+"</option>");
    }
}
function citySelect(city) {
    $("#region").empty();
    $("#region").append("<option value='请选择区域'>请选择区域</option>");
    var citys = $(city).val();
    var provinces = $("#province").val();
    for (var i = 0; i < list[provinces][citys].length; i++) {
        $("#region").append("<option value='" + list[provinces][citys][i] + "'>" + list[provinces][citys][i] + "</option>");
    }
}
$(function () {
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        //监听导航点击
        element.on('nav', function(elem){
            onsole.log(elem);
        });
    });
    var option = "<option value='请选择省份'>请选择省份</option>";
    //添加下拉
    $("#province").append(option);
    //遍历数组将省份添加到下拉框
    for(var op in list){
        var option = "<option value='"+op+"'>"+op+"</option>";
        $("#province").append(option);
    }
});

