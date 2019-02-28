package com.spring.mvc.form;


import javax.xml.crypto.Data;

public class TrainForm {
	
	private Integer id;
	private String startTime;
	private String endDate;
	private String source;
	private String destination;
	private String seats;
	private String cargoweight;
	private String clas;
	private String price;
	
	public TrainForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public String getCargoweight() {
		return cargoweight;
	}

	public void setCargoweight(String cargoweight) {
		this.cargoweight = cargoweight;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}



	
}
