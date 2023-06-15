<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bean.Message"%>

<html>
<head>
<meta charset="utf-8">
<title>メッセージ</title>
</head>
<body>
<div style="width:100%;">
<%
List<Message> messageList = (List<Message>) request.getAttribute("messageList");
if (messageList != null && !messageList.isEmpty()) {
    for (Message message : messageList) { %>
        <p><%= message.getMessage() %></p>
<%  }
} %>
</div>
</body>
</html>