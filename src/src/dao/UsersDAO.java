package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginUser;

public class UsersDAO
{

	// ログインできるならtrueを返す
	public boolean isLoginOK(LoginUser idpw)
	{
		Connection conn = null;
		boolean loginResult = false;

		try
		{
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee", "milk", "");

			// SELECT文を準備する
			String sql = "select count(*) from USERS where USER_ID = ? and USER_PW = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, idpw.getId());
			pStmt.setString(2,idpw.getPw());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();//executeQuery select文を実行する

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1)
			{
				loginResult = true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();//Throwableクラスの「メソッド」例外発生時は、例外が発生したメソッドと例外が発生するまでに経てきたメソッドがわかる
			loginResult = false;
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
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}
}

