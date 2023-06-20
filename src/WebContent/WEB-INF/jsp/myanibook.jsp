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

<!-- case1:非ログイン状態のとき -->
	<c:if test="${empty id}">
		<!-- タブ表示のサンプル -->
		<ul class="tab-group">
				<li class="tab tab-1 is-active">1</li>
				<li class="tab tab-2 ">2</li>
				<li class="tab tab-3 ">3</li>
				<li class="tab tab-4 ">4</li>
				<li class="tab tab-5 ">5</li>
		</ul>
		<!--タブを切り替えて表示するコンテンツのサンプル-->
			<div class="panel-group">
				<div class="panel tab-1 is-show">
					Myペット図鑑機能を利用するためには”ログイン”もしくは”新規登録”してください。
				</div>
				<div class="panel tab-2">
					Myペット図鑑機能を利用するためには”ログイン”もしくは”新規登録”してください。
				</div>
				<div class="panel tab-3">
					Myペット図鑑機能を利用するためには”ログイン”もしくは”新規登録”してください。
				</div>
				<div class="panel tab-4">
					Myペット図鑑機能を利用するためには”ログイン”もしくは”新規登録”してください。
				</div>
				<div class="panel tab-5">
					Myペット図鑑機能を利用するためには”ログイン”もしくは”新規登録”してください。
				</div>
			</div>
	</c:if>

	<!-- ログインしている人のみ表示されるように設定 -->
	<c:if test="${!empty id}">
		<div>
	  		<h2><a href="/coffee_Milk/MyAniAddServlet"><img src="img/ペット追加ボタン.png" alt="ペット追加"></a></h2>
	    	<!-- このボタンは5匹ペットが登録されていた場合javascriptで阻止される。下にエラーメッセージ表示用のspanタグを作成 -->
	    	<span id="error_message"></span>
	    </div>
	</c:if>

<!-- case1:ログインしていて登録データがないとき -->
		<c:if test="${!empty id}">
		<!-- タブ表示 -->
		<c:if test="${empty petsList}">
			<ul class="tab-group">
				<li class="tab tab-1 is-active">1</li>
				<li class="tab tab-2 ">2</li>
				<li class="tab tab-3 ">3</li>
				<li class="tab tab-4 ">4</li>
				<li class="tab tab-5 ">5</li>
			</ul>

		<!--タブを切り替えて表示するコンテンツ-->
			<div class="panel-group">
				<div class="panel tab-1 is-show">
					登録されているペットはいません。
				</div>
				<div class="panel tab-2">
					登録されているペットはいません。
				</div>
				<div class="panel tab-3">
					登録されているペットはいません。
				</div>
				<div class="panel tab-4">
					登録されているペットはいません。
				</div>
				<div class="panel tab-5">
					登録されているペットはいません。
				</div>
			</div>
		</c:if>
	</c:if>

<!-- case3:ログインしていて登録データがあるとき -->
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

	<!-- ペットの登録データがある方のみ表示するボタン -->
	<c:if test="${!empty petsList}">
		<h2><a href="/coffee_Milk/MyAniAddServlet"><img src="img/ペット編集ボタン.png" alt="編集"></a></h2>
		<h2><a href="/coffee_Milk/UpdateDeleteServlet"><img src="img/ペット削除ボタン.png" alt="削除"></a></h2>
		<h2><a href="/coffee_Milk/AniPostServlet"><img src="img/ペット投稿ボタン.png" alt="投稿"></a></h2>
	</c:if>
</body>
</html>