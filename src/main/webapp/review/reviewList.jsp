<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="loc" value="${location} }" scope="session" />
<jsp:include page="/top.jsp" />
<div id="content">
	<div class="row">
		<div style="max-width: 900px; margin: 0 auto">
			<table class="table">
				<tr>
					<td>제목</td>
					<td>작성자</td>
					<td>작성한 날짜</td>
					<td>수정|삭제</td>
				</tr>
				<c:if test="${reviewListArr eq null or empty reviewListArr}">
					<tr>
						<td colspan="4"><b>작성한 리뷰가 없습니다</b></td>
					</tr>
				</c:if>
				<c:if test="${reviewListArr ne null and not empty reviewListArr}">
					<c:forEach var="reviewList" items="${reviewListArr }">
						<tr>
							<td>${reviewList.re_name}</td>
							<td>${reviewList.u_id}</td>
							<td>${reviewList.re_date}</td>
							<td><a href="#"
								onclick="reviewUpdate('${reviewList.re_num}')">수정</a> | <a
								href="#" onclick="reviewDel('${reviewList.re_num}','${loginUser.u_id }','${reviewList.loc_num}')">삭제</a></td>
						</tr>
					</c:forEach>
				</c:if>
				<tr>
					<td colspan="4">
					<c:if test="${reviewListArr ne null and not empty reviewListArr}">
						<button type="button" class="btn btn-success" 	<c:forEach var="reviewList" items="${reviewListArr }">
						<c:if test="${loginUser.u_id eq reviewList.u_id}">
									onclick="location.href='review.do?loc_num=${reviewList.loc_num}'"</c:if></c:forEach>>뒤로가기</button></c:if>
						<c:if test="${reviewListArr eq null or empty reviewListArr}">
							<button type="button" class="btn btn-success"
								onclick="javascript:history.back()">뒤로가기</button>
						</c:if>
					</td>
				</tr>

			</table>
			<form name="rf">
				<input type="hidden" name="re_num">
				<input type="hidden" name="u_id">
				<input type="hidden" name="loc_num">
			</form>
		</div>
	</div>
</div>
<script>
	function reviewDel(num, u_id,loc_num) {
		let yn = confirm('작성하신 리뷰를 삭제할까요?');
		if (!yn) return;
		rf.re_num.value = num;
		rf.u_id.value = u_id;
		rf.loc_num.value = loc_num;
		rf.action = "reviewDelete.do";
		rf.method = "post";
		rf.submit();
	}
	function reviewUpdate(num) {
		rf.re_num.value = num;
		rf.action = "reviewUpdate.do";
		rf.method = "post";
		rf.submit();
	}
</script>
<jsp:include page="/foot.jsp" />