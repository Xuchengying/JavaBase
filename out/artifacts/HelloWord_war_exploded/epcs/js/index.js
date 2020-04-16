/**
 * Created by Administrator on 2020/4/11 0011.
 */
//查询窗口大小
var clh = window.screen.height;
//调整高度中间主页面的高度
window.onload = function () {

    var subMain = document.getElementsByClassName("main");
    if(subMain.length>0){
        subMain=subMain[0].children;
    }
    for (var i = 0; i < subMain.length - 1; i++) {
        subMain[i].style.height = (clh - 75 - 80 - 16) + "px";
    }
}