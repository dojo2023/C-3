package test;

import java.util.List;

import dao.PictureBooksDAO;
import model.Pets;

public class PictureBooksDAOTest {

	public static void main(String[] args) {
		PictureBooksDAO dao = new PictureBooksDAO();

		// editselect()のテスト
		System.out.println("---------- editselect()のテスト ----------");
		Pets pets = dao.editselect(2);
			System.out.println("USER_ID：" + pets.getUser_id());
			System.out.println("NAME：" + pets.getName());
			System.out.println("SEX：" + pets.getSex());
			System.out.println("BIRTHDAY：" + pets.getBirthday());
			System.out.println("APPEAL：" + pets.getAppeal());
			System.out.println("CRY：" + pets.getCry());
			System.out.println("PICTURE：" + pets.getPicture());


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
		Pets insRec = new Pets("","msk", "うみちゃん", "2", "0601", "かわいい", "", "/coffee_Milk/img/test.png");
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

		//update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Pets upRec = new Pets ("2","LOVE DOG", "まゆかちゃん更新", "メス", "0601", "かわいい更新", "", "/coffee_Milk/img/test.png");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<Pets> petsList4 = dao.select(upRec);
			for (Pets aniUp : petsList4) {
				System.out.println("USER_ID：" + aniUp.getUser_id());
				System.out.println("NAME：" + aniUp.getName());
				System.out.println("SEX：" + aniUp.getSex());
				System.out.println("BIRTHDAY：" + aniUp.getBirthday());
				System.out.println("APPEAL：" + aniUp.getAppeal());
				System.out.println("CRY：" + aniUp.getCry());
				System.out.println("PICTURE：" + aniUp.getPicture());}
		}
		else {
			System.out.println("更新失敗！");
		}
		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete("3")) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}

	}
}
