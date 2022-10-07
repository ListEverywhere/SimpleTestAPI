package com.gcep.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class ProductModel {

	private int id;
	
	@NotNull
	@Max(value = 45)
	private String name;
	
	private int quantity;
	
	@Max(value = 45)
	private String image_name;

	public ProductModel(int id, @NotNull @Max(45) String name, int quantity, @Max(45) String image_name) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.image_name = image_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", quantity=" + quantity + ", image_name=" + image_name
				+ "]";
	}
	
	
}
