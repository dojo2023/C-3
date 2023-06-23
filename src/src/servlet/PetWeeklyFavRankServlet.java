package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PetWeeklyFavRankDAO;
import model.Pet;

/**
 * Servlet implementation class PetWeeklyFavRankServlet
 */
@WebServlet("/PetWeeklyFavRankServlet")
public class PetWeeklyFavRankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//週番号を取得
		int weekfav = getCurrentWeekNumber();

		PetWeeklyFavRankDAO dao = new PetWeeklyFavRankDAO();
		List<Pet> PetList = dao.select(weekfav);

		//りくえすとすこーぷ
		request.setAttribute("PetList", PetList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
		dispatcher.forward(request, response);

	}

	private int getCurrentWeekNumber()
	{
		int weekOfyear = LocalDate.now().get(WeekFields.of(Locale.JAPANESE).weekOfWeekBasedYear());
		return weekOfyear;
	}

}
