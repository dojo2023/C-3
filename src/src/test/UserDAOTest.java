package test;

import dao.UsersDAO;
import model.LoginUser;

public class UserDAOTest {
	public static void main(String[] args) {
		UsersDAO dao = new UsersDAO();
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		LoginUser insRec = new LoginUser("msk", "pass");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
				System.out.println("ID：" + insRec.getId());
				System.out.println("PW：" + insRec.getPw());
		}
		else {
			System.out.println("登録失敗！");
		}

	}
}
