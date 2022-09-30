<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp" />
<div class="container">
   <div class="row">
      <div class="col-xs-3">
         <h2 style="white-space: nowrap;">회원가입</h2>
      </div>
   </div>

   <div id="content2" style="align-items: center;">
      <hr style="width: 90%; margin: auto; color: #fabb51">
      <br>
      <form name="mf" action="joinEnd.do" method="post">
            <table class="tab"
               style="border-collapse: collapse; border: 1px #fabb51 solid; width: 60%; margin: 0 auto;">
               <tr style="margin-top:15px;">
                  <td class="t1" style="vertical-align: middle"><b>이 름</b></td>
                  <td class="t2"><input type="text" name="name"
                     style="width: 90%; border: 1px solid #c9c9c9;margin-top:15px;" placeholder="이름을 입력하세요." class="box"
                     required="required"></td>
               </tr>
               <tr>
                  <td class="t1" style="vertical-align: middle"><b>아이디</b></td>
                  <td class="t2" id="ch">
                     <div style="display: flex; white-space: nowrap; width: 91%;">
                        <input type="text" name="userid" placeholder="사용할 아이디를 입력하세요."
                           class="box" required="required" readonly
                           style="margin: 5px 0 5px 8px; width: 70%;border: 1px solid #c9c9c9;">
                        <button type="button" class="btn"
                           style="width: 30%; float: left; margin: 5px 0; padding: 5px 5px; background: green; color: white;"
                           onclick="openWin()">중복체크</button>
                     </div>
                  </td>
               </tr>
               <tr>
                  <td class="t1" style="vertical-align: middle"><b>비밀번호</b></td>
                  <td class="t2"><input type="password" name="pwd"
                     style="width: 90%;border: 1px solid #c9c9c9;" placeholder="사용할 비밀번호를 입력하세요." class="box"></td>
               </tr>
               <tr>
                  <td class="t1" style="vertical-align: middle"><b>비밀번호 확인</b></td>
                  <td class="t2"><input type="password" name="pwd2"
                     style="width: 90%;border: 1px solid #c9c9c9;" placeholder="한 번 더 입력하세요." class="box"
                     required="required"></td>
               </tr>
               <tr>
                  <td class="t1" style="vertical-align: middle"><b>연락처</b></td>
                  <td class="t2"><input type="text" name="phone" required
                     style="width: 90%;border: 1px solid #c9c9c9;" maxlength="11" placeholder="전화번호를 입력하세요."
                     class="box"></td>
               </tr>
               <tr>
                  <td class="t1" style="vertical-align: middle"><b>이메일</b></td>
                  <td class="t2"><input type="text" name="email"
                     style="width: 90%;border: 1px solid #c9c9c9;" placeholder="이메일을 입력하세요." class="box"></td>
               </tr>
               <tr>

                  <td class="t1" style="vertical-align: middle"><b>거주지</b></td>
                  <td class="t2"><select name="loc" class="box"
                     style="width: 90%;border: 1px solid #c9c9c9;">
                        <option disabled selected>지역선택</option>
                        <option value="서울">서울</option>
                        <option value="경기">경기도</option>
                        <option value="강원">강원도</option>
                        <option value="충북">충청북도</option>
                        <option value="충남">충청남도</option>
                        <option value="전북">전라북도</option>
                        <option value="전남">전라남도</option>
                        <option value="경북">경상북도</option>
                        <option value="경남">경상남도</option>
                        <option value="제주">제주특별자치도</option>
                  </select>
               </tr>

               <tr>
                  <td colspan="2" style="text-align: center; padding: 15px 0;">
                     <button type="button" onclick="Check()" class="btn"
                        style="width: 30%; max-width: 140px; margin: 0 15px;">회원가입</button>
                     <button type="reset" class="btn"
                        style="width: 30%; max-width: 140px; margin: 0 15px;">다시쓰기</button>
                  </td>
               </tr>
            </table>
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
      if (!mf.name.value) {
         alert('이름을 입력하세요');
         mf.name.focus();
         return;
      }
      if (!mf.userid.value) {
         alert('아이디를 입력하세요');
         mf.userid.focus();
         return;
      }
      if (!mf.pwd.value) {
         alert('비밀번호를 입력하세요');
         mf.pwd.focus();
         return;
      }
      if (mf.pwd.value != mf.pwd2.value) {
         alert('비밀번호가 다릅니다.');
         mf.pwd2.select();
         return;
      }
      if (!mf.phone.value) {
         alert('전화번호를 입력하세요');
         mf.phone.focus();
         return;
      }

      if (!mf.email.value) {
         alert('이메일을 입력하세요');
         mf.addr1.focus();
         return;
      }

      if (!mf.loc.value) {
         alert('거주지를 입력하세요');
         mf.addr1.focus();
         return;
      }
      mf.submit(); // 서버에 전송
   }
</script>

<jsp:include page="/foot.jsp" />