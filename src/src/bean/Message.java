package bean;

import java.sql.Timestamp;

public class Message
{
    private int Id;
    private String chatroomsid;
    private String nickname;
    private String message;
    private Timestamp time;


	public int getId()
	{
		return Id;
	}
	public void setId(int id)
	{
		Id = id;
	}
	public String getChatroomsid()
	{
		return chatroomsid;
	}
	public void setChatroomsid(String chatroomsid) {
		this.chatroomsid = chatroomsid;
	}
	public String getNickname()
	{
		return nickname;
	}
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public Timestamp getTime()
	{
		return time;
	}
	public void setTime(Timestamp time)
	{
		this.time = time;
	}



}
