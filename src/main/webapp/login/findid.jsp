<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<jsp:include page="/top.jsp" />
<div id = "content">
        
        
        <form name="findId" action="joinEnd.do" method="post">
            <table class="table" style="width:60%;margin:auto;">  
            <tr>
               <th colspan="2"><h1>아이디 찾기</h1></th>
            </tr>
            <tr>
               <td class="t1"><b>이 름</b></td>
               <td class="t2">
               <input type="text" name="name" placeholder="Name" class="box" autofocus="autofocus">
               </td>
            </tr>
            <tr>
               <td class="t1"><b>전화번호</b></td>
               <td class="t2">
               <input type="password" name="pwd" placeholder="Password" class="box">
               </td>
            </tr>
            <tr>
               <td class="t1"><b>인증번호</b></td>
               <td class="t2">
               <input type="text" name="userid"  readonly placeholder="user ID" class="box">
               <button type="button" id="atNum" class="btn" onclick="openWin()">인증번호 확인</button>
               </td>
            </tr>
           
              <tr>
                 <td colspan="4" style="text-align:center">
                    <button type="button"  onclick="check()" class="btn">아이디 찾기</button>
                 </td>
              </tr>
              
           </table>
        </form>
     </div>
     
     
<jsp:include page="/foot.jsp" />