package model;

public class Review {
	private String author;
	private String text;
	private int stars;
	
	
	
	public Review(String text, int stars) {
		this.author = author;
		this.text = text;
		this.stars = stars;
		
	}

	public String getAuthor() {
		return author;
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


	@Override
	public String toString(){
		return "Review: "+ this.text + "\n    Stars: " + this.stars;
	}
}