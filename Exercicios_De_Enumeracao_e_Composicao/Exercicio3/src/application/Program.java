package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
	
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	System.out.println("Enter client data:");
	System.out.print("Name:");
	String nameclient = sc.nextLine();
	System.out.print("Email:");
	String email = sc.nextLine();
	System.out.print("Birth date (DD/MM/YYYY):");
	Date datebirth = sdf.parse(sc.next());
	
	Client client01 = new Client(nameclient,email,datebirth);
	
	System.out.println("Enter the order datta: ");
	
	System.out.print("Status: ");
	OrderStatus status = OrderStatus.valueOf(sc.next());
	
	
	Order order = new Order(new Date(),status,client01); 
	
	System.out.print("How many items to this order?");
	int n =sc.nextInt();
	
	for(int i=1;i<=n;i++) {
		System.out.println("Enter #"+i+" item data: ");
		System.out.print("Product Name: ");
		sc.nextLine();
		String productname =sc.nextLine();
		System.out.print("Product Price: ");
		Double priceproduct =sc.nextDouble();
		
		Product product = new Product(productname, priceproduct);
		
		System.out.print("Quantity: ");
		Integer quant =sc.nextInt();
		
		OrderItem orderItem = new OrderItem(quant, priceproduct,product);
		
		order.addItem(orderItem);
		
	}
		System.out.println();
		System.out.println("ORDER SUMARY: ");
		System.out.println(order);
		
	sc.close();
	}

}
