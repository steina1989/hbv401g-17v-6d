package controller;

import view.FilterPanel;
import view.MainFrame;
import view.ViewTripsPanel;

import java.util.ArrayList;
import java.util.Objects;

import javax.swing.ButtonModel;
import javax.swing.JRadioButton;

import model.Review;
import model.Trip;
import model.TripSearchCriteria;


public class TripController {
	
	MainFrame mainFrame;
	TripSearchEngine tripSearchEngine;
	ArrayList<Trip> listOfTrips;
	
	
	public TripController(MainFrame mf){
		mainFrame = mf;
		tripSearchEngine = new TripSearchEngine();
	}
		
	
	public ArrayList<Trip> getListOfTrips() 
	{
		return listOfTrips;
	}
	
	public void searchClicked()
	{
		searchByFilterPanelCriteria();
		applySortingByRadioButtons();
		renderTrips();
	}
	
	public void sortClicked()
	{
		applySortingByRadioButtons();
		renderTrips();
	}
		/*
		ArrayList<JRadioButton> radioAttributes = mainFrame.getViewTripsPanel().getSortingAttributeRadioButtons();
		ArrayList<JRadioButton> radioSortDirection = mainFrame.getViewTripsPanel().getSortingDirectionRadioButtons();
		String attribute = "Price";
		String sortDirection = "Ascending";
		for (JRadioButton radioButton : radioAttributes) {
			if (radioButton.isSelected()) {
				attribute = radioButton.getText();
			}
		}
		for (JRadioButton radioButton : radioSortDirection) {
			if (radioButton.isSelected()) {
				sortDirection = radioButton.getText();
			}
		}
		TripSearchEngine.Attribute attributeToSortBy = TripSearchEngine.Attribute.PRICE;
		Boolean ascending = true;
		if (Objects.equals(attribute, "Price")) attributeToSortBy = TripSearchEngine.Attribute.PRICE;
		else if (Objects.equals(attribute, "Date")) attributeToSortBy = TripSearchEngine.Attribute.DATE;
		if (Objects.equals(sortDirection, "Ascending")) ascending = true;
		else if (Objects.equals(sortDirection, "Descending")) ascending = false;
		this.listOfTrips = tripSearchEngine.sortBy(attributeToSortBy, this.listOfTrips, true);
    this.mainFrame.getViewTripsPanel().renderTrips(listOfTrips);
	}
	
	//Reviews need to be fetched separately when a user selects a trip to examine it in detail (in TripInfoFrame)
	public ArrayList<Review> tripFromListClicked(Trip trip){
		return tripSearchEngine.findReviews(trip);
	}
	*/
	
	private void searchByFilterPanelCriteria() {
		ViewTripsPanel viewTripsPanel = mainFrame.getViewTripsPanel();
		FilterPanel fp = viewTripsPanel.getFilterPanel();
		TripSearchCriteria criteria = fp.getCriteria();
		this.listOfTrips = tripSearchEngine.search(criteria);
	}
	
	private void applySortingByRadioButtons() {
		ViewTripsPanel view = mainFrame.getViewTripsPanel();
		this.listOfTrips = sortingRequested(this.listOfTrips, view.getAttributeToSortBy(), view.getSortingDirection());
		//TripSearchEngine.Attribute attributeToSortBy;
		//if (Objects.equals(viewTripsPanel.getAttributeToSortBy(), "Price")) {
		//	attributeToSortBy = TripSearchEngine.Attribute.PRICE;
		//} else {
		//	attributeToSortBy = TripSearchEngine.Attribute.DATE;
		//}
		//Boolean sortAscending = viewTripsPanel.getSortingDirection();
		//this.listOfTrips = tripSearchEngine.sortBy(attributeToSortBy, this.listOfTrips, sortAscending);
	}
	 
	public ArrayList<Trip> sortingRequested(ArrayList<Trip> trips, String attribute, boolean ascending)
	{
		if (attribute=="Date") return tripSearchEngine.sortBy(TripSearchEngine.Attribute.DATE, trips, ascending);
		else if (attribute=="Price") return tripSearchEngine.sortBy(TripSearchEngine.Attribute.PRICE, trips, ascending);
		else throw new IllegalArgumentException("Attribute needs to be 'name', 'date', or 'price'");
	}
	
	private void renderTrips() {
    this.mainFrame.getViewTripsPanel().renderTrips(listOfTrips);
	}

	
	}
	
	


