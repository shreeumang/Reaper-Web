package com.java.ApiApplication;



public class GetterSetterMethods {

	private Integer id;
	private String title;
	private String discription;
	private double price;

	
	public GetterSetterMethods(Integer id, String title, String discription,double price ) {
		super();
		this.id = id;
		this.title = title;
		this.discription = discription;
		this.price=price;
	}
	public GetterSetterMethods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public double getprice() {
		return price;
	}
	public void setProductPrice(double price) {
		this.price = price;
		
	}

	public String toString() {
		return "GetterSetterMethods [Id=" + id + ", Title=" + title + ", Discription=" + discription + ", Price=" + price + "]";
	}
}
