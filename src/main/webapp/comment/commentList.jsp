<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content">
	<div class="row">
		<div style="max-width: 900px;margin: 0 auto">
			<table class="table">
				<c:forEach var="comment" items="${cmtArr}">
				<tr>
					<td style="width:20%; text-align:left;">
						<span class="label label-success">회원아이디:${comment.u_id} [${comment.com_date}]</span>
					</td>
					<td style="width:74%; text-align:left;">
						<span style="color:#c9c9c9;">|</span> ${comment.com_content}
					</td>
					<td style="width:6%;">
						<c:if test="${loginUser.u_id eq comment.u_id}">
							<div>
								<button style="width:50px; font-size:.5rem; background-color:#fffbf0;border:none;"
								onclick="comDel('${comment.com_content}')">삭제</button>
							</div>
						</c:if>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<!-- 수정 또는 삭제 form --------------------------------------------------------------------------------- -->
<form name="comDelF">
	<input type="hidden" name="com_content">	
	<input type="hidden" name="u_id" value="${loginUser.u_id }">
	<input type="hidden" name="re_num" value="${review.re_num}">
</form>
<!-- ------------------------------------------------------------------------------------------------- -->
<script>
	function comDel(com_content) {
		//alert(num);
		let yn = confirm("댓글을 정말 삭제할까요?");
		if(!yn) return;
		
		comDelF.com_content.value = com_content;
		comDelF.action="../comment/commentDelete.do";
		comDelF.method ="post";
		comDelF.submit();
	}
</script>