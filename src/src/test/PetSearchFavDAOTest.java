package test;

import java.util.List;

import dao.PetSearchFavDAO;
import model.Pet;

public class PetSearchFavDAOTest
{
	public static void main(String[] args)
    {
        // 検索テスト
        searchTest();
    }

    private static void searchTest()
    {
        PetSearchFavDAO dao = new PetSearchFavDAO();
        System.out.println("---------- select()のテスト ----------");

        // selectメソッドを呼び出して検索を実行
        List<Pet> resultList = dao.select();

        // 検索結果の処理
        if (!resultList.isEmpty())
        {
            for (Pet pet : resultList)
            {
            	System.out.println ("PICTURE_BOOKS_ID：" + pet.getPicture_books_id());
                 System.out.println("TITLE: " + pet.getTitle());
                 System.out.println("GENRE: " + pet.getGenre());
                 System.out.println("FREE: " + pet.getFree());
                 System.out.println("PICTURE: " + pet.getPicture());
                 System.out.println("FAVORITE:" + pet.getFavorite());
                 System.out.println("--------------------");
            }
        }
        else
        {
            System.out.println("検索結果がありません。");
            System.out.println("--------------------------------------");
        }
    }
}
