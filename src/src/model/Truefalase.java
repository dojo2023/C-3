package model;
import java.io.Serializable;

public class Truefalase implements Serializable {

	private boolean pet_button; // Myペット図鑑においてボタンを表示させるかどうかを判定する

	public Truefalase(boolean pet_button) {
		this.pet_button = pet_button;
	}

	public Truefalase() {
		this.pet_button = false;
	}

	public boolean isPet_button() {
		return pet_button;
	}

	public void setPet_button(boolean pet_button) {
		this.pet_button = pet_button;
	}



}
