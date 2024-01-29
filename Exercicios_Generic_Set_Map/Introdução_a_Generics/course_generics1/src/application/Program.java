package application;

import java.util.Locale;
import java.util.Scanner;

import service.PrintService;

public class Program {

	public static void main(String[] args) {
	
	Locale.setDefault(Locale.US);	
	Scanner sc = new Scanner(System.in);	
		
	PrintService<Integer>ps = new PrintService<>();
	
	System.out.print("How many values?");
	int quant = sc.nextInt();
	
	for(int i=1; i<=quant;i++) {
		int x = sc.nextInt();
		ps.addValue(x);
		
	}
	
	ps.print();
	System.out.println("First: " + ps.firsty());	
		
		
		
	sc.close();
	}

}
