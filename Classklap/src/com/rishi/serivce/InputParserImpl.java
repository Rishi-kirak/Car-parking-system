package com.rishi.serivce;

public class InputParserImpl implements InputParser {
	ParkingService service= new ParkingServiceImpl();

	@Override
	public void parsingInput(String s) {
		String[] array= s.split(" ");
		if(array.length >3 || array.length<=0){
			service.incorrectinput();
			return;
		}
		if(array[0].equals("park")){
			if(array.length!=3){
				service.incorrectinput();
			}else{
				service.park(array[1], array[2]);
			}
			return;
		}
		if(array[0].equals("status")){
			if(array.length!=1){
				service.incorrectinput();
			}else{
				service.status();
			}
			return;
		}
		if(array[0].equals("create_parking_lot")){
			if(array.length!=2){
				service.incorrectinput();
			}else{
				service.createParkingLot(Integer.parseInt(array[1]));
			}
			return;
		}
		if(array[0].equals("leave")){
			if(array.length!=2) service.incorrectinput();
			else service.leave(Integer.parseInt(array[1]));
			return;
		}
		if(array[0].equals("registration_numbers_for_cars_with_colour")){
			if(array.length!=2)service.incorrectinput();
			else service.registrationNumbersForCarsWithColor(array[1]);
			return;
		}
		if(array[0].equals("slot_numbers_for_cars_with_colour")){
			if(array.length!=2)service.incorrectinput();
			else service.slotNumbersForCarsWithColor(array[1]);
			return;
		}
		if(array[0].equals("slot_number_for_registration_number")){
			if(array.length!=2)service.incorrectinput();
			else service.slotNumberForRegistrationNumber(array[1]);
			return;
		}
		service.incorrectinput();
		
		
	}

}
