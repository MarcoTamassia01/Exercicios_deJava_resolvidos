package entities;

public class ImportedProduct extends Product{
	
	private double customsFree;
	
	public ImportedProduct() {
		
	}

	public ImportedProduct(String name, double price, double customsFree) {
		super(name, price);
		this.customsFree = customsFree;
	}

	public double getCustomsFree() {
		return customsFree;
	}

	public void setCustomsFree(double customsFree) {
		this.customsFree = customsFree;
	}
	
	public double totalPrice() {
		return price+customsFree;
	}
	
	@Override
	public String priceTag() {
		return name + " $ " + String.format("%.2f",totalPrice()) 
		+ " Customs fee: $ "+ String.format("%.2f",getCustomsFree());
	}
	

}
