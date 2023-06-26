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

import dao.PetPostsDAO;
import dao.PictureBooksDAO;
import model.LoginUsers;
import model.Pet;
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

		// まずは閲覧者かどうかを判定する。
		// リクエストパラメーターを取得する
		request.setCharacterEncoding("UTF-8");

/*		// 閲覧者かどうか識別するcmdを取得
		String pbi = request.getParameter("pbi");

		// 閲覧者でない場合
		if( pbi == "" ) {*/
			// もしもログインしていなかったらそのままjspにフォワードする。
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

			// petsList1 = [ Pets(1), Pets(2), Pets(3), Pets, Pets  ]
			// pet = Pets(1)	//１週目
			// pet = Pets(2)	//２週目
			// petsListのIDを使って、IDに合う投稿リストをゲットする
			for( Pets pet: petsList) {
				PetPostsDAO bDao = new PetPostsDAO();
				List<Pet> postList = bDao.select(Integer.parseInt(pet.getId()));

				// modelのPetsにPostのリストを格納する
				pet.setPost(postList);
			}

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("petsList", petsList);

			// Myペット図鑑にフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myanibook.jsp");
			dispatcher.forward(request, response);
		}

/*		// 閲覧者の場合
		else {

			// 非ログイン者の場合はpetlistを得る
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {

			}
		}
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
