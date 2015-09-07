<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<ul class="gnb" id="gnb">
		<li class="dashboard"><a href="/sa/dashboard">Dashboard</a></li>
		<li class="report">
			<a href="#">Report</a>
			<ul>
				<li><a href="/sa/sales_report">Sales Report</a></li>
				<li><a href="/sa/agency_report">Agency Report</a></li>
				<li><a href="/sa/campaign_report">Campaign Report</a></li>
			</ul>
		</li>
		<li class="manage"
				><a href="#">Manage</a>
			<ul>
				<li><a href="/sa/account/list">Agency Account</a></li>
				<li><a href="/sa/account/me">My Account</a></li>
			</ul>
		</li>
		<li class="approval">
			<a href="#">Approval</a>
			<ul>
				<li><a href="/sa/advertiser">Advertiser</a></li>
				<li><a href="/sa/creative">Creative</a></li>
			</ul>
		</li>
		<li class="payment"><a href="">Payment</a></li>
	</ul>
</body>