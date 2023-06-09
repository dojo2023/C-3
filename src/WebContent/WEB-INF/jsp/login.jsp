<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ペトコレ|ログイン</title>
	<link rel="stylesheet" href="/coffee_Milk/css/login.css">
	<script src="/coffee_Milk/js/login.js"></script>
</head>
<body>
<div class="wrapper">
	<%@ include file="header.jsp" %>
	<main>
	<div class="wrapper"> <!--ログインページのメニューを管理するクラス名-->
    <h1>ログイン</h>
  <form id="login_form" method="POST" action="/coffee_Milk/LoginServlet">
    <table id ="button">
        <tr>
            <td>
                <label>
                    <div class="ID">ID
                        <input type="text" name="USER_ID" required="required" style="width: 200px; height: 30px; background:#FFFFEF"> <!--requiredを入れることで入力すべきフィールドが空であれば警告を表示させる。-->
					</div>
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <label>
                    <div class="PASS">パスワード
                        <input type="password" name="USER_PW" required="required" style="width: 200px; height: 30px; background:#FFFFEF"> <!--requiredを入れることで入力すべきフィールドが空であれば警告を表示させる。-->
					</div>
                </label>
            </td>
        </tr>

        <tr>
            <td>
            	<div class ="button">
                <input type="submit" name="LOGIN" value="ログイン" class ="login">
                <input type="reset" name="reset" value="リセット" class ="reset">
				</div>
            </td>
        </tr>
    </table>
 </form>
<div class="menu">
アカウントを持っていない方は<a href = "/coffee_Milk/NewUserServlet">こちら</a><br>

	<a href="/coffee_Milk/MenuServlet">メニューへ戻る</a>
</div>

 <%-- エラーメッセージの表示 --%>
 <c:if test="${not empty error}">
    <p>${error}</p>
 </c:if>

 </div>
	</main>

	<!--footer ここから-->
	<div id="footer">
	</div>
	<!--footer ここまで-->
</div>
</body>
</html>

