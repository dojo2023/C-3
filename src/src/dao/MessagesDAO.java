package dao;
import java.sql.Connection;
import java.sql.DriverManager;
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
		}
	}

}
