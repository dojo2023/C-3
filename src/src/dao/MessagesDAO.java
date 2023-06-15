package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Message;

public class MessagesDAO
{
	public List<Message> selectByRoomId(int roomId) throws ClassNotFoundException, SQLException
	{
		List<Message> messageList = new ArrayList<>();
		Connection conn = null;

		try
		{
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee","milk", "");
		}
		finally
		{
			//データベース切断
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					messageList = null;
				}
			}
		}
		return messageList;
	}
	//チャットにinsert機能をつける
	public boolean insert(Message message)
	{
		Connection conn = null;
		boolean result = false;

		try
		{
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee", "milk", "");
			//SQL文を準備する
			//?のことをパラメータ変数、プレースホルダ、バインド変数
			String sql = "insert into MESSAGES values(? ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SQL文を完成させるニックネーム
			if(message.getNickname() != null && !message.getNickname().equals(""))
			{
				pStmt.setString(1, message.getNickname());
			}
			else
			{
				pStmt.setString(1,null);
			}
			if(message.getMessage() != null && !message.getMessage().equals(""))
			{
				pStmt.setString(2,message.getMessage());
			}
			else
			{
				pStmt.setString(2, null);
			}
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1)
			{
				result = true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
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
					}
				}
		}
		return result;
	}

}
