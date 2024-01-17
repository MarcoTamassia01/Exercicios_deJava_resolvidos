package services;

public class PaypalService implements OnlinePaymentService{
	
	
	private static final double FEE_PERCENTAGE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01;
	
	public double paymentFee(double amount) {
		
		return amount * FEE_PERCENTAGE;
	}


	public double interest(double amount, Integer months) {
		
		return amount * MONTHLY_INTEREST * months;
	}

}
