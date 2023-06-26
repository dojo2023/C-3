package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import model.LoginUser;
<<<<<<< Updated upstream
=======
import model.Result;
>>>>>>> Stashed changes

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< Updated upstream
		//新規登録ページにフォワードする
=======
		//新規登録のページにフォワードする
>>>>>>> Stashed changes
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newuser.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		
		// 登録処理を行う
		UsersDAO uDao = new UsersDAO();
		if (uDao.insert(new LoginUser(id,pw))) {	// 登録成功
			request.setAttribute("result",
			new Result("登録成功！", "レコードを登録しました。", "/coffee Milk/CompServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録失敗！", "レコードを登録できませんでした。", "/coffee Milk/CompServlet"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/comp.jsp");
		dispatcher.forward(request, response);


		// TODO Auto-generated method stub
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");

		// 登録処理を行う
		UsersDAO nuDao = new UsersDAO();
		if (nuDao.insert(new LoginUser(id, pw))) {	// 登録成功
			response.sendRedirect("/coffee_Milk/CompServlet");
		}
		else {												// 登録失敗
	        String error = "※入力されたユーザーIDはすでに使用されています";  //失敗の際にこれがすべて表示されるの？
            request.setAttribute("error", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newuser.jsp");
			dispatcher.forward(request, response);
		}
	}

}
