<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp" %>
<meta charset="UTF-8">
<title>Myペット図鑑編集</title>

<!-- スタイルシートの挿入 -->
<link rel="stylesheet" href="/coffee_Milk/css/myaniadd.css">

</head>
<body>

<h1>Myペット図鑑編集</h1>
	<form id="myaniadd_form" method="POST" action="/coffee_Milk/UpdateDeleteServlet">
		<div class="flex">
			<input type="hidden" value="${pets.id}" name="ID">
			<input type="hidden" value="${pets.user_id}" name="USER_ID">
			<p class="image">ペットの写真を載せてください<br>
				<input type="text" name="PICTURE" value="${pets.picture}"><br>
				鳴き声<br>
				<input type="text" name="CRY" value="${pets.cry}"><br>
			</p>
			<p class="main">ペットの名前<br>
				<input type="text" name="NAME" value="${pets.name}"><br>
				性別<br>
				<input type="radio" name="SEX" value="オス"
				<c:if test="${pets.sex == 'オス'}">
					checked
				</c:if>
				>オス
				<input type="radio" name="SEX" value="メス"
				<c:if test="${pets.sex == 'メス'}">
					checked
				</c:if>
				>メス
				<input type="radio" name="SEX" value="わからない"
				<c:if test="${pets.sex == 'わからない'}">
					checked
				</c:if>
				>わからない<br>
				誕生日<br>
				<input type="text" placeholder="例：0101" name="BIRTHDAY" value="${pets.birthday}"><br>
				アピールポイント<br>
				<input type="text" name="APPEAL" value="${pets.appeal}"><br>
				<input type="submit" name="REGIST" value="編集完了">
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