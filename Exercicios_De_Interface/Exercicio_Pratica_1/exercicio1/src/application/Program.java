package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
	System.out.println("Enter contract details: ");
	
	System.out.print("Number:");
	int numbercontract = sc.nextInt();
	
	
	System.out.print("Date (dd/MM/yyyy) :");
	sc.nextLine();
	LocalDate datecontract = LocalDate.parse(sc.next() , fmt);
	
	System.out.print("Value of contract: ");
	double value = sc.nextDouble();
	
	Contract contract = new Contract(numbercontract, datecontract, value);
	
	System.out.print("Enter the number of installments:");
	int numberinsta = sc.nextInt();
	
	ContractService contractService = new ContractService(new PaypalService());
	
	contractService.processContract(contract, numberinsta);
	
	System.out.println();
	System.out.println("Parcelas: ");
	
		
	for(Installment i : contract.getInstallments()) {
		System.out.println(i);
	}
		
		
	sc.close();	

	}

}
