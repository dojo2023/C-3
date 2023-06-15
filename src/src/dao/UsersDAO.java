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

	// 引数newuserで指定されたログインユーザーを登録し、成功したらtrueを返す
	public boolean insert(LoginUser newuser) {
		Connection conn = null;
		boolean RegistResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee", "milk", "");

			// SQL文を準備する
			String sql = "insert into USERS values (?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (newuser.getId() != null && !newuser.getId().equals("")) {
				pStmt.setString(1, newuser.getId());
			}
			else {
				pStmt.setString(1, null);
			}

			if (newuser.getPw() != null && !newuser.getPw().equals("")) {
				pStmt.setString(2, newuser.getPw());
			}
			else {
				pStmt.setString(2, null);
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				RegistResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			//RegistResult = false; //いる？いらない？
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			//RegistResult = false;//いる？いらない？
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					//RegistResult = false; //いる？いらない？
				}
			}
		}
		// 結果を返す
		return RegistResult;
	}



}

