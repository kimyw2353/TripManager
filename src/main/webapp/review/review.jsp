<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loc" value="${location} }" scope="session" />
<jsp:include page="/top.jsp" />
<div id="content">
	<div class="row">
		<div style="max-width: 900px; margin: 0 auto">
			<!-- 아이디가 review인 td는 스타일을 줬어용-------------------------------------------------------------------->
			<table class="table">
				<tr>
					<td style="width:50%;">제목</td>
					<td>작성자</td>
					<td>작성한 날짜</td>
					<td>조회수</td>
				</tr>
				<c:if test="${reviewArr eq null or empty reviewArr}">
					<tr>
						<td colspan="4"><b>등록된 리뷰가 없습니다</b></td>
					</tr>
				</c:if>
				<c:if test="${reviewArr ne null and not empty reviewArr}">
					<c:forEach var="review" items="${reviewArr}">
						<tr onclick="goCheck('${review.re_num}')">
							<td>${review.re_name}</td>
							<td>${review.u_id}</td>
							<td>${review.re_date}</td>
							<td>${review.re_readnum}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${loginUser.u_id ne null }">
				<tr>
					<td colspan="4">
						<button type="button" class="btn btn-success"
							onclick="goList('${loginUser.u_id}')">작성한 리뷰보기</button> 
							<button type="button" class="btn btn-warning"
							onclick="goInsert('${loginUser.u_id }')">방명록작성</button>
					</td>
				</tr>
				</c:if>
				<tr>
					<td colspan="4" style="text-align: center;">
						<!-- pageNavigation  
					begin : 시작값 지정
					end : 끝값 지정
					step : 증가치
					-->
						<ul class="pagination">
							<c:forEach var="i" begin="1" end="${pageCount }" step="1">
								<li <c:if test="${cpage eq i }">class="active"</c:if>><a
									href="review.do?cpage=${i }">${i }</a></li>
							</c:forEach>
						</ul> <!-- pageNavigation  -->
					</td>
				</tr>
			</table>
		</div>
		<!--------------------------------------------------------------------------------------------------------->
	</div>
</div>
<form name="f">
	<input type="hidden" name="re_num">
	<input type="hidden" name="u_id">
</form>
<form name="l">
	<input type="hidden" name="u_id">
	<input type="hidden" name="loc_num" value="${param.loc_num}">
</form>
<form name="i">
	<input type="hidden" name="loc_num" value="${param.loc_num}">
	<input type="hidden" name="u_id">
</form>
<script>
	function goCheck(re_num) {
		/* alert(re_num); */
		f.re_num.value = re_num;
		f.action = "reviewCheck.do";
		f.method = "post";
		f.submit();
	}
	function goList(u_id) {
		l.u_id.value = u_id;
		l.action = "reviewList.do";
		l.method = "post";
		l.submit();
	}
	function goInsert(u_id) {
		i.u_id.value = u_id;
		i.action = "reviewInsert.do";
		i.method = "post";
		i.submit();
	}
</script>
<jsp:include page="/foot.jsp" />