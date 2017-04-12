package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TripSearchCriteria {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:MM");
	
  private String name;
  private Date dateLow;
  private Date dateHigh;
  private int priceLow;
  private int priceHigh;
  private String category;
 
  public TripSearchCriteria() {}

  
  
  
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