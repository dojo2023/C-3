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
	//編集ボタンが押されたときには、myaniupdate.jspへフォワード
	//削除ボタンが押されたときには、result.jspへフォワード
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println(request.getParameter("cmd"));

	//変数を宣言する
String cmd = request.getParameter("cmd");

	if(cmd.equals("1")) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myaniupdate.jsp");
		dispatcher.forward(request, response);
	}else {
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

		//  セッションスコープからIDを取得する
			HttpSession session1 = request.getSession();
			LoginUsers login_users = (LoginUsers) session1.getAttribute("id");

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id =request.getParameter("id");
		String name =request.getParameter("name");
		String sex =request.getParameter("sex");
		String birthday =request.getParameter("birthday");
		String appeal  =request.getParameter("appeal");
		String cry =request.getParameter("cry");
		String picture =request.getParameter("picture");

		//更新・削除を行う
		PictureBooksDAO pDao = new PictureBooksDAO();
		if (request.getParameter("SUBMIT").equals("更新")) {
			if (pDao.update(new Pets
					(login_users.getId(),id, name, sex, birthday,appeal,cry, picture))) {	// 更新成功
				     response.sendRedirect("/coffee_Milk/MyAniBookServlet");
			}else {												// 更新失敗
		        String error = "※更新失敗しました。";
	            request.setAttribute("error", error);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myaniupdate.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			  if (pDao.delete(id)) { 				//削除成功
				  request.setAttribute("result",
							new Result("削除成功！", "Myペット図鑑を削除しました。", "/coffee_Milk/MenuServlet"));
			  }
			  else {								// 削除失敗
					request.setAttribute("result",
							new Result("削除失敗！", "Myペット図鑑を削除できませんでした。", "/coffee_Milk/MenuServlet"));
						}
					}

//					// 結果ページにフォワードする
//					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
//					dispatcher.forward(request, response);

			  }


	}
