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
}