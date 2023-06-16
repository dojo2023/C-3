package test;

import java.util.List;

import dao.PictureBooksDAO;
import model.Pets;

public class PictureBooksDAOTest {

	public static void main(String[] args) {
		PictureBooksDAO dao = new PictureBooksDAO();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Pets> petsList2 = dao.select(new Pets("LOVE DOG"));
		for (Pets inf : petsList2) {
			System.out.println("USER_ID：" + inf.getUser_id());
			System.out.println("NAME：" + inf.getName());
			System.out.println("SEX：" + inf.getSex());
			System.out.println("BIRTHDAY：" + inf.getBirthday());
			System.out.println("APPEAL：" + inf.getAppeal());
			System.out.println("CRY：" + inf.getCry());
			System.out.println("PICTURE：" + inf.getPicture());
		}
	}
}
