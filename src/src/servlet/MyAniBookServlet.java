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
		HttpSession session = request.getSession();
		//Myペット図鑑から遷移
		if( request.getParameter("pbi") == null) {
			System.out.println("myペット図鑑から遷移");

			//	ログインしている人		pet_button = true

			if (session.getAttribute("id") != null) {
				System.out.println("ログインしている人-myペット図鑑から");

				// pet_button = true を与える
				boolean pet_button = true;

				// pet_buttonを格納する
				request.setAttribute("pet_button", pet_button);

				//  セッションスコープからIDを取得する
				LoginUsers login_users = (LoginUsers) session.getAttribute("id");

				// IDを使ってMyペット図鑑の情報をゲットする
				PictureBooksDAO aDao = new PictureBooksDAO();
				List<Pets> petsList = aDao.select(new Pets(login_users.getId()));

				// ペット図鑑のIDを使って、IDに合う投稿リストをゲットする
				for( Pets pet: petsList) {
					PetPostsDAO bDao = new PetPostsDAO();
					List<Pet> postList = bDao.select(Integer.parseInt(pet.getId()));

					// modelのPetsにPostのリストを格納する
					pet.setPost(postList);
				}

				// petsList(Myペット図鑑のデータと投稿のデータ)をリクエストスコープに格納する
				request.setAttribute("petsList", petsList);
			}

			// ログインしていない人	pet_button = false
			if (session.getAttribute("id") == null) {
				System.out.println("ログインしていない人-myペット図鑑から");

				// pet_button = false を与える
				boolean pet_button = false;

				// pet_buttonを格納する
				request.setAttribute("pet_button", pet_button);
			}
		}
		//ペット投稿一覧から遷移
		if( request.getParameter("pbi") != null) {
			System.out.println("ペット投稿一覧から");
			//ログインの有無に関わらず共通のプログラム
			// pbiを取得し、int型に変換する
			int pbi1 = Integer.parseInt(request.getParameter("pbi"));

			// pbiからUSER_IDを得る
			PictureBooksDAO aDao = new PictureBooksDAO();
			Pets pets = aDao.editselect(pbi1);

			// USER_IDを使ってMyペット図鑑の情報をゲットする
			PictureBooksDAO bDao = new PictureBooksDAO();
			List<Pets> petsList = bDao.select(new Pets(pets.getUser_id()));

			// ペット図鑑のIDを使って、IDに合う投稿リストをゲットする
			for( Pets pet: petsList) {
				PetPostsDAO cDao = new PetPostsDAO();
				List<Pet> postList = cDao.select(Integer.parseInt(pet.getId()));

				// modelのPetsにPostのリストを格納する
				pet.setPost(postList);
			}

			// petsList(Myペット図鑑のデータと投稿のデータ)をリクエストスコープに格納する
			request.setAttribute("petsList", petsList);

			// pbiをリクエストスコープに格納する
			request.setAttribute("pbi",request.getParameter("pbi"));

            // ログインしている人
			if (session.getAttribute("id") != null) {

				System.out.println("ログインしている人-ペット投稿一覧");
				System.out.println(pets.getUser_id());
				System.out.println(((LoginUsers) session.getAttribute("id")).getId());
				// ペットの所有者かどうか判定する
				if(pets.getUser_id().equals(((LoginUsers) session.getAttribute("id")).getId())) {
					System.out.println("ペットの所有者-ペット投稿一覧");

					// ペットの所有者 pet_button = true を与える
					boolean pet_button = true;

					// pet_buttonを格納する
					request.setAttribute("pet_button", pet_button);
				}
			}
			// ログインしていない人
			if (session.getAttribute("id") == null) {
				System.out.println("ログインしていない人-ペット投稿一覧");
				// ペットの非所有者 pet_button = false を与える
				boolean pet_button = false;

				// pet_buttonを格納する
				request.setAttribute("pet_button", pet_button);

			}


		}

		//フォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myanibook.jsp");
		dispatcher.forward(request, response);
		return;
	}

/*

		// 閲覧者でない場合
		if( request.getParameter("pbi") == null) {


			// pbiを””でリクエストスコープに格納する
			String pbi = "";
			request.setAttribute(pbi, pbi);


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
			return;
		}

		// 閲覧者の場合
		else {

			// 非ログイン者の場合はMyペット図鑑の情報をゲット
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {

				// pbiを取得し、String型でリクエストスコープに格納する
				String pbi = request.getParameter("pbi");
				request.setAttribute("pbi", pbi);

				// pbiを取得し、int型に変換する
				int pbi1 = Integer.parseInt(pbi);

				// pbiからUSER_IDを得る
				PictureBooksDAO aDao = new PictureBooksDAO();
				Pets pets = aDao.editselect(pbi1);

				// USER_IDからMyペット図鑑の情報をゲットする
				PictureBooksDAO bDao = new PictureBooksDAO();
				List<Pets> petsList = bDao.select(new Pets(pets.getUser_id()));

				// petsListのIDを使って、IDに合う投稿リストをゲットする
				for( Pets pet: petsList) {
					PetPostsDAO cDao = new PetPostsDAO();
					List<Pet> postList = cDao.select(Integer.parseInt(pet.getId()));

					// modelのPetsにPostのリストを格納する
					pet.setPost(postList);
				}
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("petsList", petsList);

				// Myペット図鑑にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myanibook.jsp");
				dispatcher.forward(request, response);
				return;
			}
			// ログイン者の場合
			else {

				// pbiを取得し、String型でリクエストスコープに格納する
				String pbi = request.getParameter("pbi");
				request.setAttribute("pbi", pbi);

				// pbiをint型に変換する
				int pbi1 = Integer.parseInt(pbi);

				// pbiからUSER_IDを得る
				PictureBooksDAO aDao = new PictureBooksDAO();
				Pets pets = aDao.editselect(pbi1);

				// USER_IDをpbi_idとしてリクエストスコープに格納する
				request.setAttribute("pbi_id", pets.getUser_id());

				// DAOを使ってMyペット図鑑の情報をゲットする
				PictureBooksDAO bDao = new PictureBooksDAO();
				List<Pets> petsList = bDao.select(new Pets(pets.getUser_id()));

				// petsListのIDを使って、IDに合う投稿リストをゲットする
				for( Pets pet: petsList) {
					PetPostsDAO cDao = new PetPostsDAO();
					List<Pet> postList = cDao.select(Integer.parseInt(pet.getId()));

					// modelのPetsにPostのリストを格納する
					pet.setPost(postList);
				}
				// 検索結果をリクエストスコープに格納する
				request.setAttribute("petsList", petsList);

				// ログイン者の場合はセッションスコープからIDを取得する
				HttpSession session1 = request.getSession();
				LoginUsers login_users = (LoginUsers) session1.getAttribute("id");

				// idをリクエストスコープに格納する？？
				request.setAttribute("id", login_users);


				// Myペット図鑑にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myanibook.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
