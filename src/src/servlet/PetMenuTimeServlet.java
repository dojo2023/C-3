package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PetMenuTimeDAO;
import model.Pet;

/**
 * Servlet implementation class PetMenuTimeServlet
 */
@WebServlet("/PetMenuTimeServlet")
public class PetMenuTimeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetMenuTimeServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String picture_books_id = request.getParameter("PICTURE_BOOK_ID");
				String title = request.getParameter("TITLE");
				String genre = request.getParameter("GENRE");
				String free = request.getParameter("FREE");
				String picture = request.getParameter("PICTURE");
				String time = request.getParameter("TIME");
				  // 検索処理を行う
		        PetMenuTimeDAO fDao = new PetMenuTimeDAO();
		        List<Pet> PetList = fDao.select(picture_books_id, title, genre, free, picture,time);

		        // シャッフルされたリストをJSPに渡す
		        request.setAttribute("PetList", PetList);

		        // 結果ページにフォワードする
		     	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
		     	dispatcher.forward(request, response);

	}
}
