<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 国际化 -->
<!-- 
fmt:setLocale用于设置用户的本地语言，并将指定的locale保存到javax.servlet.jsp.jstl.fmt.local配置变量中。
Config.find(pageContext,Config.FMT_LOCALE)可以获取locale属性。
一般都放在页首，其他标签可通过ServletRequest.getLocale()获取locale
属性		描述									是否必要		默认值
value	指定ISO-639 语言码和ISO-3166 国家码	是			en_US
variant	特定浏览器变体						否			无
scope	Locale配置变量的作用域				否			Page
-->
<fmt:setLocale value="zh_CN"/> 
<!-- 
配置好struts2框架的国际化资源文件的basename后，
开发者就可以按照basename_language_country.properties命名规则来建立不同语言环境的资源文件,
注意：一定要unicode编码
 --> 
<fmt:setBundle basename="i18n/Applicationi18nResources" /> 

<!-- 系统根路径 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>