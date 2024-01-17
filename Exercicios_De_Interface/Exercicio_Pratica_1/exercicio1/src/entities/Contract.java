package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	
	private Integer number;
	private LocalDate date;
	private double totaValue;
	
	private List<Installment> installments = new ArrayList<>();
	
	public Contract() {
	}

	public Contract(Integer number, LocalDate datecontract, double totaValue) {
		this.number = number;
		this.date = datecontract;
		this.totaValue = totaValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getTotaValue() {
		return totaValue;
	}

	public void setTotaValue(double totaValue) {
		this.totaValue = totaValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}
	
}
