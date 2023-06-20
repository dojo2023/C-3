package model;
import java.io.Serializable;

public class Pet implements Serializable{
	private String picture_books_id; // PICTUER_BOOKS_ID
	private String title; // TITLE
	private String genre; // GENRE
	private String free; // FREE
	private String picture; // PICTURE
	private String time; // TIME

	public String getPicture_books_id() {
		return picture_books_id;
	}
	public void setPicture_books_id(String picture_books_id) {
		this.picture_books_id = picture_books_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getFree() {
		return free;
	}
	public void setFree(String free) {
		this.free = free;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}


