<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>ぺトコレ｜新規登録</title>

<!-- スタイルシートの挿入 -->
<link rel="stylesheet" href="/coffee_Milk/css/newuser.css">

</head>
<body>
	<div class="wrapper">
	<h1>ユーザー新規登録</h1>
	<form id="userregister_form" method="POST" action="/coffee_Milk/NewUserServlet">
	<table>
	<tr>
		<td>
			<label>ID
        		<input type="text" name="ID"><br>
			</label>
		</td>
	</tr>
	<tr>
		<td>
        	<label>パスワード
				<input type="password" name="PW">
			</label>
		</td>
	</tr>
	<tr>
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

	<!-- Javascriptの挿入 -->
	<script src="/coffee_Milk/js/newuser.js"></script>

</body>
</html>