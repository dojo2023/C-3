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
	<h1>ログインページです。</h1>
	<main>

	<div class="wrapper"> <!--ログインページのメニューを管理するクラス名-->
    <!--メイン-->
<!--  <img src="/coffee_Milk/img/logo.png" width="160" height="70"  alt="名刺管理">-->

    <h2>ログイン</h2>

  <form id="login_form" method="POST" action="/coffee_Milk/LoginServlet">
    <table id ="button">
        <tr>
            <td>
                <label>
                    ユーザーID:
                        <input type="text" name="USER_ID" required="required"> <!--requiredを入れることで入力すべきフィールドが空であれば警告を表示させる。-->
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <label>
                    パスワード:
                        <input type="password" name="USER_PW" required="required"> <!--requiredを入れることで入力すべきフィールドが空であれば警告を表示させる。-->
                </label>
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" name="LOGIN" value="ログイン" class ="button">
                <input type="reset" name="reset" value="リセット" class ="button">
            </td>
        </tr>
    </table>
 </form>
<div>アカウントを持っていない方は<a href = "/coffee_Milk/NewUserServlet">こちら</a></div>

	<a href="/coffee_Milk/MenuServlet">メニューへ戻る</a>

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

