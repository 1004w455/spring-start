<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<body>
	<div class="header" id="header">

		<h1 class="logo">
			<a href="#">
				<img src="${pageContext.request.contextPath}/images/img_logo-313131-72x25.png" alt="BAND"/>
			</a>
		</h1>

		<ul class="status">
			<li class="language--status">
				<select name="" id="lang_div">
					<option value="?lang=ko_KR">한국어</option>
					<option value="?lang=ko_KR">English</option>
					<option value="?lang=ko_KR">中國語</option>
				</select>
			</li>
			<li class="role-status">
				<sec:authorize access="isAuthenticated()">
				<c:choose>
					<c:when test="${sRole == 'ADMIN' }">
						<a href="${pageContext.request.contextPath}/sa/dashboard">Admin Home</a>
					</c:when>
					<c:when test="${sRole == 'AGENCY' }">
						<a href="${pageContext.request.contextPath}/ag/dashboard">Agency Home</a>
					</c:when>
					<c:when test="${sRole == 'ADVERTISER' }">
						<a href="${pageContext.request.contextPath}/adv/manage/campaign">Advertiser Home</a>
					</c:when>
					<c:when test="${sRole == 'REVIEWER' }"></c:when>
				</c:choose>
				</sec:authorize>
			</li>
			<li class="login--status">
				<sec:authorize access="isAnonymous()">
					<a href="${pageContext.request.contextPath}/login"><spring:message code="login" text="login"/></a>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<a href="${pageContext.request.contextPath}/logout"><spring:message code="logout" text="logout"/></a>
				</sec:authorize>
			</li>
		</ul>

		<%--<img alt="" src="/images/common/ajax_loading.gif" style="width: 80px;">--%>
		<%--<sec:authorize access="isAnonymous()">
			<div style="float:right;">
				<a href="${pageContext.request.contextPath}/login"><spring:message code="login" text="login"/></a>
			</div>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<div style="float:right;">
				<c:choose>
					<c:when test="${sRole == 'ADMIN' }">
						<a href="${pageContext.request.contextPath}/sa/dashboard">Admin Home</a>
					</c:when>
					<c:when test="${sRole == 'AGENCY' }">
						<a href="${pageContext.request.contextPath}/ag/dashboard">Agency Home</a>
					</c:when>
					<c:when test="${sRole == 'ADVERTISER' }">
						<a href="${pageContext.request.contextPath}/adv/manage">Advertiser Home</a>
					</c:when>
					<c:when test="${sRole == 'REVIEWER' }"></c:when>
				</c:choose>
				<a href="${pageContext.request.contextPath}/logout"><spring:message code="logout" text="logout"/></a>
			</div>
		</sec:authorize>--%>
		<%--<div style="float:right; margin-right:10px;">
			<!--(자바:${pageContext.response.locale}) // (메시지:<spring:message code="locale" text="로케일"/>) -->
			<a href="javascript:;" id="lang">언어</a>
			<ul style="display:none;" id="lang_div">
				<li><a href="?lang=ko_KR">한국어</a></li>
				<li><a href="?lang=en_US">English</a></li>
				<li><a href="?lang=zh_TW">中國語</a></li>
			</ul>
	 	</div>--%>
	 	<script type="text/javascript">
	 		$(function(){
	 			$("#lang").on("click", function(){
	 				$("#lang_div").show();
	 			});
	 		});
	 	</script>
 	</div>
</body>