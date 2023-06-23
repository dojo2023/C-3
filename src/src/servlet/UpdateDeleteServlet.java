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
import model.Pets;
import model.Result;

/**
 * Servlet implementation class UpdateDeleteServlet
 */
@WebServlet("/UpdateDeleteServlet")
public class UpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//図鑑の更新・削除に関するサーブレットである

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		// リクエストパラメーターを取得する
		request.setCharacterEncoding("UTF-8");

		// アプデかデリトか識別するcmdを取得
		String cmd = request.getParameter("cmd");

		//編集ボタンが押されたときには、myaniupdate.jspへフォワード
		if(cmd.equals("1")) {

			// 編集のためのidを取得する(int型)。
			int id1 = Integer.parseInt(request.getParameter("id1"));

			// DAOを使ってペット図鑑の情報をゲットする
			PictureBooksDAO aDao = new PictureBooksDAO();
			Pets pets = aDao.editselect(id1);

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("pets", pets);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myaniupdate.jsp");
			dispatcher.forward(request, response);
		}
		//削除ボタンが押されたときには、DAOを使ってペット図鑑の情報を削除し、result.jspへフォワード
		else {
			// 削除のためのidを取得する。
			String id2 = request.getParameter("id2");

			PictureBooksDAO bDao = new PictureBooksDAO();
			if(bDao.delete(id2)) {

				request.setAttribute("result",
						new Result("削除成功！", "Myペット図鑑を削除しました。", "/coffee_Milk/MyAniBookServlet"));
			}
			else {
				request.setAttribute("result",
						new Result("削除失敗！", "Myペット図鑑を削除できませんでした。", "/coffee_Milk/MyAniBookServlet"));
			}
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
		}

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//図鑑の更新・削除はログインしていないとできないので、
		//ログインしていなかったら、ログインサーブレットに飛ばす。
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/coffee_Milk/LoginServlet");
			return;
		// ↓これでidが引っ張れます！by鈴木
		//request.getParameter("id");
		}

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id =request.getParameter("ID");
		String user_id =request.getParameter("USER_ID");
		String picture =request.getParameter("PICTURE");
		String cry =request.getParameter("CRY");
		String sex  =request.getParameter("SEX");
		String birthday =request.getParameter("BIRTHDAY");
		String appeal =request.getParameter("APPEAL");
		String name =request.getParameter("NAME");

		//編集を行う
		PictureBooksDAO cDao = new PictureBooksDAO();
		if (cDao.update(new Pets(id, user_id,name,sex,birthday,appeal,cry, picture))) {	// 編集成功
			response.sendRedirect("/coffee_Milk/MyAniBookServlet");
		}
		else {												// 編集失敗
			request.setAttribute("result",
					new Result("編集失敗！", "Myペット図鑑を編集できませんでした。", "/coffee_Milk/MyAniBookServlet"));
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}
	}
}


