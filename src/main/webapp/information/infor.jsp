<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%
   String myctx = request.getContextPath();
   //치환 변수 선언
    pageContext.setAttribute("cr", "\r"); //Space
    pageContext.setAttribute("cn", "\n"); //Enter
    pageContext.setAttribute("crcn", "\r\n"); //Space, Enter
    pageContext.setAttribute("br", "<br/>"); //br 태그

%>
<jsp:include page="/top.jsp"/>
<div class="container">
   <div style="display:flex; justify-content:space-between;max-width:1400px;" >
      <div class="col-xs-3">
      	<h2 style="white-space: nowrap;">${location.loc_name}</h2>
      </div>
      <div style="padding-top:20px">
      	<button class="btn btn-success" onclick="location.href='review/review.do?loc_num=${param.num}'">리뷰 확인</button>
      </div>
   </div>
   <hr>
   <p class="info" style="text-align:center;padding:0;">
	   <span style="font-weight:700; color:#111">지역 특산물</span><br>
	   ${information.info_spe }<br>
	   <br>
	   <span style="font-weight:700; color:#111">맛집 리스트</span><br>
	   ${fn:replace(information.info_list,crcn,br)}<br>
	   <br>
	   <span style="font-weight:700; color:#111">추천 명소</span><br>
	   <br>
	   <c:forEach var="recommend" items="${recommend}">
		   <span style="font-weight:700; color:#111">
		   		- ${recommend.rec_name }
		   </span><br>
		   ${fn:replace(recommend.rec_content,crcn,br)}<br>
		   <img class="img-responsive info_img" src="<%=myctx %>/images/${recommend.rec_filename}" style="width:600px;"><br>
	   </c:forEach>
   
   </p>
   
   
</div>
<jsp:include page="/foot.jsp"/>