<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp" %>
<meta charset="UTF-8">
<title>結果|ペトコレ</title>
</head>
<body>
<h1><c:out value="${result.title}"></c:out></h1>
<hr>
<p><c:out value="${result.message}" /></p>
<a href="${result.backTo}">メニューへ戻る</a>
</body>
</html>