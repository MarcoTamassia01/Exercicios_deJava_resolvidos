package entities;

public class Individual extends TaxPayer{

	private double healthExpenditures;
	
	public Individual() {
		super();
	}
	
	public Individual(String name, double anualIncome, double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double tax() {
		if(anualIncome<20000) {
			return anualIncome*0.15-(healthExpenditures/2.0);
		}
		else {
			return anualIncome*0.25-(healthExpenditures/2.0);
		}
	}

}
