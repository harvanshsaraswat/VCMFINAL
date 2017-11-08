package com.zanmitech.dto;

public class Voter extends PersistableBean {

	private int voterId;
	private String name;
	private VoterAddress address;

	public Voter(Boolean newBean) {
		super(newBean);
	}

	

	public Voter(Boolean newBean,int voterId, String name, VoterAddress address) {
		super(newBean);
		this.voterId = voterId;
		this.name = name;
		this.address = address;
	}



	public int getVoterId() {
		return voterId;
	}

	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VoterAddress getAddress() {
		return address;
	}

	public void setAddress(VoterAddress address) {
		this.address = address;
	}
	
}
