<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/top.jsp" />
<c:set var="myctx" value="${pageContext.request.contextPath}"
	scope="session" />
<div id="content">
	<div class="row">
		<div style="max-width: 900px; margin: 0 auto;">
			<table class="table">
				<c:if test="${review ne null and not empty review}">
					<tr>
						<td colspan="2" style="display: flex;"><span
							style="width: 60px; margin-top: 8px; font-weight: 600;">제목</span>
							<input type="text" name="reviewtitle"
							style="background-color: #fffbf0;" class="form-control"
							placeholder="ReviewTitle" readonly value="${review.re_name}">
						</td>
					</tr>
					<tr>
						<td colspan="2" style="display: flex;"><span
							style="width: 60px; margin-top: 8px; font-weight: 600;">내용</span>
							<textarea rows="10" cols="60" style="background-color: #fffbf0;resize:none;"
								name="reviewcontent" class="form-control"
								placeholder="ReviewContent" readonly style="resize: none;">${review.re_content}</textarea>
						</td>
					</tr>
				</c:if>
				
			</table>
		</div>
	</div>
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<jsp:include page="/comment/commentForm.jsp" />
		</div>
	</div>
	<!-- 댓글 목록 가져오기 ------------------------->
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<jsp:include page="/comment/commentList.jsp" />
		</div>
	</div>
	<button class="btn btn-success"
		onclick="location.href='review.do?loc_num=${review.loc_num}'">뒤로가기</button>
</div>

<jsp:include page="/foot.jsp" />