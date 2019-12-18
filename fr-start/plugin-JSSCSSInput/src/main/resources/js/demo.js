//养成闭包的习惯
;(function () {

    window.onload = function () {
        $("#wrapper").children(":eq(1)").css("background-color", "#34c16b");
        console.log("插件渲染完成。。。。")
        var mobile;
        Dec.reqGet("/v10/user/account", {}, function (responseText) {
            mobile = responseText.data.mobile;
            $("<div/>").addClass("plugin-jscssinput-demo").html(mobile).appendTo("body");
            console.log(mobile)
        })

        console.log("插件开始渲染。。。。")

    }
    //$("<div/>").addClass("plugin-mobile-demo").html(mobile).appendTo("body");
})();