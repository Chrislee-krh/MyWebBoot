<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ajax_test.jsp</title>
	</head>
	<body>
		<input type="text" id="apple" value="홍길자">
		<input type="text" id="melon" value="홍길숙">
		<input type="text" id="grape" value="홍길동">
		
		<button onclick="check()">확인</button>
		
		<!-- jquery 라이브러리 불러오기...  -->
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.0.min.js" ></script>
		<script type="text/javascript">
		    // $(document).ready() 메서드는 document가 불려질 때 실행할 내용!
			$(document).ready(function() {
				var msg = $("#grape").val();
				
				if(msg != ''){
					alert(msg);
				}
			});
			
			function check() {
		    	/* var a = $("#melon").val();
		    	alert(a); */
		    	$.ajax({
		    		type : "post",
		    		url : "checkId",
		    		data : {
		    			"id" : "testId"
		    		},
		    		success : function(result) {
		    			alert("비동기 성공! \n result결과 : "+result);
		    		}
		    	});
		    }
			
			
		</script>
		
	</body>
</html>