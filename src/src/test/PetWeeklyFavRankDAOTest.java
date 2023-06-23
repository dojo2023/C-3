package test;

import java.util.List;

import dao.PetWeeklyFavRankDAO;
import model.Pet;

public class PetWeeklyFavRankDAOTest
{
	  public static void main(String[] args)
	  {
		  PetWeeklyFavRankDAO dao = new PetWeeklyFavRankDAO();
	        int weekfav = 25; // テストする週番号

	        // 週別ランキングを取得
	        List<Pet> ranking = dao.select(weekfav);

	        // 結果を表示
	        System.out.println("週別ランキング (週番号: " + weekfav + ")");
	        if (ranking.isEmpty())
	        {
	            System.out.println("ランキングはありません。");
	        } else {
	            for (int i = 0; i < ranking.size(); i++)
	            {
	                Pet pet = ranking.get(i);
	                System.out.println((i + 1) + ". " + pet.getTitle() + " - いいね数: " + pet.getFavorite());
	            }
	        }
	    }
	}