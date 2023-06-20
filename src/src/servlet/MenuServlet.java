package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FavoritesDAO;
import model.Pet;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ペット投稿一覧
		List<Pet> petList = new ArrayList<Pet>();
		petList.add(new Pet());
		petList.add(new Pet());
		petList.add(new Pet());
		petList.add(new Pet());
		petList.add(new Pet());
		petList.add(new Pet());
		petList.add(new Pet());
		petList.add(new Pet());
		petList.add(new Pet());
		petList.add(new Pet());
		petList.add(new Pet());
		petList.add(new Pet());

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("petList", petList);


        //メニューサーブレットにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
		dispatcher.forward(request, response);

		//リクエストパラメーターを取得
		 request.setCharacterEncoding("UTF-8");
		 String POSTS_ID = request.getParameter("POSTS_ID");
		 String favorite = request.getParameter("favorite");

		 //いいねが押されたときの処理
		 FavoritesDAO fDao = new FavoritesDAO ();
		 //postsを数値に変換する（post_id)
		 int posts_id = 0;//postsを変換したもの
		 //fDaoを利用していいねする updateFavorite(posts_id)
		 fDao.updateFavorite(posts_id);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
