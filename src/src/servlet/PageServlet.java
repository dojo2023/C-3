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
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		String page = request.getParameter("page");
        Integer.parseInt(page);
		System.out.println(request.getParameter("page"));
		//             (page - 1) * 12
		//1 page  0    (  1  - 1) * 12
		//2 page 12    (  2  - 1) * 12
		//3 page 24    (  3  - 1) * 12
		//4 page 36    (  4  - 1) * 12
		int PAGE = Integer.parseInt(request.getParameter("page"));
        int Page = 12;
        int OFFSET = (PAGE-1)* Page;
//		String page2 = request.getParameter("page");
//		String page3 = request.getParameter("page");
//		String page4 = request.getParameter("page");
		//ページが押されたときの処理
		MenuDAO mDao = new MenuDAO ();
		 List<Pet> petList = mDao.select(OFFSET);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("petList", petList);
        //メニュー画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}