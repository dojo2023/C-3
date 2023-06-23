package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FavoritesDAO;
/**
 * Servlet implementation class FavoriteServlet
 */
@WebServlet("/FavoriteServlet")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//メニューサーブレットにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメーターを取得、doPostに書く
		 request.setCharacterEncoding("UTF-8");
		 String posts = request.getParameter("posts_id");
		// String on = request.getParameter("on");
		 String fav = request.getParameter("favorite");

		//onに"true"という文字が入っている
		 //if(on.equals("true")) {
			 //1増やす

		//いいねが押されたときの処理
		  FavoritesDAO fDao = new FavoritesDAO ();

	    //postsを数値に変換する（posts_id)
	    //int posts_id = Integer.parseInt(posts);//postsを変換したもの、違ったらこれに戻す
		  int posts_id = Integer.parseInt(request.getParameter("posts_id"));
	    //fDaoを利用していいねする updateFavorite(posts_id)
			 fDao.updateFavorite(posts_id);
		// }else {
			 //1減らす
		// }

	}

}
