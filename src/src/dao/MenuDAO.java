package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pet;
public class MenuDAO {
	// 引数paramでペット図鑑データを指定し、検索結果のリストを返す
		public List<Pet> select(int offset) {
			Connection conn = null; // Connectionはもともとあるもの、connは自分で作ったもの
			List<Pet> PetList = new ArrayList<Pet>();

            //ページ番号と1ページあたりの表示件数からMySQLのLIMIT句に当てるオフセット値の計算


			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee", "milk", "");

				// ペット投稿をTIMEで並び替えるSQL文を準備する
				//String sql = "SELECT * FROM POSTS ORDER BY TIME DESC";
				//ペット投稿を12投稿ずつとる
				String sql = "SELECT * FROM POSTS ORDER BY TIME DESC LIMIT 12 OFFSET ?";
				//String sql = "SELECT count(*) FROM POSTS ORDER BY TIME DESC LIMIT 12 OFFSET ?"
				PreparedStatement pStmt = conn.prepareStatement(sql);
				                  pStmt.setInt(1,offset);
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
					while (rs.next()) {
							Pet inf = new Pet(
							rs.getString("PICTURE_BOOKS_ID"),
							rs.getString("TITLE"),
							rs.getString("GENRE"),
							rs.getString("FREE"),
							rs.getString("PICTURE"),
							rs.getTimestamp("TIME")
									);
							PetList.add(inf);
					}
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				PetList = null;
			}
			catch (SQLException e) {
				e.printStackTrace();
				PetList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						PetList = null;
					}
				}
			}
			return PetList;
		}
}


