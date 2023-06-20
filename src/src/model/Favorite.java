package model;
import java.io.Serializable;

public class Favorite implements Serializable{
	private String POSTS_ID; //ペット投稿ID
	private Integer favorite; //いいね数

	public Favorite(String POSTS_ID, Integer favorite) {
		super();
		this.POSTS_ID = POSTS_ID;
		this.favorite = favorite;
	}
	public Favorite() {
		super();
		this.POSTS_ID = "";
		this.favorite = 0;
	}
	public Favorite(String POSTS_ID) {
		this.POSTS_ID = POSTS_ID;
	}
	public String getPOSTS_ID() {
		return POSTS_ID;
	}
	public void setPOSTS_ID(String pOSTS_ID) {
		POSTS_ID = pOSTS_ID;
	}
	public Favorite(Integer favorite) {
		this.favorite = favorite;
	}
	public Integer getFavorite() {
		return favorite;
	}
	public void setFavorite(Integer favorite) {
		this.favorite = favorite;
	}
}
