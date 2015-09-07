<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<ul class="gnb" id="gnb">
		<li class="dashboard">
			<a href="/ag/dashboard">Dashboard</a>
		</li>
		<li class="report">
			<a href="/ag/advertiser/report">Report</a>
			<ul>
				<li><a href="/ag/advertiser/report">Advertiser Report</a></li>
				<li><a href="/ag/sales/report">Sales Report</a></li>
				<li><a href="/ag/campaign/report">Campaign Report</a></li>
			</ul>
		</li>
		<li class="manage">
			<a href="/ag/account/list">Manage</a>
			<ul>
				<li><a href="/ag/account/list">Advertiser Account</a></li>
				<li><a href="/ag/account/me">My Account</a></li>
			</ul>
		</li>
		<li class="payment">
			<a href="">Payment</a>
			<ul>
				<li><a href="">Payment History</a></li>
			</ul>
		</li>
	</ul>
</body>