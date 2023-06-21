package test;

import java.util.List;

import dao.PetSearchDAO;
import model.Pet;

public class PetSearchDAOTest
{
    public static void main(String[] args)
    {
        // 検索テスト
        searchTest();
    }

    private static void searchTest()
    {
        PetSearchDAO dao = new PetSearchDAO();
        System.out.println("---------- select()のテスト ----------");
        // 検索キーワードを指定
        String keyWord = "#";

        // selectメソッドを呼び出して検索を実行
        List<Pet> resultList = dao.select(keyWord);

        // 検索結果の処理
        if (!resultList.isEmpty())
        {
            for (Pet pet : resultList)
            {
            	System.out.println("PICTURE_BOOKS_ID：" + pet.getPicture_books_id());
                 System.out.println("TITLE: " + pet.getTitle());
                 System.out.println("GENRE: " + pet.getGenre());
                 System.out.println("FREE: " + pet.getFree());
                 System.out.println("PICTURE: " + pet.getPicture());
                 System.out.println("TIME: " + pet.getTime());
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