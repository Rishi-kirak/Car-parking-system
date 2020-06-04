package com.rishi.pojo;

 public class Car {
	private String numberPlate;
	private String color;
	
	public Car(){
		
	}
	public Car(String numberPlate, String color ){
		this.numberPlate= numberPlate;
		this.color= color;
	}

	public String getNumberPlate() {
		return numberPlate;
	}


	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Car [numberPlate=" + numberPlate + ", color=" + color + "]";
	}
	

}
