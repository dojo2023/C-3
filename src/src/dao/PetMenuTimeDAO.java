package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pet;

public class PetMenuTimeDAO
{
	public List<Pet> select(String picture_books_id, String title, String genre, String free, String picture, String time)
	{
		Connection conn = null;
		List<Pet> petList = new ArrayList<Pet>();

	try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee", "milk", "");

			//SQL文の準備
			String sql ="SELECT * FROM POSTS ORDER BY TIME DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

           // pStmt.setString(1, picture_books_id);
           // pStmt.setString(2, title);
           // pStmt.setString(3, genre);
           // pStmt.setString(4, free);
           // pStmt.setString(5, picture);
           // pStmt.setString(6, time);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next())
			{
				Pet inf = new Pet
				(
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
		catch (ClassNotFoundException e)
		{
		e.printStackTrace();
		petList = null;
		}
		catch (SQLException e)
		{
		e.printStackTrace();
		petList = null;
		}
		finally
		{
		// データベースを切断
		if (conn != null)
		{
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				petList = null;
			}
		}
		}
	return petList;

	}
}
