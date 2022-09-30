<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<br><br>
	<c:if test="${mode=='get'}">
	<div id="content" style="height:360px; text-align:center">
		<form name="idf" action="idCheck.do" method="post">
			<label for="userid">사용할 ID</label>
			<input type="text" name="userid" id="userid"
			 placeholder="User ID" autofocus="autofocus"
			 class="box">
			<button class="btn" style="background-color:green; color:white; padding:5px; border-radius:5px" >확인</button>
		</form>
	</div>
	</c:if>
	<c:if test="${mode =='post'}">
			<c:if test="${result =='ok'}">
			<div id="content" style="height:390px">
				<h3><b>${userid}를 사용할 수 있습니다.</b></h3>
				
				<button class="btn" onclick="setId('${userid}')" 
				style="background-color:green; color:white; padding:5px; border-radius:5px">닫  기</button>
			</div>
			</c:if>
			<c:if test="${result=='fail'}">
			<div id="content" style="height:390px">
				<h3>${userid}는 이미 사용 중입니다.</h3>
				<form name="idf" action="idCheck.do" method="post">
				<label for="userid">아이디</label>
				<input type="text" name="userid" id="userid"
				 placeholder="User ID" autofocus="autofocus"
				 class="box">
				<button class="btn" style="background-color:green">확  인</button>
				</form>
			</div>
			</c:if>
	</c:if>			
		<script>
			function setId(uid){
				opener.document.mf.userid.value = uid;
				self.close();
				
			}
		</script>
</body>
</html>