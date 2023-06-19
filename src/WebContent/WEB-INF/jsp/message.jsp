<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="bean.Message"%>

<html>
<head>
<meta charset="UTF-8">
<title>メッセージ</title>
</head>
<body>
<div style="width:100%;">
<%
List<Message> messageList = (List<Message>) request.getAttribute("messageList");
if (messageList != null && !messageList.isEmpty())
{
    for (Message message : messageList)
    { %>
        <p><b><%= message.getNickname() %>：</b><%= message.getMessage() %> <b>投稿日時：<%= message.getTime() %></b></p>
<%  }
} %>

<!--
<%
// messageListの内容を出力
out.println("messageList: " + messageList);

if (messageList != null && !messageList.isEmpty())
{
    for (Message message : messageList)
    {
        // 各メッセージの内容を出力
        out.println("Message: " + message.getMessage());
    }
}
%>
-->
</div>
</body>
</html>