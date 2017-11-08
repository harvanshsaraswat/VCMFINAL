package com.zanmitech.dto;

public class VoterAddress {

	
	private int pincode;
	private String villageOrStreet;
	private String tahshil;
	private String policeStation;
	private String district;
	
	
	
	public VoterAddress(int pincode, String district) {
		super();
		this.pincode = pincode;
		this.district = district;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getVillageOrStreet() {
		return villageOrStreet;
	}
	public void setVillageOrStreet(String villageOrStreet) {
		this.villageOrStreet = villageOrStreet;
	}
	public String getTahshil() {
		return tahshil;
	}
	public void setTahshil(String tahshil) {
		this.tahshil = tahshil;
	}
	public String getPoliceStation() {
		return policeStation;
	}
	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	
}
