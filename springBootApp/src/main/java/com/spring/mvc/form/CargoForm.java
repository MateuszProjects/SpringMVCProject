package com.spring.mvc.form;

public class CargoForm {
	private Integer id;
	private Integer emplId;
	private Integer companyId;
	private Integer typeCargoTypeId;
	private Integer shipId;
	private Integer trainId;
	private Integer flightId;
	
	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	private String weight;
	private String sourceDestination;
	private String destination;
	private String fee;

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSourceDestination() {
		return sourceDestination;
	}

	public void setSourceDestination(String sourceDestination) {
		this.sourceDestination = sourceDestination;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public CargoForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmplId() {
		return emplId;
	}

	public void setEmplId(Integer emplId) {
		this.emplId = emplId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getTypeCargoTypeId() {
		return typeCargoTypeId;
	}

	public void setTypeCargoTypeId(Integer typeCargoTypeId) {
		this.typeCargoTypeId = typeCargoTypeId;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

}
