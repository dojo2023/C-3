package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Message;
import dao.MessagesDAO;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // チャットルームのIDを取得
        int roomId;
        String roomIdParam = request.getParameter("roomid"); // roomIdParamの値を取得

        if (roomIdParam != null && !roomIdParam.isEmpty())
        {
            roomId = Integer.parseInt(roomIdParam);
        }
        else
        {
            roomId = 1; // デフォルト値
        }

        // MessagesDAOを使用してメッセージを取得
        MessagesDAO messagesDAO = new MessagesDAO();
        List<Message> messageList = null;
        try
        {
            messageList = messagesDAO.selectByRoomId(roomId);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        // リクエスト属性にメッセージリストを設定
        request.setAttribute("messageList", messageList);
        request.setAttribute("roomId", roomId);

        // message.jspにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/message.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // フォームから送信されたメッセージを取得
        String messageContent = request.getParameter("message");
        String nickname = request.getParameter("nickname");

        //ニックネームが空の場合
        if(nickname == null || nickname.isEmpty())
        {
        	nickname = "ゲスト";
        }

        // チャットルームのIDを取得
        int roomId = 1;

        // メッセージオブジェクトを作成
        Message message = new Message();
        message.setChatroomsid(String.valueOf(roomId)); // チャットルームIDを設定(integerオブジェクトに変換)
        message.setMessage(messageContent); // メッセージを設定
        message.setNickname(nickname);

        // MessagesDAOを使用してメッセージをデータベースに挿入
        MessagesDAO messagesDAO = new MessagesDAO();
        boolean result = messagesDAO.insert(message);

        // メッセージの挿入結果に応じて処理を行う（必要に応じて実装）
        if (result)
        {
            // メッセージの挿入に成功した場合の処理

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/chat.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            // メッセージの挿入に失敗した場合の処理
        }

        // doGetメソッドを呼び出してメッセージ一覧を表示
        doGet(request, response);
    }
}