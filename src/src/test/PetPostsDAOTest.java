package test;

import java.util.List;

import dao.PetPostsDAO;
import model.Pet;

public class PetPostsDAOTest {

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
	}
}
