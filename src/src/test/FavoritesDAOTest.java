package test;

import dao.FavoritesDAO;

public class FavoritesDAOTest {
	public static void main(String[] args) {
		FavoritesDAO dao = new FavoritesDAO(); //インスタンスの生成
		// テストデータの準備
        int POSTS_ID = 3;

		// updateFavorite()のテスト
		System.out.println("---------- updateFavorite()のテスト ----------");
		dao.updateFavorite(POSTS_ID);




	}
}


