package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Message;
import dao.MessagesDAO;
/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet
{
	MessagesDAO messagesDao = new MessagesDAO();
	String error ="";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
				//文字コーディングの指定
				request.setCharacterEncoding("UTF-8");

				//パラメーターからデータを取得
				int roomid = Integer.parseInt(request.getParameter("roomid"));

				try
				{
					List<Message> messageList = messagesDao.selectByRoomId(roomid);

					//メッセージリストをリクエストスコープに登録
					request.setAttribute("messageList",messageList);
					//メッセージルームID登録
					request.setAttribute("roomid", roomid);
				}
				catch(IllegalStateException | ClassNotFoundException | SQLException e)
				{
					error = "※DB接続エラー、メッセージの投稿は行えませんでした。";
					return;
				}
				finally
				{
					if(error ==(""))
					{
						request.getRequestDispatcher("/coffee_Milk/ChatServletServlet").forward(request,response);
					}
					else
					{
						// 登録された件数を持ってフォワード
						request.setAttribute("error", error);
						request.getRequestDispatcher("/view/error.jsp").forward(request, response);
					}
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//文字コーディング
		request.setCharacterEncoding("UTF-8");
		//パラメーターからルームID取得
		int roomid = Integer.parseInt(request.getParameter("roomid"));

		try
		{

			Message message =new Message();
			message.setMessage(request.getParameter("message"));
			//message.setRoomid(roomid);
			messagesDao.insert(message);
			//メッセージルームID登録
			request.setAttribute("roomid", roomid);

		}
		catch(IllegalStateException e)
		{
			error = "DB接続エラーの為、メッセージの投稿は行えませんでした。";
			return;

		}
		finally
		{
			// メッセージの登録を行い、画面へ遷移
			if (error == (""))
			{
				request.getRequestDispatcher("/coffee_Milk/ChatForwardServlet").forward(request, response);

			}
			else
			{
				// 登録された件数を持ってフォワード
				request.setAttribute("error", error);
				request.getRequestDispatcher("/coffee_Milk/ChatForwardServlet").forward(request, response);
			}
		}

	}

}
