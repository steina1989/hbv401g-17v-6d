package view;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

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
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import model.TripSearchCriteria;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class FilterPanel extends JPanel {
	
	private TripSearchCriteria criteria;
	private Date dateLow;
	private Date dateHigh;
	private Integer priceLow = 0;
	private Integer priceHigh = Integer.MAX_VALUE;
	private String category = "";
	private String name = "";
	private Integer noGuests = 0;
	private String placeOfDeparture = "";
	private Integer durationLow = 0;
	private Integer durationHigh = Integer.MAX_VALUE;
	private JTextField jNameTrip;
	private JComboBox categoryCombo;
	
	private JDatePickerImpl datePickerTo;
	private JDatePickerImpl datePickerFrom;
	
	/**
	 * Create the panel.
	 */
	public FilterPanel() {
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3,3,3,3);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.setConstraints(this, c);
		gridBagLayout.columnWidths = new int[]{241, 127, 32, 32, 102, 0};
		gridBagLayout.rowHeights = new int[]{14, 0, 0, 20, 20, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNameOfTrip = new JLabel("Search by name of trip:");
		GridBagConstraints gbc_lblNameOfTrip = new GridBagConstraints();
		gbc_lblNameOfTrip.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNameOfTrip.anchor = GridBagConstraints.NORTH;
		gbc_lblNameOfTrip.insets = new Insets(0, 0, 5, 5);
		gbc_lblNameOfTrip.gridwidth = 2;
		gbc_lblNameOfTrip.gridx = 0;
		gbc_lblNameOfTrip.gridy = 0;
		add(lblNameOfTrip, gbc_lblNameOfTrip);
		
		jNameTrip = new JTextField();
		jNameTrip.setToolTipText("Golden circle, pubcrawl...");
		jNameTrip.setColumns(40);
		GridBagConstraints gbc_jNameTrip = new GridBagConstraints();
		gbc_jNameTrip.fill = GridBagConstraints.HORIZONTAL;
		gbc_jNameTrip.anchor = GridBagConstraints.NORTH;
		gbc_jNameTrip.insets = new Insets(0, 0, 5, 5);
		gbc_jNameTrip.gridwidth = 2;
		gbc_jNameTrip.gridx = 0;
		gbc_jNameTrip.gridy = 1;
		add(jNameTrip, gbc_jNameTrip);
		
		JLabel lblCategory = new JLabel("Category:");
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategory.gridx = 0;
		gbc_lblCategory.gridy = 2;
		add(lblCategory, gbc_lblCategory);
		
		categoryCombo = new JComboBox();
		categoryCombo.setModel(new DefaultComboBoxModel(new String[] {"All Categories", "Cruise", "Hiking", "Road Trip", "Snorkeling"}));
		GridBagConstraints gbc_categoryCombo = new GridBagConstraints();
		gbc_categoryCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_categoryCombo.anchor = GridBagConstraints.NORTHWEST;
		gbc_categoryCombo.insets = new Insets(0, 0, 5, 5);
		gbc_categoryCombo.gridx = 1;
		gbc_categoryCombo.gridy = 2;
		add(categoryCombo, gbc_categoryCombo);
		
		JLabel lblDates = new JLabel("When will you be travelling?");
		GridBagConstraints gbc_lblDates = new GridBagConstraints();
		gbc_lblDates.gridwidth = 2;
		gbc_lblDates.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDates.insets = new Insets(0, 0, 5, 5);
		gbc_lblDates.gridx = 0;
		gbc_lblDates.gridy = 3;
		add(lblDates, gbc_lblDates);
		
		
		GridBagConstraints gbc_datePickFrom = new GridBagConstraints();
		gbc_datePickFrom.gridwidth = 2;
		gbc_datePickFrom.fill =  GridBagConstraints.HORIZONTAL;
		gbc_datePickFrom.insets = new Insets(0,0,5,5);
		gbc_datePickFrom.gridx = 0;
		gbc_datePickFrom.gridy = 4;
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanelFrom = new JDatePanelImpl(model, p);
		datePickerFrom = new JDatePickerImpl(datePanelFrom,new DateLabelFormatter());
		Calendar currentDate = Calendar.getInstance();
		model.setSelected(true);
		model.setDate(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH));

		add(datePickerFrom,gbc_datePickFrom);

		
		GridBagConstraints gbc_datePickTo = new GridBagConstraints();
		gbc_datePickTo.gridwidth = 2;
		gbc_datePickTo.fill =  GridBagConstraints.HORIZONTAL;
		gbc_datePickTo.insets = new Insets(0,0,5,5);
		gbc_datePickTo.gridx = 0;
		gbc_datePickTo.gridy = 5;
		UtilDateModel model2 = new UtilDateModel();
		JDatePanelImpl datePanelTo = new JDatePanelImpl(model2, p);
		datePickerTo = new JDatePickerImpl(datePanelTo,new DateLabelFormatter());
		add(datePickerTo,gbc_datePickTo);
		//Add one year to see trips into the future.
		model2.setDate(currentDate.get(Calendar.YEAR)+1, currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH));
		model2.setSelected(true);

		
		JLabel lblPriceMax = new JLabel("Price from 0 ISK to 50,000 ISK");
		GridBagConstraints gbc_lblPriceMax = new GridBagConstraints();
		gbc_lblPriceMax.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPriceMax.gridwidth = 2;
		gbc_lblPriceMax.insets = new Insets(0, 0, 5, 5);
		gbc_lblPriceMax.gridx = 0;
		gbc_lblPriceMax.gridy = 6;
		add(lblPriceMax, gbc_lblPriceMax);
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL,0,50000,50000);
		slider.setMajorTickSpacing(10000);
		//slider.setMinorTickSpacing(100);
		slider.setPaintTicks(true);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider)e.getSource();
				priceHigh = ((int)source.getValue());
				lblPriceMax.setText(String.format("Price from 0 ISK to %,d ISK",priceHigh));
			}
		}
				);
		


		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider.gridwidth = 2;
		gbc_slider.insets = new Insets(0, 0, 5, 5);
		gbc_slider.gridx = 0;
		gbc_slider.gridy = 7;
		add(slider, gbc_slider);
		
		JLabel lblNoGuests = new JLabel("How many tickets do you need?");
		GridBagConstraints gbc_lblNoGuests = new GridBagConstraints();
		gbc_lblNoGuests.gridwidth = 2;
		gbc_lblNoGuests.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNoGuests.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoGuests.gridx = 0;
		gbc_lblNoGuests.gridy = 8;
		add(lblNoGuests, gbc_lblNoGuests);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.anchor = GridBagConstraints.LINE_START;
		gbc_spinner.insets = new Insets(0, 0, 0, 5);
		gbc_spinner.gridx = 0;
		gbc_spinner.gridy = 9;
		add(spinner, gbc_spinner);
	}
		
	
	//Criteria object contains supported filters only right now during testing of the GUI.
	//BLA
	public TripSearchCriteria getCriteria(){
		name = jNameTrip.getText();
		dateLow = (Date) datePickerFrom.getModel().getValue();
		dateHigh = (Date) datePickerTo.getModel().getValue();
		priceHigh = 
		priceLow = 0;
		category = (String) categoryCombo.getSelectedItem();
		if (category == "All Categories") category = "";
		return new TripSearchCriteria(name,dateLow,dateHigh,priceLow,priceHigh,category,noGuests);
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

	public Integer getNoGuests() {
		return noGuests;
	}

	public void setNoGuests(Integer noGuests) {
		this.noGuests = noGuests;
	}

	public String getPlaceOfDeparture() {
		return placeOfDeparture;
	}

	public void setPlaceOfDeparture(String placeOfDeparture) {
		this.placeOfDeparture = placeOfDeparture;
	}

	public Integer getDurationLow() {
		return durationLow;
	}

	public void setDurationLow(Integer durationLow) {
		this.durationLow = durationLow;
	}

	public Integer getDurationHigh() {
		return durationHigh;
	}

	public void setDurationHigh(Integer durationHigh) {
		this.durationHigh = durationHigh;
	}
}
