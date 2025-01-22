package com.covid.analysis;

import java.util.List;
import java.util.Scanner;

import com.covid.analysis.service.CovidDataService;
import com.covid.analysis.service.impl.CovidDataServiceImpl;

/**
 * Controller and App
 * 
 * @author Onkar Prakash Devale
 *
 */
public class Main {
	
	public static void main(String[] args) {
		CovidDataService dataService = new CovidDataServiceImpl();
		System.out.println("*************************************");
		System.out.println("1. Get State Names");
		System.out.println("2. Get District for given state");
		System.out.println("3. Display Data by State in Date Range");
		System.out.println("4. Exit");
		System.out.print("Please select  Option : ");

		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();

		if (line.equalsIgnoreCase("1")) {
			List<String> allStates = dataService.getAllStates();
			allStates.stream().forEach(System.out::println);
		}
	}
}
