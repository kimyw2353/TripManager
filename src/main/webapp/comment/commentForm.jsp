<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="content">
	<div class="row">
		<div style="max-width: 900px; margin: 0 auto">
			<form name="cmtF" action="../comment/commentEnd.do" method="post">
				<!-- hidden field (작성자, 부모글번호) -------------- -->
				<input type="hidden" name="u_id" value="${loginUser.u_id}">
				<input type="hidden" name="re_num" value="${review.re_num}">
				<!-- -------------------------------------------- -->
				<table class="table">
					<tr>
						<td style="text-align: center; width: 10%; margin-top: 10px;">
							<span class="label label-warning" style="font-size: 1.3rem;">${loginUser.u_id}</span>
						</td>
						<td style="width: 80%">
							<textarea name="com_content" rows="1" maxlength="200"
							placeholder="로그인해야 이용 가능해요" style="resize: none;"
							<c:if test="${loginUser eq null}">disabled</c:if>
							class="form-control"></textarea>
						</td>
						<td style="width: 10%;">
							<button class="btn btn-info">댓글쓰기</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>