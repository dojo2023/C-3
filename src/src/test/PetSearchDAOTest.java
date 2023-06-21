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

    private static void searchTest() {
        PetSearchDAO dao = new PetSearchDAO();
        System.out.println("---------- select()のテスト ----------");
        // 検索キーワードを指定
        String keyWord = "#";

        // selectメソッドを呼び出して検索を実行
        List<Pet> resultList = dao.select(keyWord);

        // 検索結果の処理
        if (resultList != null)
        {
            for (Pet pet : resultList)
            {
                // 取得した検索結果を処理するコードを追加
                System.out.println(pet);
            }
        }
        else
        {
            System.out.println("検索結果がありません。");
        }
    }
}