package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenuDAO;
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
        int page =1;
        int Page = 12;
        int OFFSET = (page-1)* Page;

		//DAOからペット投稿のデータを取得する
        MenuDAO mDAO = new MenuDAO();
        List<Pet> petList = mDAO.select(OFFSET);

        // 検索結果をリクエストスコープに格納する
		request.setAttribute("petList", petList);

        //メニューサーブレットにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
		dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//リクエストパラメーターを取得、doPostに書く
//		 request.setCharacterEncoding("UTF-8");
//		 String posts = request.getParameter("POSTS_ID");
//		 String fav = request.getParameter("favorite");
//
//		 //いいねが押されたときの処理
//		 FavoritesDAO fDao = new FavoritesDAO ();
//		 //postsを数値に変換する（posts_id)
//		 int posts_id = 0;//postsを変換したもの
//		 //fDaoを利用していいねする updateFavorite(posts_id)
//		 fDao.updateFavorite(posts_id);

	}

}
