package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class UsedProduct extends Product{
	
	private LocalDate manufactureDate;
	
	public UsedProduct() {
		
	}

	public UsedProduct(String name, double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		return name + " (used) $ " + String.format("%.2f",price)
		+ " (Manufacture Date: " + manufactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
		+")";
	}
	
	
	
}
