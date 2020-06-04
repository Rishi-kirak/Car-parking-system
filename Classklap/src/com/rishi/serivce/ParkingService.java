package com.rishi.serivce;

public interface ParkingService {
	
	void createParkingLot(int number);
	void park(String numberPlate, String color);
	void leave(int number);
	void status();
	void registrationNumbersForCarsWithColor(String color);
	void slotNumbersForCarsWithColor(String color);
	void slotNumberForRegistrationNumber(String numberPlate);
	void incorrectinput();

}
