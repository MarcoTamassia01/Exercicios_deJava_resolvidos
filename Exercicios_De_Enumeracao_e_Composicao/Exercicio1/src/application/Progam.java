package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;



public class Progam {

	public static void main(String[] args) throws ParseException {
	
	Locale.setDefault(Locale.US);	
	Scanner sc = new Scanner(System.in);
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	
		
	System.out.print("Enter department's name:");
	String departname =sc.nextLine();
	System.out.println("Enter Worker data: ");
	System.out.print("Name:");
	String workername = sc.nextLine();
	System.out.print("Level:");
	String workerlevel = sc.nextLine();
	System.out.print("Base Salary:");
	Double workerbasesalary = sc.nextDouble();
	
	Worker work = new Worker(workername, WorkerLevel.valueOf(workerlevel), workerbasesalary, new Department(departname));
		
		
	System.out.print("How many contracts this worker?");
	int n =sc.nextInt();
	System.out.println();
	
	for(int i=1;i<=n;i++) {
		
		System.out.println("Enter contract #"+ i +" data: ");	
		System.out.print("Date (DD/MM/YYYY):");
		Date contractdate = sdf.parse(sc.next());
		
		System.out.print("Value per hour: ");
		Double value =sc.nextDouble();
		
		System.out.print("Duration (hours): ");
		int  duration =sc.nextInt();
		
		HourContract contract = new HourContract(contractdate,value,duration);
		//chamo a função adicionando o contrato como argumento
		work.addContract(contract);
		System.out.println();
	}
		
		
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthandyear = sc.next();
		int month = Integer.parseInt(monthandyear.substring(0, 2));
		int year = Integer.parseInt(monthandyear.substring(3));
	
		
		
		
		System.out.println("Worker name: "+work.getName());
		System.out.println("Department: "+work.getDepartment().getName());
		System.out.println("Income for "+ monthandyear+": "+String.format("%.2f",work.income(year, month)));
		
		
		
		
		
		
		
		
		work.income(year, month);
		
		 
	
	
	
	
	
	
	
	
		
		
		sc.close();
		

	}

}
