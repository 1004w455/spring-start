<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ad Server Test Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <script src="${pageContext.request.contextPath}/js/vendor/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/vendor/webfont.js"></script>
    <%--<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>--%>
    <script>
        var rootPath = '${pageContext.request.contextPath}';
        var sRole = '${sRole}';
        var roleUrl = '/${sRoleUrl}';
        var loginedAccount = $.parseJSON('${loginedAccount.jsonExcl }');
        WebFont.load({
            google : {
                families : [ 'Roboto Condensed' ]
            }/*,
            custom: {
                families: ['Nanum Barun Gothic'],
                urls: ['css/nanumbarungothic.css']
            }*/
        });
    </script>
    <script src="${pageContext.request.contextPath}/js/common/account.js"></script>
    <decorator:head/>
    <style>
/*     	a { color:#fff; } */
    	td { border: solid black 1px; }
    </style>
</head>
<body>
    <div class="wrap">
        <page:applyDecorator name="header"/>
        <div class="container">
            <page:applyDecorator name="left"/>
            <div class="contents">
                <decorator:body/>
                <page:applyDecorator name="footer"/>
            </div>
        </div>
    </div>
    <script>
        /**
         * Created by user on 2015-08-06.
         */
        $('#gnb>li>a').on('click',function(e){
//             e.preventDefault();
            var _this=$(this),
                    _sub=_this.find('ul').length;

            if (_this.hasClass('_active')){
                _this.next('ul').slideUp();
                _this.removeClass('_active')
            }
            else {
                _this.parents('.gnb').find('a').removeClass('_active');
                _this.parents('.gnb').find('ul').slideUp();
                _this.addClass("_active");
                _this.next('ul').slideDown();
            }
        });


        $("#gnb ul ._active").parents('ul').show()
                .closest('ul').parent('li').children('a').addClass('_active');


        $('#gnb>li ul a').on('click',function(){
            var _this=$(this);
            _this.parent('li').siblings('li').find('a').removeClass('_active')
            _this.addClass("_active");
			// return false;
        });
    </script>
</body>
</html>