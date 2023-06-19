package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PictureBooksDAO;
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
	//Myペット図鑑登録画面にフォワード
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myaniadd.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("USER_ID");
		String name = request.getParameter("NAME");
		String sex = request.getParameter("SEX");
		String birthday = request.getParameter("BIRTHDAY");
		String appeal = request.getParameter("APPEAL");
		String cry = request.getParameter("CRY");
		String picture = request.getParameter("PICTURE");

		// 登録処理を行う
		PictureBooksDAO pbDao = new PictureBooksDAO();
		if (pbDao.insert(new Pets(user_id, name, sex, birthday, appeal, cry, picture))) {	// 登録成功
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
