package test;
import java.sql.Timestamp;
import java.util.List;

import dao.PetPostsDAO;
import model.Pet;
public class PetPostsDAOTest {
	private static final Timestamp CURRENT_TIMESTAMP = null;
	public static void main(String[] args) {
		PetPostsDAO dao = new PetPostsDAO();
		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Pet> petList2 = dao.select();
		for (Pet inf : petList2) {
			System.out.println("PICTURE_BOOKS_ID：" + inf.getPicture_books_id());
			System.out.println("TITLE：" + inf.getTitle());
			System.out.println("GENRE：" + inf.getGenre());
			System.out.println("FREE：" + inf.getFree());
			System.out.println("PICTURE：" + inf.getPicture());
			System.out.println("TIME：" + inf.getTime());
		}
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Pet insRec = new Pet("1", "おうちのお庭でbbq", "1", "#ミニチュアピンシャー", "/img/うみちゃん.png", CURRENT_TIMESTAMP);
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
		}
			else {
				System.out.println("登録失敗！");
			}
	}
}