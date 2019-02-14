package com.spring.mvc.form;

import java.util.Date;

import javax.xml.crypto.Data;

public class TrainForm {
	
	private Date startTime;
	private Date endDate;
	private String source;
	private String destination;
	private int seats;
	private double cargoweight;
	private String clas;
	private double price;
	
	public TrainForm(Date startTime, Date endDate, String source, String destination, int seats, double cargoweight,
			String clas, double price) {
		super();
		this.startTime = startTime;
		this.endDate = endDate;
		this.source = source;
		this.destination = destination;
		this.seats = seats;
		this.cargoweight = cargoweight;
		this.clas = clas;
		this.price = price;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public double getCargoweight() {
		return cargoweight;
	}
	public void setCargoweight(double cargoweight) {
		this.cargoweight = cargoweight;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
}
