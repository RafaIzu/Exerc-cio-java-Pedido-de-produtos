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
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date moment=new Date();
		System.out.println("Enter client data: ");
		System.out.print("Name:");
		String nameClient=sc.nextLine();
		System.out.print("Email: ");
		String email=sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate=sdf1.parse(sc.next());
		sc.nextLine();
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status=sc.nextLine();
		
		Order order=new Order(moment,
				OrderStatus.valueOf(status), 
				new Client(nameClient, email, birthDate));
		
		
		System.out.println("How many items to this order?");
		int numItems=sc.nextInt();
		for(int i=0;i<numItems;i++) {
			System.out.println("Enter #"+(i+1)+" item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameProduct=sc.nextLine();
			System.out.print("Product Price: ");
			double price=sc.nextInt();
			System.out.print("Quantity: ");
			int quantity=sc.nextInt();
			OrderItem orderitem=new OrderItem(quantity,
					price, new Product(nameProduct, price));
			order.addItem(orderitem);
				
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println("Order moment:"+sdf2.format(order.getMoment()));
		System.out.println("Order status:"+order.getStatus());
		System.out.println("Client: "+order.getClient().toString());
		System.out.println("Order items:");
		System.out.println(order.toString());
		System.out.println("Total price: $"+order.total());
		
		sc.close();
		

	}

}
