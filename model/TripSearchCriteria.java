package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TripSearchCriteria {

	
  private String name;
  private Date dateLow;
  private Date dateHigh;
  private Integer priceLow;
  private Integer priceHigh;
  private String category;
  private Integer noOfSeats;
 
  /*
   * The constructor forces instances to take valid state upon creation.
   */
  public TripSearchCriteria() {
  	this.name = "";
  	this.dateLow = new Date(); //lowDate is current time (a timestamp basically)
  	this.dateHigh = new Date(Long.MAX_VALUE);
  	this.priceLow = 0;
  	this.priceHigh = Integer.MAX_VALUE;
  	this.category = "";
  	this.noOfSeats = 1;
  }

  
	public Integer getNoOfSeats() {
		return noOfSeats;
	}


	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}


	public TripSearchCriteria(String name, Date dateLow, Date dateHigh, Integer priceLow, Integer priceHigh, String category, Integer noOfSeats) {
		super();
		this.name = name;
		this.dateLow = dateLow;
		this.dateHigh = dateHigh;
		this.priceLow = priceLow;
		this.priceHigh = priceHigh;
		this.category = category;
		this.noOfSeats = noOfSeats;
	}





	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateLow() {
		return dateLow;
	}

	public void setDateLow(Date dateLow) {
		this.dateLow = dateLow;
	}

	public Date getDateHigh() {
		return dateHigh;
	}

	public void setDateHigh(Date dateHigh) {
		this.dateHigh = dateHigh;
	}

	public int getPriceLow() {
		return priceLow;
	}

	public void setPriceLow(int priceLow) {
		this.priceLow = priceLow;
	}

	public int getPriceHigh() {
		return priceHigh;
	}

	public void setPriceHigh(int priceHigh) {
		this.priceHigh = priceHigh;
	}
}