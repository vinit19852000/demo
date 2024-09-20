package com.example.demo.Object;

public class Company {
	private String company;
	
	
	public Company() {
		
	}
	public String getCompany() {
		return company;
	}
	
	

	public void setCompany(String company) {
		this.company = company;
	}

	public String getGST() {
		return GST;
	}

	public void setGST(String gST) {
		GST = gST;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	private String GST;
	private double revenue;
	private String location;
	
	public Company(String company, String gST, double revenue, String location) {
		super();
		this.company = company;GST = gST;
		this.revenue = revenue;
		this.location = location;
	}


	
}
