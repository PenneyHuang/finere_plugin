;!(function ($) {//闭包的写法,前面最好是带一个; 要不然容易出问题。。
    /**
     * 还是直接继承默认的文本框对象,默认的文本框就是FR.TextEditor
     */
    FR.StyleTextEditor=FR.extend(FR.TextEditor,{
        /**
         * 初始化方法,
         * @private
         */
        _init: function () {
            FR.StyleTextEditor.superclass._init.apply(this, arguments);
        },
        /**
         * 这个是针对颜色需要修改的方法， 从控件的options方法里面获取后台传递过来的属性，这边直接获取fontColor属性值，可以上面去看下DemoWidget
         * 的返回
         * @returns {*|jQuery|HTMLElement}
         * @private
         */
        _createEditComp: function() {

            var o=this.options;

            return $("<input style='color:"+o.fontColor+"' type='text'/>");//返回的文本框带上颜色属性
        }
    })
    /**
     * 使用shortcut方法注册控件，styletext 这个是一个控件名称需要唯一而且和widget的getXType返回的值需要是一样的
     */
    $.shortcut("styletext", FR.StyleTextEditor);
})(jQuery);