<%@ page pageEncoding="UTF-8"%>
<head>
<script src="${pageContext.request.contextPath}/js/util/wise_popup_component.js"></script>
<script type="text/javascript">
	initWisePopupComponent(); // 팝업메니저 초기화
</script>
</head>
<body>
	<a href="javascript:wisePopupComponent.popup('/ad/creative/test.popup', {
		popupTitle : 'Add Agency',
		okBtnText : '오케이',
		onFormOpenned : function(){
			alert('열려라 참깨! ㅋㅋㅋㅋ');
		},
		onTaskComplete : function(){
			alert('헤헤');
			close();
		}
	});">Show Popup</a>
	<div style="display: none;"></div>
	<!-- 
	<div id="_wise_popup_body" style="position: absolute; height: 622px; top: 50%; width: 720px; left: 50%; margin-top: -355px; margin-left: -467px; z-index: 103; background-color: blanchedalmond;">
		<div>
			<div id="_wise_popup_title_container">
				<span id="_wise_popup_title">Title</span> &nbsp;&nbsp;&nbsp;<a id="_wise_popup_btn_close" href="#">X</a>
			</div>
			<div id="_wise_popup_body"></div>
			<div id="_wise_popup_bottom"><button id="_wise_popup_btn_negative">Close</button><button id="_wise_popup_bottom_btn_option">Option</button><button id="_wise_popup_bottom_btn_positive">Ok</button></div>
		</div>
	</div>
 	-->
	<!-- 이 페이지에서 사용되는 스크립트 첨부 -->
</body>