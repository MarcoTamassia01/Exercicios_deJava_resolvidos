package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
	Locale.setDefault(Locale.US);		
	Scanner sc = new Scanner (System.in);
	
	List<Employee>employers = new ArrayList<>();
		
	System.out.print("Enter the number of employees:");
	int n = sc.nextInt();
	
	for(int i=1;i<=n;i++) {
		System.out.println("Employee #"+i+" data:");
		System.out.print("Outsourced (y/n): ");
		char out = sc.next().charAt(0);
		
		if(out=='n'){
			
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valueperhour = sc.nextDouble();
			
			Employee emplo = new Employee(name, hours, valueperhour);
			
			employers.add(emplo);
			
		}
		
		if(out=='y'){
			
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valueperhour = sc.nextDouble();
			System.out.print("Additional charge: ");
			double additional = sc.nextDouble();
		
			Employee emplo = new OutsourcedEmployee(name, hours,valueperhour, additional);
			
			employers.add(emplo);
			
		}
	}
		System.out.println();
		System.out.println("PAYMENT: ");
		
		for(Employee c: employers) {
			System.out.println(c);
		}
	
	sc.close();	

	}

}
