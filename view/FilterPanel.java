package view;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JSplitPane;

public class FilterPanel extends JPanel {

	private Date dateLow;
	private Date dateHigh;
	private Integer priceLow;
	private Integer priceHigh;
	private String category;
	private String name;
	
	/**
	 * Create the panel.
	 */
	public FilterPanel() {

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
	
	public String getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
	
	

}
