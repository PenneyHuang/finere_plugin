//养成闭包的习惯
;(function () {
    $("<div/>").addClass("plugin-jscssinput-demo").html("Hello World!").appendTo("body");
    console.log("插件开始渲染。。。。")
    // setTimeout($("div.dec-frame-header").css("background-color", "#34c16b"), 1000)
    // $(document).onload(function () {
    //
    //     console.log("页面渲染完成。。。。")
    // })

    window.onload = function () {
        // console.log($("div.dec-frame-header"))
        // $("div.dec-frame-header").css("background-color", "#34c16b");
        $("#wrapper").children(":eq(1)").css("background-color", "#34c16b");
        console.log("插件渲染完成。。。。")
    }


})();