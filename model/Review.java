package model;

public class Review {
	private Buyer author;
	private String text;
	private int stars;
	
	
	
	public Review(Buyer author, String text, int stars) {
		this.author = author;
		this.text = text;
		this.stars = stars;
		
	}
	public Buyer getAuthor() {
		return author;
	}
	public void setAuthor(Buyer author) {
		this.author = author;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
}