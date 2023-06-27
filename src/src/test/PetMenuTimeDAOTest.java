package test;

import java.util.List;

import dao.PetMenuTimeDAO;
import model.Pet;

public class PetMenuTimeDAOTest {
    public static void main(String[] args) {
        PetMenuTimeDAO petMenuTimeDAO = new PetMenuTimeDAO();

        // テストに使用する複数の条件を設定
        String[][] testData = {
            {"1", "Sample Title 1", "Sample Genre 1", "Sample Free 1", "Sample Picture 1", "2023-06-27 12:00:00"},
            {"2", "Sample Title 2", "Sample Genre 2", "Sample Free 2", "Sample Picture 2", "2023-06-28 13:00:00"},
            {"3", "Sample Title 3", "Sample Genre 3", "Sample Free 3", "Sample Picture 3", "2023-06-29 14:00:00"}
        };

        // 各条件でselectメソッドを呼び出してペットのデータを取得
        for (String[] data : testData) {
            String picture_books_id = data[0];
            String title = data[1];
            String genre = data[2];
            String free = data[3];
            String picture = data[4];
            String time = data[5];

            List<Pet> petList = petMenuTimeDAO.select(picture_books_id, title, genre, free, picture, time);

            // 結果を表示
            if (petList != null) {
                for (Pet pet : petList) {
                    System.out.println("PICTURE_BOOKS_ID: " + pet.getPicture_books_id());
                    System.out.println("TITLE: " + pet.getTitle());
                    System.out.println("GENRE: " + pet.getGenre());
                    System.out.println("FREE: " + pet.getFree());
                    System.out.println("PICTURE: " + pet.getPicture());
                    System.out.println("TIME: " + pet.getTime());
                    System.out.println("-------------------------");
                }
            } else {
                System.out.println("データの取得に失敗しました。");
            }
        }
    }
}