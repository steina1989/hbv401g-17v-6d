package model;

public class Review {
	private String reviewHeader, reviewText;
	private int stars;
	
	/*
	 * CREATE TABLE [Reviews] ([tripName] Text, [reviewHeader] Text, [reviewText] Text, [stars] Integer);
	 */
	
	



	@Override
	public String toString(){
		return "Review: "+ this.reviewHeader + " Stars: " + this.stars;
	}

	public Review(String reviewHeader, String reviewText, int stars) {
		super();
		this.reviewHeader = reviewHeader;
		this.reviewText = reviewText;
		this.stars = stars;
	}

	public String getReviewHeader() {
		return reviewHeader;
	}

	public void setReviewHeader(String reviewHeader) {
		this.reviewHeader = reviewHeader;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}
	
	
	
	
}