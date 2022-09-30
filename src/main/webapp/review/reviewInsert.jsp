<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/top.jsp"/>
<script>
	function check(loc_num,u_id) {
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
		boardF.loc_num.value=loc_num;
		boardF.u_id.value=u_id;
		boardF.submit();
	}
</script>
<div id="content">
	<div class="row">
		<div style="max-width: 900px;margin: 0 auto">
			<form name="boardF" action="reviewInsertEnd.do" method="post">
				<table class="table">
					<tr>
						<td>제목</td>
						<td>
							<input type="text" name="reviewtitle" maxlength="50"
							class="form-control" placeholder="ReviewTitle">
						</td>
					</tr>
					<tr>
						<td>글내용</td>
						<td>
							<textarea rows="20" cols="60" style="resize: none;" maxlength="2000"
							name="reviewcontent" class="form-control" placeholder="ReviewContent"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="button" class="btn btn-success" onclick="location.href='review.do?loc_num=${loc_num}'">뒤로가기</button>
							<button type="button" class="btn btn-success" onclick="check('${loc_num}','${u_id}')">글쓰기</button>
							<button type="reset" class="btn btn-warning">다시쓰기</button>
						</td>
					</tr>
				</table>
				<input name="loc_num" type="hidden">
				<input name="u_id" type="hidden">
			</form>
		</div>
	</div>
</div>

<jsp:include page="/foot.jsp" />