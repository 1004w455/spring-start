<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<body>
	<div class="nav">
		<sec:authorize access="isAuthenticated()">
			<div class="account">
				<div class="account-profile">
					<div class="account-image">
						<img alt="" src="${pageContext.request.contextPath}/images/bg_account-808080_40x40.png">
					</div>
					<div class="account-id">
						<span>
							<c:choose>
								<c:when test="${sRole == 'ADMIN' or sRole == 'AGENCY' }">
									<a href="${pageContext.request.contextPath}/${sRoleUrl}/account_list">${sLoginId }님</a>
								</c:when>
								<c:when test="${sRole == 'ADVERTISER' or sRole == 'REVIEWER' }">
									<a>${sLoginId }님</a>
								</c:when>
							</c:choose>
						</span>
					</div>
					<button type="button" class="account-ok">OK</button>
				</div>
				<div class="account-movement">
					<div class="account-agency">
						<select id="ag_account">
							<option>Agency</option>
						</select>
					</div>
					<div class="account-advertiser">
						<select id="adv_account">
							<option>Choose Advertisr</option>
						</select>
					</div>
				</div>
			</div>
		</sec:authorize>
		<c:choose>
			<c:when test="${sRole == 'ADMIN' }">
				<jsp:include page="/WEB-INF/view/sitemesh/left_sa.jsp" />
			</c:when>
			<c:when test="${sRole == 'AGENCY' }">
				<jsp:include page="/WEB-INF/view/sitemesh/left_ag.jsp" />
			</c:when>
			<c:when test="${sRole == 'ADVERTISER' }">
				<jsp:include page="/WEB-INF/view/sitemesh/left_ad.jsp" />
			</c:when>
		</c:choose>
	</div>
</body>