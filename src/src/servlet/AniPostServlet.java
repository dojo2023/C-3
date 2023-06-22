package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PetPostsDAO;
import model.Pet;

/**
 * Servlet implementation class AniPostServlet
 */
@WebServlet("/AniPostServlet")
public class AniPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// ペット投稿にフォワードする
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメーターを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");

		// リクエストパラメーターに格納する
		request.setAttribute("ID",id);

		// ペット投稿ページへフォワードする！
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/anipost.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("ID");
			String title = request.getParameter("TITLE");
			String genre = request.getParameter("GENRE");
			String free = request.getParameter("FREE");
			String picture = request.getParameter("PICTURE");

			// 登録処理を行う
			PetPostsDAO aDAO = new PetPostsDAO();
			if (aDAO.insert(new Pet(id, title, genre, free, picture))) {	// 登録成功
				response.sendRedirect("/coffee_Milk/MyAniBookServlet");
			}
			else {												// 登録失敗
		        String error = "※登録失敗しました。";
	            request.setAttribute("error", error);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/anipost.jsp");
				dispatcher.forward(request, response);
			}
	}

}
