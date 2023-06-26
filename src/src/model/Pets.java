package model;
import java.io.Serializable;

public class Pets implements Serializable {
	private String id; // ID
	private String user_id;  // USER_ID
	private String name;     // NAME
	private String sex;      // SEX 数字でもらうけどStringでいいかね？？
	private String birthday; // BIRTHDAY
	private String appeal;   // APPEAL
	private String cry;      // CRY
	private String picture;  // PICTURE

	public Pets(String id, String user_id, String name, String sex, String birthday, String appeal,String cry,String picture) {
		this.id = id;
		this.user_id = user_id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.appeal = appeal;
		this.cry = cry;
		this.picture = picture;
	}
	public Pets() {
		this.id = "";
		this.user_id = "";
		this.name = "";
		this.sex = "";
		this.birthday = "";
		this.appeal = "";
		this.cry = "";
		this.picture = "";
	}

	public Pets(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAppeal() {
		return appeal;
	}
	public void setAppeal(String appeal) {
		this.appeal = appeal;
	}
	public String getCry() {
		return cry;
	}
	public void setCry(String cry) {
		this.cry = cry;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
