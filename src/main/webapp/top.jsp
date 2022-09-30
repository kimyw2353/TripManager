 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<c:set var="myctx" value="${pageContext.request.contextPath}" scope="session" />
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main::1박2일</title>
    <link rel="stylesheet" href="${myctx}/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
	<div id="wrap">
		<nav class="_navbar">
			<div class="navbar_content">
				<div class="navbar_logo">
					<a href="${myctx}/index.do" class="logo" title="HOME"> 1박2일여행지도 </a>
				</div>
				<ul class="navbar_links">
				<c:if test="${loginUser eq null}">
					<li><a href="${myctx}/login.do" title="로그인">로그인</a></li>
					<li>|</li>
					<li><a href="${myctx}/join.do" title="회원가입">회원가입</a></li>
				</c:if>
				<c:if test="${loginUser ne null }">
					<li><a href="${myctx}/logout.do" title="로그아웃">로그아웃</a></li>
					<li>|</li>
					<li><a href="${myctx}/edit.do" title="회원가입">회원정보 수정</a></li>
					<c:if test="${loginUser.u_id eq 'admin'}">
						<li>|</li>
						<li><a href="#" title="소개글수정/추가">소개글 수정/추가</a></li>
					</c:if>
				</c:if>
				
				</ul>
			</div>
		</nav>
		<div id="content-wrap">
			<section class="section" style="text-align: center; margin: 0 auto; width: 100%;">