package com.kings.expensetracker.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="petrol")
public class Petrol {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String retailer;
	private Date refuelDate;
	private double quantity;
	private int totalKilometers;
	private double average;
	private int kilometersRan;
	private Date nextRefuelDate;
	private int daysBtwRefuel;
	private int predictedTotalKilometers;
	private int predictedKmToRun;
	private double amountSpent;
	private double petrolPrice;
	private Timestamp createdDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRetailer() {
		return retailer;
	}
	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}
	public Date getRefuelDate() {
		return refuelDate;
	}
	public void setRefuelDate(Date refuelDate) {
		this.refuelDate = refuelDate;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public int getTotalKilometers() {
		return totalKilometers;
	}
	public void setTotalKilometers(int totalKilometers) {
		this.totalKilometers = totalKilometers;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public int getKilometersRan() {
		return kilometersRan;
	}
	public void setKilometersRan(int kilometersRan) {
		this.kilometersRan = kilometersRan;
	}
	public Date getNextRefuelDate() {
		return nextRefuelDate;
	}
	public void setNextRefuelDate(Date nextRefuelDate) {
		this.nextRefuelDate = nextRefuelDate;
	}
	public int getDaysBetweenRefuel() {
		return daysBtwRefuel;
	}
	public void setDaysBetweenRefuel(int daysBtwRefuel) {
		this.daysBtwRefuel = daysBtwRefuel;
	}
	public int getPredictedTotalKilometers() {
		return predictedTotalKilometers;
	}
	public void setPredictedTotalKilometers(int predictedTotalKilometers) {
		this.predictedTotalKilometers = predictedTotalKilometers;
	}
	public int getPredictedKmToRun() {
		return predictedKmToRun;
	}
	public void setPredictedKmToRun(int predictedKmToRun) {
		this.predictedKmToRun = predictedKmToRun;
	}
	public double getAmountSpent() {
		return amountSpent;
	}
	public void setAmountSpent(double amountSpent) {
		this.amountSpent = amountSpent;
	}
	public double getPetrolPrice() {
		return petrolPrice;
	}
	public void setPetrolPrice(double petrolPrice) {
		this.petrolPrice = petrolPrice;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate() {
		this.createdDate = getTimeStamp();
	}
	
	private Timestamp getTimeStamp() {
		return new Timestamp(System.currentTimeMillis());
	}
	
}
