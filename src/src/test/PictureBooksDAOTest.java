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

		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Pets insRec = new Pets("msk", "うみちゃん", "2", "0601", "かわいい", "", "/coffee_Milk/img/test.png");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<Pets> petsList3 = dao.select(insRec);
			for (Pets aniAdd : petsList3) {
				System.out.println("USER_ID：" + aniAdd.getUser_id());
				System.out.println("NAME：" + aniAdd.getName());
				System.out.println("SEX：" + aniAdd.getSex());
				System.out.println("BIRTHDAY：" + aniAdd.getBirthday());
				System.out.println("APPEAL：" + aniAdd.getAppeal());
				System.out.println("CRY：" + aniAdd.getCry());
				System.out.println("PICTURE：" + aniAdd.getPicture());}
		}
		else {
			System.out.println("登録失敗！");
		}
	}
}
