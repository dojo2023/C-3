package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pet;

public class PetPostsDAO {
	// 引数paramでペット図鑑データを指定し、検索結果のリストを返す
	public List<Pet> select() {
		Connection conn = null; // Connectionはもともとあるもの、connは自分で作ったもの
		List<Pet> petList = new ArrayList<Pet>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee", "milk", "");

			// ペット投稿をTIMEで並び替えるSQL文を準備する
			String sql = "SELECT * FROM POSTS ORDER BY TIME DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

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
						petList.add(inf);
				}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			petList = null;
		}
		catch (SQLException e) {
			e.printStackTrace();
			petList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					petList = null;
				}
			}
		}
		return petList;
	}

	// 引数postaddで指定されたペット投稿を登録し、成功したらtrueを返す
	public boolean insert(Pet postadd) {
		Connection conn = null;
		boolean PostaddResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee", "milk", "");

			// SQL文を準備する
			String sql = "insert into POSTS values (?, ?, ?, ?, ?, ?, ?,)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, null);

			if (postadd.getPicture_books_id() != null && !postadd.getPicture_books_id().equals("")) {
				pStmt.setString(2, postadd.getPicture_books_id());
			}
			else {
				pStmt.setString(2, null);
			}

			if (postadd.getTitle() != null && !postadd.getTitle().equals("")) {
				pStmt.setString(3, postadd.getTitle());
			}
			else {
				pStmt.setString(3, null);
			}

			if (postadd.getGenre() != null && !postadd.getGenre().equals("")) {
				pStmt.setString(4, postadd.getGenre());
			}
			else {
				pStmt.setString(4, null);
			}

			if (postadd.getFree() != null && !postadd.getFree().equals("")) {
				pStmt.setString(5, postadd.getFree());
			}
			else {
				pStmt.setString(5, null);
			}

			if (postadd.getPicture() != null && !postadd.getPicture().equals("")) {
				pStmt.setString(6, postadd.getPicture());
			}
			else {
				pStmt.setString(6, null);
			}

			if (postadd.getTime() != null && !postadd.getTime().equals("")) {
				pStmt.setTimestamp(7, postadd.getTime());
			}
			else {
				pStmt.setTimestamp(7, null);
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				PostaddResult = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			PostaddResult = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			PostaddResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return PostaddResult;
	}
}
