package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoritesDAO {
	//投稿された写真にイイネを追加するため
	 public void updateFavorite(int POSTS_ID) {
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        PreparedStatement stmt1 = null;   //この3行は変数を宣言しているだけ

	        try {
	            // JDBCドライバのロード
	            Class.forName("org.h2.Driver");

	            // データベース接続の確立
	            conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee", "milk", "");

	            // イイネが存在するか確認するSQLの準備
	            String checkQuery = "SELECT * FROM FAVORITES WHERE posts_id = ?";
	            stmt = conn.prepareStatement(checkQuery);
	            stmt.setInt(1, POSTS_ID);

	            // SQLの実行
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                // イイネが存在する場合、更新SQLを実行してイイネ数を+1する
	                String updateQuery = "UPDATE favorites SET FAVORITE = FAVORITE + 1 WHERE POSTS_ID = ?";
	                stmt1 = conn.prepareStatement(updateQuery);
	                stmt1.setInt(1, POSTS_ID);
	                stmt1.executeUpdate();
	            } else {
	                // イイネが存在しない場合、新規挿入SQLを実行してイイネを追加する
	                String insertQuery = "INSERT INTO FAVORITE (POSTS_ID, FAVORITE) VALUES (?, 1)";
	                stmt1 = conn.prepareStatement(insertQuery);
	                stmt1.setInt(1, POSTS_ID);
	                stmt1.executeUpdate();
	            }

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // データベースを切断
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	 //結果を返す
//	 return FavoritesList
	}


