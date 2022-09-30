<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/top.jsp" />
<div class="container">
	<div class="row">
		<div class="col-xs-3">
			<h2 style="white-space: nowrap;">회원정보수정</h2>
		</div>
	</div>
	<div id="content2" style="align-items: center;">
		<hr style="width: 90%; margin: auto; color: #fabb51">
		<br>
		<form name="mf" action="editEnd.do" method="post">
				<table class="tab"
					style="border-collapse: collapse; border: 1px #fabb51 solid; width: 60%; margin: 0 auto;">
					<tr>
						<td class="t1" style="vertical-align: middle"><b>이 름</b></td>
						<td class="t2"><input type="text" name="u_name" value="${Editarr.u_name }"
							style="width: 90%;border: 1px solid #c9c9c9;margin-top:15px;" placeholder="기존 이름" class="box"
							required="required"></td>
					</tr>
					<tr>
						<td class="t1" style="vertical-align: middle"><b>아이디</b></td>
						<td class="t2" id="ch">
								<input type="text" name="u_id" placeholder="기존아이디" value="${Editarr.u_id }"
									class="box" required="required" readonly
									style="margin: 5px 0 5px 8px; width: 90%;border: 1px solid #c9c9c9; background-color:#e7e7e7;">
						</td>
					</tr>
					<tr>
						<td class="t1" style="vertical-align: middle"><b>비밀번호</b></td>
						<td class="t2"><input type="password" name="u_pwd" value="${Editarr.u_pwd }"
							style="width: 90%;border: 1px solid #c9c9c9;" placeholder="기존비번" class="box"></td>
					</tr>
					<tr>
						<td class="t1" style="vertical-align: middle"><b>비밀번호 확인</b></td>
						<td class="t2"><input type="password" name="pwd2" value="${Editarr.u_pwd }"
							style="width: 90%;border: 1px solid #c9c9c9;" placeholder="한 번 더 입력하세요." class="box"
							required="required"></td>
					</tr>
					<tr>
						<td class="t1" style="vertical-align: middle"><b>연락처</b></td>
						<td class="t2"><input type="text" name="u_phone" required value="${Editarr.u_phone }"
							style="width: 90%;border: 1px solid #c9c9c9;" maxlength="11" placeholder="기존전화번호"
							class="box"></td>
					</tr>
					<tr>
						<td class="t1" style="vertical-align: middle"><b>이메일</b></td>
						<td class="t2"><input type="text" name="u_mail" value="${Editarr.u_mail }"
							style="width: 90%;border: 1px solid #c9c9c9;" placeholder="기존이메일" class="box"></td>
					</tr>
					<tr>

						<td class="t1" style="vertical-align: middle"><b>거주지</b></td>
						
						<td class="t2"><select name="u_loc" class="box"
							style="width: 90%;border: 1px solid #c9c9c9;">
								<option value="">지역선택</option>
								<option value="서울" <c:if test="${Editarr.u_loc=='서울'}">selected</c:if>>서울</option>
								<option value="경기" <c:if test="${Editarr.u_loc=='경기'}">selected</c:if>>경기도</option>
								<option value="강원" <c:if test="${Editarr.u_loc=='강원'}">selected</c:if>>강원도</option>
								<option value="충북" <c:if test="${Editarr.u_loc=='충북'}">selected</c:if>>충청북도</option>
								<option value="충남" <c:if test="${Editarr.u_loc=='충남'}">selected</c:if>>충청남도</option>
								<option value="전북" <c:if test="${Editarr.u_loc=='전북'}">selected</c:if>>전라북도</option>
								<option value="전남" <c:if test="${Editarr.u_loc=='전남'}">selected</c:if>>전라남도</option>
								<option value="경북" <c:if test="${Editarr.u_loc=='경북'}">selected</c:if>>경상북도</option>
								<option value="경남" <c:if test="${Editarr.u_loc=='경남'}">selected</c:if>>경상남도</option>
								<option value="제주" <c:if test="${Editarr.u_loc=='제주'}">selected</c:if>>제주특별자치도</option>
						</select>
					</tr>

					<tr>
						<td colspan="2" style="text-align: center; padding: 15px 0;">
							<button type="button" onclick="Check()" class="btn"
								style="width: 30%; max-width: 140px; margin: 0 15px;">수&nbsp;&nbsp;정</button>
							<button type="reset" class="btn"
								style="width: 30%; max-width: 140px; margin: 0 15px;">다시쓰기</button>
						</td>
					</tr>
				</table>
				<input type="hidden" name="u_idx" value="${Editarr.u_idx}">
			</form>
	</div>
</div>
<script>
	let win;
	function openWin() {
		win = open("idCheck.do", "idCheck",
				"width=400, height=400, left=100,top=100");
	}//------------------------

	function Check() {
		if (!mf.u_name.value) {
			alert('이름을 입력하세요');
			mf.u_name.focus();
			return;
		}
		if (!mf.u_id.value) {
			alert('아이디를 입력하세요');
			mf.u_id.focus();
			return;
		}
		if (!mf.u_pwd.value) {
			alert('비밀번호를 입력하세요');
			mf.u_pwd.focus();
			return;
		}
		if (mf.u_pwd.value != mf.pwd2.value) {
			alert('비밀번호가 다릅니다.');
			mf.pwd2.select();
			return;
		}
		if (!mf.u_phone.value) {
			alert('전화번호를 입력하세요');
			mf.u_phone.focus();
			return;
		}

		if (!mf.u_mail.value) {
			alert('이메일을 입력하세요');
			mf.addr1.focus();
			return;
		}

		if (!mf.u_loc.value) {
			alert('거주지를 입력하세요');
			mf.addr1.focus();
			return;
		}
		mf.submit(); // 서버에 전송
	}
</script>

<jsp:include page="/foot.jsp" />