String.prototype.format = function() {
	if (arguments.length == 0)
		return this;
	for ( var s = this, i = 0; i < arguments.length; i++)
		s = s.replace(new RegExp("\\{" + i + "\\}", "g"), arguments[i]);
	return s;
};

function i18n_replace(str, arguments) {
	
	if (arguments.length == 0)
		return str;
	for ( var i = 0; i < arguments.length; i++)
		str = str.replace(new RegExp("\\{" + i + "\\}", "g"), arguments[i]);
	return str;
};



var i18n_zh = {
	'NullError001' : '{0}字段不能为空{1}'
};
var i18n_en = {
	'NullError001' : 'The {0} was not null{1}'
};

var i18nResources = null;
function initI18nJs(localLanguage) {
	if (localLanguage == 'en_US') {
		i18nResources = i18n_en;
	} else if (localLanguage == 'zh_CN') {
		i18nResources = i18n_zh;
	}
};

//设置语言默认为中文
var localLanguage='zh_CN';
initI18nJs(localLanguage);

//存在占位符的实例
/*
//先把每个占位符的内容放入数组
var arry = new Array();
arry.push('TEST');
arry.push('!');
//获取存在占位符的国际化字符串
var str = i18nResources.NullError001;
//调用方法，用数组的内容分别替换掉占位符
alert(i18n_replace(str,arry));
*/