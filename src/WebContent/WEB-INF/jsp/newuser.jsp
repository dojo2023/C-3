<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>ぺトコレ｜新規登録</title>
</head>
<body>
	<h1>ユーザー新規登録</h1>
	<form id="userregister_form" method="POST" action="/coffee_Milk/NewUserServlet">
	<table>
	<tr>
		<td>
		<label>ID<br>
        <input type="text" name="ID">
        </label>
		</td>
		<td>
        <label>パスワード<br>
        <input type="password" name="PW">
        </label>
		</td>
	</tr>
	<tr>
      <td colspan="2">
		 <input type="submit" name="REGIST" value="登録">
         <input type="reset" name="reset" value="リセット">
         <span id="error_message"></span>
       </td>
	</tr>
	</table>
	</form>

</body>
</html>