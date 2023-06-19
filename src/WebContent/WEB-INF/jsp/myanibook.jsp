<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Myペット図鑑</title>
		<link rel="stylesheet" href="css/myanibook.css">
		<script src="js/myanibook.js"></script>
		</head>
<body>


	<c:if test="${empty id}">
	  <p>Myペット図鑑の利用には新規登録もしくはログインが必要です。</p>
	</c:if>


	<c:if test="${!empty id}">
		<div>
	  		<h2><a href="/coffee_Milk/MyAniAddServlet"><img src="img/ペット追加ボタン.png" alt="ペット追加"></a></h2>
	    	<!-- このボタンは5匹ペットが登録されていた場合javascriptで阻止される。下にエラーメッセージ表示用のspanタグを作成 -->
	    	<span id="error_message"></span>
	    </div>

		<!--タブ-->
		<!-- ログインしていて登録データがないとき -->
		<c:if test="${empty petsList}">
			<p>登録しているデータはありません。</p>
		</c:if>
	</c:if>

	<!-- ログインしていて登録データが1つでもあるとき -->
	<div class="tab-panel">

		<!-- タブ表示 -->
		<ul class="tab-group">
			<c:forEach var="e" items="${petsList}" varStatus="status" >
				<li class="tab tab-<c:out value="${status.index+1}"/>
			  		<c:if test="${status.index==0}">
			  			is-active
			  		</c:if>
			  	">
				<c:out value="${status.index+1}"/></li>
			</c:forEach>
	 	</ul>

 		<!--タブを切り替えて表示するコンテンツ-->
		<c:forEach var="e" items="${petsList}" varStatus="status" >
 		 	<div class="panel-group">
 		 		<div class="panel tab-<c:out value="${status.index+1}"/>
 		 			<c:if test="${status.index==0}">
 		 				is-show
 		 			</c:if>
 		 		">

 		 		<!-- ページを開いたらどのようになるのか -->
 		 		<!-- <div class="panel tab-1 is-show ">  -->
 		 		<!-- <div class="panel tab-2 ">  -->

 		 			<h1>Myペットプロフィール</h1><br>
					<img src="<c:out value="${e.picture}"></c:out>">
					ペットの名前<br>
		    		<p><c:out value="${e.name}"></c:out></p>
					性別<br>
					<p><c:out value="${e.sex}"></c:out></p>
					誕生日<br>
					<p><c:out value="${e.birthday}"></c:out></p>
					鳴き声<br>
					<p><c:out value="${e.cry}"></c:out></p>
					アピールポイント<br>
					<p><c:out value="${e.appeal}"></c:out></p>
				</div>
			</div>
		</c:forEach>
	</div>
	<c:if test="${!empty id}">
		<h2><a href="/coffee_Milk/MyAniAddServlet"><img src="img/ペット編集ボタン.png" alt="編集"></a></h2>
		<h2><a href="/coffee_Milk/UpdateDeleteServlet"><img src="img/ペット削除ボタン.png" alt="削除"></a></h2>
		<h2><a href="/coffee_Milk/AniPostServlet"><img src="img/ペット投稿ボタン.png" alt="投稿"></a></h2>
	</c:if>
</body>
</html>