<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="top.jsp" />
<%
	String myctx = request.getContextPath();
%>
<img class="map_img" src="<%=myctx%>/images/전국지도.png" usemap="#map" alt="전국지도">

				<map name="map">
					<area target="_self" alt="춘천" title="춘천" href="<%=myctx%>/infor.do?num=3"
						coords="343,127,340,176,346,214,395,184,413,152,401,132" shape="poly">
					<area target="_self" alt="태백" title="태백" href="<%=myctx%>/infor.do?num=4" coords="605,292,580,353,624,343" shape="poly">
					<area target="_self" alt="인제" title="인제" href="<%=myctx%>/infor.do?num=2"
						coords="453,64,418,150,469,185,511,144,492,125,492,85" shape="poly">
					<area target="_self" alt="장흥" title="장흥" href="<%=myctx%>/infor.do?num=5" coords="205,855,193,874,205,949,238,907,229,868"
						shape="poly">
					<area target="_self" alt="영광" title="영광" href="<%=myctx%>/infor.do?num=1" coords="128,730,99,777,143,785,164,755,144,758"
						shape="poly">
					<area target="_self" alt="정읍" title="정읍" href="<%=myctx%>/infor.do?num=6"
						coords="215,654,178,682,194,726,226,706,248,711,251,678,233,665" shape="poly">
				</map>
				
				<script>
					$(function(){
						$('img[usemap]').rwdImageMaps();
						$("#img").width("100%");
					});
				</script>

<jsp:include page="foot.jsp" />