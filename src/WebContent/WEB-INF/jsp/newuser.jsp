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
<<<<<<< Updated upstream
<%@ include file="header.jsp" %>
	<div class="wrapper">
=======
>>>>>>> Stashed changes
	<h1>ユーザー新規登録</h1>
	<form id="userregister_form" method="POST" action="/coffee_Milk/NewUserServlet">
	<table>
	<tr>
<<<<<<< Updated upstream
		<td id="newid">
			<label>ID</label>
        		<input type="text" name="ID" style="width: 200px; height: 30px; background:#FFFFEF"><br>
		</td>
	</tr>
	<tr>
		<td id="newpw">
        	<label>パスワード</label>
				<input type="password" name="PW" style="width: 200px; height: 30px; background:#FFFFEF">
		</td>
	</tr>
	<tr id="bottan">
		<td colspan="2">
			<input type="submit" name="REGIST" value="登録"  class="regist">
        	<input type="reset" name="reset" value="リセット" class="reset">
			<p id="output"></p>
        	<span id="error_message"></span>
		</td>
	</tr>
	</table>
		<p id="menu"> <a href="/coffee_Milk/MenuServlet">メインメニューへ戻る</a></p><br>
	</form>
	</div>
	 <%-- エラーメッセージの表示 --%>
 <c:if test="${not empty error}">
    <p>${error}</p>
 </c:if>
=======
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
>>>>>>> Stashed changes

	<!-- Javascriptの挿入 -->
	<script src="/coffee_Milk/js/newuser.js"></script>
<footer>d</footer>
</body>
</html>