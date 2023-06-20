package servlet;

import java.io.IOException;

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
 * Servlet implementation class MyAniAddServlet
 */
@WebServlet("/MyAniAddServlet")
public class MyAniAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// もしもログインしていなかったらログインサーブレットにリダイレクトする。
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/coffee_Milk/LoginServlet");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//  セッションスコープからIDを取得する
		HttpSession session1 = request.getSession();
		LoginUsers login_users = (LoginUsers) session1.getAttribute("id");


		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("NAME");
		String sex = request.getParameter("SEX");
		String birthday = request.getParameter("BIRTHDAY");
		String appeal = request.getParameter("APPEAL");
		String cry = request.getParameter("CRY");
		String picture = request.getParameter("PICTURE");

		// 登録処理を行う
		PictureBooksDAO pbDao = new PictureBooksDAO();
		if (pbDao.insert(new Pets(login_users.getId(), name, sex, birthday, appeal, cry, picture))) {	// 登録成功
			response.sendRedirect("/coffee_Milk/MyAniBookServlet");
		}
		else {												// 登録失敗
	        String error = "※登録失敗しました。";
            request.setAttribute("error", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myaniadd.jsp");
			dispatcher.forward(request, response);
		}
	}
}
