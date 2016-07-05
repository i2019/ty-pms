
// usage: log('inside coolFunc', this, arguments);
// paulirish.com/2009/log-a-lightweight-wrapper-for-consolelog/
window.log = function(){
  log.history = log.history || [];   // store logs to an array for reference
  log.history.push(arguments);
  if(this.console) {
    arguments.callee = arguments.callee.caller;
    var newarr = [].slice.call(arguments);
    (typeof console.log === 'object' ? log.apply.call(console.log, console, newarr) : console.log.apply(console, newarr));
  }
};

// make it safe to use console.log always
(function(b){function c(){}for(var d="assert,count,debug,dir,dirxml,error,exception,group,groupCollapsed,groupEnd,info,log,timeStamp,profile,profileEnd,time,timeEnd,trace,warn".split(","),a;a=d.pop();){b[a]=b[a]||c}})((function(){try
{console.log();return window.console;}catch(err){return window.console={};}})());


// place any jQuery/helper plugins in here, instead of separate, slower script files.

/*start of jquery modal*/
(function($) {
    $.modal = function(data, options) {
        return $.modal.impl.init(data, options)
    };
    $.modal.close = function() {
        $.modal.impl.close(true)
    };
    $.fn.modal = function(options) {
        return $.modal.impl.init(this, options)
    };
    $.modal.defaults = {
        position:"absolute",
    		overlay: 50,
        overlayId: "modalOverlay",
        overlayCss: {},
        containerId: "modalContainer",
        containerCss: {},
        close: true,
        closeTitle: "Close",
        closeClass: "modalClose",
        persist: false,
        onOpen: null,
        onShow: null,
        onClose: null
    };
    $.modal.impl = {
        opts: null,
        dialog: {},
        init: function(data, options) {
            if (this.dialog.data) {
                return false
            }
            this.opts = $.extend({},
            $.modal.defaults, options);
            if (typeof data == "object") {
                data = data instanceof jQuery ? data: $(data);
                if (data.parent().parent().size() > 0) {
                    this.dialog.parentNode = data.parent();
                    if (!this.opts.persist) {
                        this.dialog.original = data.clone(true)
                    }
                }
            } else {
                if (typeof data == "string" || typeof data == "number") {
                    data = $("<div>").html(data)
                } else {
                    if (console) {
                        console.log("SimpleModal Error: Unsupported data type: " + typeof data)
                    }
                    return false
                }
            }
            this.dialog.data = data.addClass("modalData");
            data = null;
            this.create();
            this.open();
            if ($.isFunction(this.opts.onShow)) {
                this.opts.onShow.apply(this, [this.dialog])
            }
            return this
        },
        create: function() {
            this.dialog.overlay = $("<div>").attr("id", this.opts.overlayId).addClass("modalOverlay").css($.extend(this.opts.overlayCss, {
                opacity: this.opts.overlay / 100,
                height: "100%",
                width: "100%",
                position: "fixed",
                left: 0,
                top: 0,
                zIndex: 3000
            })).hide().appendTo("body");
            this.dialog.container = $("<div>").attr("id", this.opts.containerId).addClass("modalContainer").css($.extend(this.opts.containerCss, {         	
            	position: this.opts.position,
                zIndex: 3100
            })).append(this.opts.close ? '<a class="modalCloseImg ' + this.opts.closeClass + '" title="' + this.opts.closeTitle + '"></a>': "").hide().appendTo("body");
            if ($.support.msie && ($.support.version < 7)) {
                this.fixIE()
            }
            if(this.opts.position){
            	this.dialog.data.css({"margin":0,"top":this.opts.position.top+"px","left":this.opts.position.left+"px"});
            }else{
            	this.dialog.data.css({"margin":0,"top":($(document).height-this.dialog.data.height)/2+"px","left":($(document).height-this.dialog.data.height)/2+"px"});
            }      
            this.dialog.container.append(this.dialog.data.hide())
        },
        bindEvents: function() {
            var modal = this;
            $("." + this.opts.closeClass).click(function(e) {
                e.preventDefault();
                modal.close()
            })
        },
        unbindEvents: function() {
            $("." + this.opts.closeClass).unbind("click")
        },
        fixIE: function() {
            var wHeight = $(document.body).height() + "px";
            var wWidth = $(document.body).width() + "px";
            this.dialog.overlay.css({
                position: "absolute",
                height: wHeight,
                width: wWidth
            });
            this.dialog.container.css({
                position: "absolute"
            });
            this.dialog.iframe = $('<iframe src="javascript:false;">').css($.extend(this.opts.iframeCss, {
                opacity: 0,
                position: "absolute",
                height: wHeight,
                width: wWidth,
                zIndex: 1000,
                width: "100%",
                top: 0,
                left: 0
            })).hide().appendTo("body")
        },
        open: function() {
            if (this.dialog.iframe) {
                this.dialog.iframe.show()
            }
            if ($.isFunction(this.opts.onOpen)) {
                this.opts.onOpen.apply(this, [this.dialog])
            } else {
                this.dialog.overlay.show();
                this.dialog.container.show();
                this.dialog.data.show()
            }
            this.bindEvents()
        },
        close: function(external) {
            if (!this.dialog.data) {
                return false
            }
            if ($.isFunction(this.opts.onClose) && !external) {
                this.opts.onClose.apply(this, [this.dialog])
            } else {
                if (this.dialog.parentNode) {
                    if (this.opts.persist) {
                        this.dialog.data.hide().appendTo(this.dialog.parentNode)
                    } else {console.log(12345)
                        this.dialog.data.remove();
                        this.dialog.original.appendTo(this.dialog.parentNode)
                    }
                } else {
                    this.dialog.data.remove()
                }
                this.dialog.container.remove();
                this.dialog.overlay.remove();
                if (this.dialog.iframe) {
                    this.dialog.iframe.remove()
                }
                this.dialog = {}
            }
            this.unbindEvents()
        }
    }
})(jQuery); 
/*end of jquery modal*/