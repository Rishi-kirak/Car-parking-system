package com.rishi.main;

import java.util.Scanner;

import com.rishi.serivce.InputParser;
import com.rishi.serivce.InputParserImpl;

public class Main {
	
	public static void main(String[] args){
		
		Scanner sc= new Scanner(System.in);
		InputParser parse= new InputParserImpl();
		
		
		while(sc.hasNext() ){
			String input= sc.nextLine();
			if(input.equals(""))continue;
			
			parse.parsingInput(input);
		}
		
		
	}
	
	

}
