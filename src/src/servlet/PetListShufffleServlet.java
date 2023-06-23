package servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PetListShuffleDAO;
import model.Pet;

/**
 * Servlet implementation class PetListShufffleServlet
 */
@WebServlet("/PetListShufffleServlet")
public class PetListShufffleServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    /**

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
		 // ペットのリストを取得
        PetListShuffleDAO dao = new PetListShuffleDAO();
        List<Pet> PetList = dao.select();

        // リストをシャッフル
        Collections.shuffle(PetList);

        // シャッフルされたリストをJSPに渡す
        request.setAttribute("PetList", PetList);


        // 結果ページにフォワードする
     	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
     	dispatcher.forward(request, response);

	}

}
