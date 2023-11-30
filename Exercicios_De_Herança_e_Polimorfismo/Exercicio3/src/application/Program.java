package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payer:");
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			System.out.println("Tax Payer #"+i+" Data:");
			System.out.print("Individual or Company (i/c)? :");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			double anualpay = sc.nextDouble();
			
			if(ch=='i') {
				System.out.print("Health expenditures:");
				double healthexpenditures =sc.nextDouble();
				
				TaxPayer payer = new Individual(name, anualpay, healthexpenditures);
				list.add(payer);
			}
			
			else {
				System.out.print("Number of employees:");
				int numberofemployees =sc.nextInt();
				
				TaxPayer payer = new Company(name, anualpay, numberofemployees);
				list.add(payer);	
			}
		}
		
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		double sum = 0;
		for(TaxPayer payer:list) {
			System.out.println(payer.getName()+": $ " + String.format("%.2f",payer.tax()));
			sum += payer.tax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $" + String.format("%.2f", sum));
		
		sc.close();
	}

}
