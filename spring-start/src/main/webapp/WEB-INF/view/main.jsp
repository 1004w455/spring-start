<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	${data }
	<br />
	<spring:message code="1" text="테스트 메인 페이지" />
	<%-- <a href="${pageContext.request.contextPath}/${sRole_LC}/account_list">account list</a> --%>
</body>
</html>