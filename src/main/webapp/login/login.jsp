<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="/top.jsp" />


<div class="container">
	<div class="row">
      <div class="col-xs-3">
         <h2 style="white-space: nowrap;">로그인</h2>
      </div>
   </div>
</div>
 <div id="content">
           <hr style="width:80%; margin:auto;">
            <br>
      <form name="loginF" action="loginEnd.do" method="post">
         <table class="tab" style="width:60%;max-width:600px;margin:auto; border:1px #fabb51 solid; ">
           <tr>
              <td colspan="1" style="width:30%;text-align:right;">아 이 디 </td>
              <td>
                <input type="text" name="userid" value="${cookie.u_id.value}" placeholder="User ID" class="box" style="width:70%;border: 1px solid #c9c9c9; margin-top:20px;">
              </td>
           </tr>
           <tr>
              <td colspan="1" style="width:30%;text-align:right;">비밀번호</td>
              <td>
                 <input type="password" name="pwd" placeholder="Password" class="box"
                 style="width:70%;border:1px solid #c9c9c9;">
              </td>
           </tr>
            <tr>
                <td colspan="1" style="text-align:right;">
                    <label for="saveId">
                        <input type="checkbox" name="saveId" <c:if test="${cookie.u_id ne null  && not empty cookie.u_id}">checked</c:if>
                        id="saveId">아이디 저장
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="4" style="text-align:right;">
	                <a href="#">아이디 찾기</a>
	                <a>|</a>
	                <a style="margin-right:20px;">비밀번호 찾기</a>
                </td>
            </tr>
            <tr>
               <td colspan="4" style="text-align:center;">
                    <button type="button" class="btn" onclick="loginCheck()">로그인</button>
                    <button type="button" class="btn" onclick="join()">회원가입</button>
                </td>
            </tr>
         </table>
      </form>
   </div>
     <script>
        var loginCheck = function(){
           if(!loginF.userid.value){
              alert('아이디를 입력하세요');
              loginF.userid.focus();
              return;
           }
           if(!loginF.pwd.value){
              alert('비밀번호를 입력하세요');
              loginF.pwd.focus();
              return;
           }
           loginF.submit();
        }
     </script>


<jsp:include page="/foot.jsp" />