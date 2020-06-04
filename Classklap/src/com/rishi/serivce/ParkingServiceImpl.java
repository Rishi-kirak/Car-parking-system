package com.rishi.serivce;
import java.util.*;
import com.rishi.pojo.Car;

public class ParkingServiceImpl implements ParkingService {
	
	Car[] parkingLot;
	int size;
	HashMap<String,ArrayList<String> > colorAndNumberPlate;
	HashMap<String, ArrayList<Integer> > colorAndSlots;
	PriorityQueue<Integer> pq;
	public ParkingServiceImpl(){
		parkingLot=null;
		colorAndNumberPlate= new HashMap<String,ArrayList<String> >();
		colorAndSlots= new HashMap<String, ArrayList<Integer> > ();
		pq= new PriorityQueue<Integer> ();
		size=0;
	}

	
	@Override
	public void createParkingLot(int size) {
		this.size=size;
		parkingLot= new Car[size];
		System.out.println("Created a parking lot with "+size+" slots");
		for(int i=0;i<size;i++){
			pq.add(i);
		}

	}

	@Override
	public void park(String numberPlate, String color) {
		if(pq.size()==0 ){
			System.out.println("Sorry, parking lot is full");
		}else{
			int position= pq.poll();
			parkingLot[position]= new Car(numberPlate, color);
			System.out.println("Allocated slot number: "+(position+1) );
			try{
				if(colorAndNumberPlate.containsKey(color)){
//					System.out.println("inside");
					ArrayList<String> list= colorAndNumberPlate.get(color);
					list.add(numberPlate);
					colorAndNumberPlate.put(color, new ArrayList<String>(list) );
					ArrayList<Integer> list2= colorAndSlots.get(color);
					list2.add(position+1);
					colorAndSlots.put(color, new ArrayList<Integer>(list2));
				}else{
					ArrayList<String> list= new ArrayList<>();
					list.add(numberPlate);
					colorAndNumberPlate.put(color, new ArrayList<String>(list) );
					ArrayList<Integer> list2= new ArrayList<>();
					list2.add(position+1);
					colorAndSlots.put(color, new ArrayList<Integer>(list2));
					
				}
			}catch(Exception e){
				System.out.println("error in park funtion");
			}
		}
		
	}

	@Override
	public void leave(int number) {
		int position= number-1;
		if(pq.contains(position)){
			System.out.println("Position is empty");
		}else{
			pq.add(position);
			Car car= parkingLot[position];
			parkingLot[position]=null;
			System.out.println("Slot number "+number+" is free");
			try{
			String color=car.getColor();
			ArrayList<String> list= colorAndNumberPlate.get(color);
			list.remove(car.getNumberPlate());
			colorAndNumberPlate.put(color, new ArrayList<String>(list));
			ArrayList<Integer> list2= colorAndSlots.get(color);
			list2.remove(list2.indexOf(number));
			colorAndSlots.put(color, new ArrayList<Integer>(list2));
		
			}
			catch(Exception e){
				System.out.println("error in leave function");
			}
		}

	}

	@Override
	public void status() {
		System.out.println("Slot No."+" "+"Registration No"+" "+"Color");
		for(int i=0;i<size;i++){
			if(parkingLot[i]==null)continue;
			else{
				System.out.println(i+1 +"       "+parkingLot[i].getNumberPlate()+"  "+parkingLot[i].getColor());	
			}
		}

	}

	@Override
	public void registrationNumbersForCarsWithColor(String color) {
		if(!colorAndNumberPlate.containsKey(color)){
			System.out.println("No car with "+color+" color in parking Lot");
		}else{
			ArrayList<String> list= colorAndNumberPlate.get(color);
			if(list.size()==0){
				System.out.println("No car with "+color+" color in parking Lot");
			}else{
				for(int i=0;i<list.size();i++){
					if(i==list.size()-1){
						System.out.print(list.get(i));
					}else{
						System.out.print(list.get(i)+", ");
					}
				}
				System.out.println("");
			}
		}
	}

	@Override
	public void slotNumbersForCarsWithColor(String color) {
		if(!colorAndSlots.containsKey(color)){
			System.out.println("No car with "+color+" color in parking Lot");
		}else{
			ArrayList<Integer> list= colorAndSlots.get(color);
			if(list.size()==0){
				System.out.println("No car with "+color+" color in parking Lot");
			}else{
				Collections.sort(list);
				for(int i=0;i<list.size();i++){
					if(i==list.size()-1){
						System.out.print(list.get(i));
					}else{
						System.out.print(list.get(i)+", ");
					}
				}
				System.out.println("");
			}
		}

	}

	@Override
	public void slotNumberForRegistrationNumber(String numberPlate) {
		boolean found=false;
		for(int i=0;i<size;i++){
			if(parkingLot[i]==null)continue;
			else if(parkingLot[i].getNumberPlate().equals(numberPlate)){
					System.out.println(i+1);
					found=true;
					break;
				}
		}
		if(!found){
			System.out.println("Not found");
		}

	}

	@Override
	public void incorrectinput() {
		System.out.println("Input format is incorrect");
	}

}
