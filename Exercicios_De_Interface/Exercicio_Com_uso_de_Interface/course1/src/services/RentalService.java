package services;

import java.time.Duration;

import entities.CarRental;
import entities.Invoice;


public class RentalService {

	private double priceperHour;
	private double priceperDay;
	
	private TaxService taxService;
	
	public RentalService(double priceperHour, double priceperDay, TaxService taxService) {
		this.priceperHour = priceperHour;
		this.priceperDay = priceperDay;
		this.taxService =taxService;
	}
	
	
	public void processInvoice(CarRental carRental) {
		
		double minutes =  Duration.between(carRental.getStart(),carRental.getFinish()).toMinutes();
		double hours = minutes/60.0;
		
		double basicPayment;
		
		if(hours<=12) {
			
			basicPayment = priceperHour*Math.ceil(hours);
		}
		else {
			
			basicPayment = priceperDay*Math.ceil(hours/24.00);

		}

		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment,tax));
		
	}
}
	
	
