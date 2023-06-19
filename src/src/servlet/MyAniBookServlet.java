package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PictureBooksDAO;
import model.LoginUsers;
import model.Pets;
/**
 * Servlet implementation class MyAniBookServlet
 */
@WebServlet("/MyAniBookServlet")
public class MyAniBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myanibook.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//  セッションスコープからIDを取得する
		HttpSession session1 = request.getSession();
		LoginUsers login_users = (LoginUsers) session1.getAttribute("id");

		// DAOを使ってMyペット図鑑の情報をゲットする
		PictureBooksDAO aDao = new PictureBooksDAO();
		List<Pets> petsList = aDao.select(new Pets(login_users.getId()));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("petsList", petsList);

		// Myペット図鑑にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myanibook.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
