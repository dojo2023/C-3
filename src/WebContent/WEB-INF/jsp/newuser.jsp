<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>ぺトコレ｜新規登録</title>

<!-- スタイルシートの挿入 -->
<link rel="stylesheet" href="/coffee_Milk/css/newuser.css">

</head>
<body>
<%@ include file="header.jsp" %>
	<div class="wrapper">
	<h1>ユーザー新規登録</h1>
	<form id="userregister_form" method="POST" action="/coffee_Milk/NewUserServlet">
	<table>
	<tr>
		<td id="newid">
			<label>ID　　　　
        		<input type="text" name="ID"><br>
			</label>
		</td>
	</tr>
	<tr>
		<td id="newpw">
        	<label>パスワード
				<input type="password" name="PW">
			</label>
		</td>
	</tr>
	<tr id="bottan">
		<td colspan="2">
			<input type="submit" name="REGIST" value="登録">
        	<input type="reset" name="reset" value="リセット">
			<p id="output"></p>
        	<span id="error_message"></span>
		</td>
	</tr>
	</table>
		<a href="/coffee_Milk/MenuServlet">メインメニューへ戻る</a><br>
	</form>
	</div>
	 <%-- エラーメッセージの表示 --%>
 <c:if test="${not empty error}">
    <p>${error}</p>
 </c:if>


	<!-- Javascriptの挿入 -->
	<script src="/coffee_Milk/js/newuser.js"></script>

</body>
</html>