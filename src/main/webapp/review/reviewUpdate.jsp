<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="loc" value="${location} }" scope="session" />
<jsp:include page="/top.jsp"/>
<script>
	function Updatecheck() {
		if(!boardF.reviewtitle.value){
			alert('제목을 입력해주세요');
			boardF.reviewtitle.focus();
			return;
		}
		if(!boardF.reviewcontent.value){
			alert('글내용을 입력해주세요');
			boardF.reviewcontent.focus();
			return;
		}
		boardF.submit();
	}
	function rList(u_id,loc_num) {
		rlf.u_id.value = u_id;
		rlf.loc_num.value = loc_num;
		rlf.action = "reviewList.do";
		rlf.method = "post";
		rlf.submit();
	}
</script>
<div id="content">
	<div class="row">
		<div style="max-width: 900px;margin: 0 auto">
			<form name="boardF" action="reviewUpdateEnd.do" method="post">
				<c:if test="${updateArr ne null and not empty updateArr}">
				<table class="table">
						<tr>
							<td>제목</td>
							<td>
								<input type="text" name="reviewtitle"  maxlength="50"
								class="form-control" placeholder="ReviewTitle"
								value="${updateArr.re_name }">
							</td>
						</tr>
						<tr>
							<td>글내용</td>
							<td>
								<textarea rows="20" cols="60" style="resize: none;" maxlength="2000"
								name="reviewcontent" class="form-control" placeholder="ReviewContent">${updateArr.re_content }</textarea>
							</td>
						</tr>
					<tr>
						<td colspan="2">
							<button type="button" class="btn btn-success" onclick="rList('${updateArr.u_id }','${updateArr.loc_num }')">뒤로가기</button>
							<button type="button" class="btn btn-success" onclick="return Updatecheck()">수정하기</button>
							<button type="reset" class="btn btn-warning">다시쓰기</button>
						</td>
					</tr>
					
				</table>
				<input type="hidden" name="re_num" value="${updateArr.re_num }">
				<input type="hidden" name="u_id" value="${updateArr.u_id }">
				<input type="hidden" name="loc_num" value="${updateArr.loc_num }">
				</c:if>
			</form>
		</div>
	</div>
</div>
<form name="rlf">
	<input type="hidden" name="u_id">
	<input type="hidden" name="loc_num">
</form>
<jsp:include page="/foot.jsp" />