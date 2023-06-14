package model;
import java.io.Serializable;

public class LoginUsers implements Serializable
{
	private String id;	// ログイン時のID

	public LoginUsers()
	{
		this(null);
	}

	public LoginUsers(String id)
	{
		this.id = id;
	}

	public String getId()
	{
		return id;
	}

	public void setUsersId(String id)
	{
		this.id = id;
	}
}
