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
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.TripSearchCriteria;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JTextField jDateLow;
	private JTextField jDateHigh;
	private JTextField jPriceLow;
	private JTextField jPriceHigh;
	private JTextField jCategory;
	private JTextField jNameTrip;
	private JTextField jDurationLow;
	private JTextField jDurationHigh;
	private JTextField jNoGuests;
	private JTextField jPlaceOfDeparture;
	
	/**
	 * Create the panel.
	 */
	public FilterPanel() {
		
		JLabel lblDates = new JLabel("Dates:");
		
		jDateLow = new JTextField();
		jDateLow.setText("dd/MMM/yyyy");
		jDateLow.setColumns(10);
		
		JLabel lblBetween = new JLabel("between");
		
		jDateHigh = new JTextField();
		jDateHigh.setText("dd/MMM/yyyy");
		jDateHigh.setColumns(10);
		
		JLabel lblPrices = new JLabel("Prices:");
		
		jPriceLow = new JTextField();
		jPriceLow.setText("Lowest price");
		jPriceLow.setColumns(10);
		
		JLabel lblBetween_1 = new JLabel("between");
		
		jPriceHigh = new JTextField();
		jPriceHigh.setText("Highest price");
		jPriceHigh.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category:");
		
		jCategory = new JTextField();
		jCategory.setText("Adventure, Nature...");
		jCategory.setColumns(10);
		
		JLabel lblNameOfTrip = new JLabel("Name of trip:");
		
		jNameTrip = new JTextField();
		jNameTrip.setText("Golden circle, pubcrawl...");
		jNameTrip.setColumns(10);
		
		JLabel lblDuration = new JLabel("Duration:");
		
		jDurationLow = new JTextField();
		jDurationLow.setText("0");
		jDurationLow.setColumns(10);
		
		JLabel lblMin = new JLabel("min");
		
		JLabel lblBetween_2 = new JLabel("between");
		
		jDurationHigh = new JTextField();
		jDurationHigh.setColumns(10);
		
		JLabel lblMin_1 = new JLabel("min");
		
		JLabel lblNoGuests = new JLabel("no. Guests:");
		
		jNoGuests = new JTextField();
		jNoGuests.setText("How many are traveling?");
		jNoGuests.setColumns(10);
		
		JLabel lblPlaceOfDeparture = new JLabel("Place of departure:");
		
		jPlaceOfDeparture = new JTextField();
		jPlaceOfDeparture.setText("Where are you traveling from?");
		jPlaceOfDeparture.setColumns(10);


		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNoGuests)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jNoGuests))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPlaceOfDeparture)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jPlaceOfDeparture))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDuration)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jDurationLow, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMin)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblBetween_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jDurationHigh, 0, 0, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNameOfTrip)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jNameTrip))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCategory)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jCategory))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDates)
								.addComponent(lblPrices))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jPriceLow, 0, 0, Short.MAX_VALUE)
								.addComponent(jDateLow, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblBetween)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(jDateHigh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblBetween_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(jPriceHigh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMin_1)
					.addContainerGap(150, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDuration)
						.addComponent(jDurationLow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMin)
						.addComponent(lblBetween_2)
						.addComponent(jDurationHigh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMin_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(jDateLow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblBetween)
							.addComponent(jDateHigh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDates))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrices)
						.addComponent(jPriceLow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBetween_1)
						.addComponent(jPriceHigh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategory)
						.addComponent(jCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNameOfTrip)
						.addComponent(jNameTrip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNoGuests)
						.addComponent(jNoGuests, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlaceOfDeparture)
						.addComponent(jPlaceOfDeparture, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(177, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	
	
	
	//Criteria object contains supported filters only
	public TripSearchCriteria getCriteria(){
		return new TripSearchCriteria();
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
