package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PetGenreSeachDAO;
import model.Pet;

/**
 * Servlet implementation class GenreSearchServlet
 */
@WebServlet("/GenreSearchServlet")
public class GenreSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//header.jspのジャンルボタンから押された、情報を引っ張ってくる。
		String genre = request.getParameter("genre");

		//ifで条件を記述
		if (genre.equals("dog")) {
			PetGenreSeachDAO gDao = new PetGenreSeachDAO();
			List<Pet> petList2 = gDao.select("犬");
			request.setAttribute("PetList", petList2);
		}
		else if(genre.equals("cat")) {
			PetGenreSeachDAO gDao = new PetGenreSeachDAO();
			List<Pet> petList2 = gDao.select("猫");
			request.setAttribute("PetList", petList2);
		}
		else if(genre.equals("small")) {
			PetGenreSeachDAO gDao = new PetGenreSeachDAO();
			List<Pet> petList2 = gDao.select("小動物");
			request.setAttribute("PetList", petList2);
		}
		else {
			PetGenreSeachDAO gDao = new PetGenreSeachDAO();
			List<Pet> petList2 = gDao.select("水生生物");
			request.setAttribute("PetList", petList2);
		}


		// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
				dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
