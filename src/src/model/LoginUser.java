package model;
import java.io.Serializable;

public class LoginUser implements Serializable
{
	private String id;	// ID
	private String pw;	// PW

	public LoginUser(String id, String pw)
	{
		this.id = id;
		this.pw = pw;
	}

	public LoginUser()
	{
		this.id = "";
		this.pw = "";
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getPw()
	{
		return pw;
	}

	public void setPw(String pw)
	{
		this.pw = pw;
	}
}
