package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.User;

public class Program {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br  = new BufferedReader(new FileReader(path))){
			
			Set<User> set = new HashSet<>();
			
			String line =br.readLine();
			while (line!=null) {
				
				String [] fields = line.split(" ");
				String userName = fields[0];
				
				Date moment = Date.from(Instant.parse(fields[1]));
				 
				set.add(new User(userName, moment));
				
				line = br.readLine();
				
			}
			
			System.out.println("Total Users: " + set.size());
			

		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
			
		}
		sc.close();
	}

}
