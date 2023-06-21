package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pets;

// ここにインポート文必要？

public class PictureBooksDAO {
	// 引数paramでペット図鑑データを指定し、検索結果のリストを返す
	public List<Pets> select(Pets param) { // paramはParameterの文字をとったもの
		Connection conn = null; // Connectionはもともとあるもの、connは自分で作ったもの
		List<Pets> petsList = new ArrayList<Pets>();

		try
		{
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee", "milk", "");

			// USER_IDを用いてペット図鑑を検索するSQL文を準備する
			// 並び替えるIDはselectで取得しなくても使用できるのかが懸念点
			String sql = "select USER_ID,NAME,SEX,BIRTHDAY,APPEAL,CRY,PICTURE from PICTURE_BOOKS WHERE USER_ID = ? ORDER BY ID";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1,param.getUser_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Pets inf = new Pets(
				rs.getString("USER_ID"),
				rs.getString("NAME"),
				rs.getString("SEX"),
				rs.getString("BIRTHDAY"),
				rs.getString("APPEAL"),
				rs.getString("CRY"),
				rs.getString("PICTURE")
						);
				petsList.add(inf);
			}

		}
		catch (SQLException e) {
			e.printStackTrace(); // エラー内容を表示させる
			petsList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			petsList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					petsList = null;
				}
			}
		}
		// 結果を返す
				return petsList;
	}

	// 引数aniaddで指定されたペット図鑑を登録し、成功したらtrueを返す
	public boolean insert(Pets aniadd) {
		Connection conn = null;
		boolean AniaddResult = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee", "milk", "");

			// SQL文を準備する
			String sql = "insert into PICTURE_BOOKS values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, null);

			if (aniadd.getUser_id() != null && !aniadd.getUser_id().equals("")) {
				pStmt.setString(2, aniadd.getUser_id());
			}
			else {
				pStmt.setString(2, null);
			}

			if (aniadd.getName() != null && !aniadd.getName().equals("")) {
				pStmt.setString(3, aniadd.getName());
			}
			else {
				pStmt.setString(3, null);
			}

			if (aniadd.getSex() != null && !aniadd.getSex().equals("")) {
				pStmt.setString(4, aniadd.getSex());
			}
			else {
				pStmt.setString(4, null);
			}

			if (aniadd.getBirthday() != null && !aniadd.getBirthday().equals("")) {
				pStmt.setString(5, aniadd.getBirthday());
			}
			else {
				pStmt.setString(5, null);
			}

			if (aniadd.getAppeal() != null && !aniadd.getAppeal().equals("")) {
				pStmt.setString(6, aniadd.getAppeal());
			}
			else {
				pStmt.setString(6, null);
			}

			if (aniadd.getCry() != null && !aniadd.getCry().equals("")) {
				pStmt.setString(7, aniadd.getCry());
			}
			else {
				pStmt.setString(7, null);
			}

			if (aniadd.getPicture() != null && !aniadd.getPicture().equals("")) {
				pStmt.setString(8, aniadd.getPicture());
			}
			else {
				pStmt.setString(8, null);
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				AniaddResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
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
		// 結果を返す
		return AniaddResult;
	}
	//引数aniupで指定されたペット図鑑を更新し、成功したらtrueを返す
	public boolean update(Pets aniup) {
		Connection conn = null;
		boolean AniaddResult = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee", "milk", "");

			// SQL文を準備する
			String sql = " update PICTURE_BOOKS values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, null);

			if (aniup.getUser_id() != null && !aniup.getUser_id().equals("")) {
				pStmt.setString(2, aniup.getUser_id());
			}
			else {
				pStmt.setString(2, null);
			}

			if (aniup.getName() != null && !aniup.getName().equals("")) {
				pStmt.setString(3, aniup.getName());
			}
			else {
				pStmt.setString(3, null);
			}

			if (aniup.getSex() != null && !aniup.getSex().equals("")) {
				pStmt.setString(4, aniup.getSex());
			}
			else {
				pStmt.setString(4, null);
			}

			if (aniup.getBirthday() != null && !aniup.getBirthday().equals("")) {
				pStmt.setString(5, aniup.getBirthday());
			}
			else {
				pStmt.setString(5, null);
			}

			if (aniup.getAppeal() != null && !aniup.getAppeal().equals("")) {
				pStmt.setString(6, aniup.getAppeal());
			}
			else {
				pStmt.setString(6, null);
			}

			if (aniup.getCry() != null && !aniup.getCry().equals("")) {
				pStmt.setString(7, aniup.getCry());
			}
			else {
				pStmt.setString(7, null);
			}

			if (aniup.getPicture() != null && !aniup.getPicture().equals("")) {
				pStmt.setString(8, aniup.getPicture());
			}
			else {
				pStmt.setString(8, null);
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				AniaddResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
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

	// 結果を返す
			return AniaddResult;
    }
	//引数idで指定されたペット図鑑を削除し、成功したらtrueを返す
	public boolean delete(String id) {
		Connection conn = null;
		boolean AniaddResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee", "milk", "");

			// SQL文を準備する
			String sql = "delete from PICTURE_BOOKS where ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, id);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				AniaddResult = true;

		    }

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
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

		// 結果を返す
		return AniaddResult;
    }

}
