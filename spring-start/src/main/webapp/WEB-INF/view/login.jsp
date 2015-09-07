<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body onload="document.f.loginId.focus();">

	<h3>Login with Username and Password</h3>
	<c:if test="${not empty error }">
		<h4>${error }</h4>
	</c:if>

	<form name="f" action="login" method="POST">
		<%-- <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"> --%>
		<input type="text" name="loginId">
		<spring:message code="name" text="name" />
		<br />
		<!--  -->
		<input type="password" name="password">
		<spring:message code="password" text="password" />
		<br />
		<!--  -->
		<!-- <input type="checkbox" name="remember-me">remember-me<br /> -->
		<!--  -->
		<button type="submit">login</button>
	</form>
</body>
</html>