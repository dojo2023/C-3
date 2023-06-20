<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myペット図鑑登録</title>

<!-- スタイルシートの挿入 -->
<link rel="stylesheet" href="/coffee_Milk/css/myaniadd.css">

</head>
<body>

<h1>Myペット図鑑登録</h1>
<form id="myaniadd_form" method="POST" action="/coffee_Milk/MyAniAddServlet">
<div class="flex">
	<p class="image">ペットの写真を載せてください ※必須<br>
	<input type="text" name="PICTURE"><br>
		鳴き声<br>
		<input type="text" name="CRY"><br></p>
			<p class="main">ペットの名前 ※必須<br>
			<input type="text" name="NAME"><br>
			性別 ※必須<br>
			<input type="radio" name="SEX" value="1">オス
			<input type="radio" name="SEX" value="2">メス
			<input type="radio" name="SEX" value="3">わからない<br>
			誕生日 ※4桁<br>
			<input type="text" placeholder="例：0101" name="BIRTHDAY"><br>
			アピールポイント<br>
			<input type="text" name="APPEAL"><br>
			<input type="submit" name="REGIST" value="登録">
			</p>
			<p id="output"></p>
        	<span id="error_message"></span>
</div>
</form>
	<%-- エラーメッセージの表示 --%>
	<c:if test="${not empty error}">
  	  <p>${error}</p>
	</c:if>

</body>
</html>