package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Message;

public class MessagesDAO {
    public List<Message> selectByRoomId(int roomId) throws ClassNotFoundException, SQLException
    {
        List<Message> messageList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try 
        {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee", "milk", "");

            String sql = "SELECT * FROM MESSAGES WHERE CHATROOMS_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roomId);

            rs = pstmt.executeQuery();

            while (rs.next())
            {
                Message message = new Message();
                message.setId(rs.getInt("ID"));
                message.setChatroomsid(rs.getString("CHATROOMS_ID"));
                message.setNickname(rs.getString("NICKNAME"));
                message.setMessage(rs.getString("MESSAGE"));
                message.setTime(rs.getTimestamp("TIME"));

                System.out.println("CHATROOMS_ID: " + message.getChatroomsid()); // 追加する行
                messageList.add(message);
            }
        }
        finally {
            if (rs != null)
            {
                rs.close();
            }
            if (pstmt != null)
            {
                try
                {
                    pstmt.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
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

        return messageList;
    }

    public boolean insert(Message message)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean result = false;

        try
        {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/coffee", "milk", "");

            String sql = "INSERT INTO MESSAGES (CHATROOMS_ID, NICKNAME, MESSAGE, TIME) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, message.getChatroomsid());
            pstmt.setString(2, message.getNickname());
            pstmt.setString(3, message.getMessage());
            pstmt.setTimestamp(4, message.getTime());

            if (pstmt.executeUpdate() == 1)
            {
                result = true;
            }
            conn.commit();
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        finally
        {
            if (pstmt != null)
            {
                try
                {
                    pstmt.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
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