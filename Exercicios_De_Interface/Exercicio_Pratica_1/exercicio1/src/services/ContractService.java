package services;

import java.time.LocalDate;


import entities.Contract;
import entities.Installment;

public class ContractService {
	
	
	private OnlinePaymentService onlinePaymentService;


	public ContractService() {
		
	}
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	

	public void processContract(Contract contract, Integer months) {
		
		
		double basicQuota = contract.getTotaValue() / months;		
		
		for(int i=1; i<= months;i++) {
			
			 LocalDate dueDate = contract.getDate().plusMonths(i);
			
			 double interest = onlinePaymentService.interest(basicQuota, i);
			 double fee = onlinePaymentService.paymentFee(basicQuota + interest);
			 double quota = basicQuota + interest + fee;
		
			
			contract.getInstallments().add(new Installment(dueDate, quota));
			
	
		}
			
	}

}