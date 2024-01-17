package application;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.CarRental;
import entities.Invoice;
import entities.Vehicle;
import services.BrazilTaxService;
import services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Enter rental data");
		System.out.print("Car model:");
		String carmodel = sc.nextLine();
		
		System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime datePickup = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Retorno (dd/MM/yyyy hh:mm):");
		LocalDateTime dateReturn = LocalDateTime.parse(sc.nextLine(), fmt);
		
		
		
		System.out.println();
		System.out.print("Enter the price per hour:");
		double pricePerHour = sc.nextDouble();
		
		System.out.print("Enter the price per day:");
		double pricePerDay = sc.nextDouble();
		
		CarRental cr = new CarRental(datePickup, dateReturn, new Vehicle(carmodel), new Invoice());
		
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalService.processInvoice(cr);
		
		System.out.println();
		System.out.println("INVOICE:");
		System.out.println("Payment basic " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f",cr.getInvoice().getTax()));
		System.out.println("Total Payment: " +String.format("%.2f", cr.getInvoice().getTotalPayment()))    ;
		
				
		
		sc.close();
	}

}
