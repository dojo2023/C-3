package servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Message;
import dao.MessagesDAO;

/**
 * Servlet implementation class ChatForward
 */
@WebServlet("/ChatForward")
public class ChatForward extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		//チャットページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/chat.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
	    // リクエストパラメータからメッセージを取得する
	    String message = request.getParameter("message");
	    int roomId = Integer.parseInt(request.getParameter("roomId"));
	    String nickname = request.getParameter("nickname");


	    // Messageクラスの新しいインスタンスを作成し、メッセージの内容、ルームIDを設定する
	    Message newMessage = new Message();
	    newMessage.setMessage(message);
	    newMessage.setChatroomsid(String.valueOf(roomId));
	    newMessage.setNickname(nickname);
	    newMessage.setTime(new Timestamp(System.currentTimeMillis()));
	    // MessagesDAOを使用してメッセージをデータベースに挿入する
	    MessagesDAO messagesDAO = new MessagesDAO();
	    boolean result = messagesDAO.insert(newMessage);

	    if (result)
	    {
	        // メッセージの挿入が成功した場合はchat.jspにリダイレクトする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/chat.jsp");
			dispatcher.forward(request, response);
	    }
	    else
	    {
	        // メッセージの挿入が失敗した場合は、エラーメッセージを表示するかエラーページにリダイレクトするなど、
	        response.sendRedirect("error.jsp");
	    }
	}

}


