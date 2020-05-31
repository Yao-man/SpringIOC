package com.cym.model;

/** 
 * @description 
 * 
 * @author Yaman
 * @createDate 2020/06/01
 */
public class Phone {

	private String brand, productionPlace;
	private short useAge = 0, size;
	private User user = null;
	public Phone(String brand, String productionPlace, short size) {
		super();
		this.brand = brand;
		this.productionPlace = productionPlace;
		this.size = size;
	}
	
	public Phone() {
		super();
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductionPlace() {
		return productionPlace;
	}
	public void setProductionPlace(String productionPlace) {
		this.productionPlace = productionPlace;
	}
	public short getUseAge() {
		return useAge;
	}
	public void setUseAge(short useAge) {
		this.useAge = useAge;
	}
	public short getSize() {
		return size;
	}
	public void setSize(short size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", productionPlace=" + productionPlace + ", useAge=" + useAge + ", size="
				+ size + ", user=" + user + "]";
	}
	
	
	
}


