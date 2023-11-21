package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comment;
import entities.Post;

public class Program {

	public static void main(String[] args) throws ParseException {

	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
	Comment c1 = new Comment("Have a Nice Trip");
	Comment c2 = new Comment("Wow that's awesome!");
	
	Post post1 = new Post(sdf1.parse("21/06/2018 13:05:44"),
			"Traveling to New Zeland",
			"I'm going to visit this wonderful country!" ,
			12);
		
	post1.addComent(c1);
	post1.addComent(c2);
	
	System.out.println(post1);
	System.out.println();
	
	Comment c3 = new Comment("Good night");
	Comment c4 = new Comment("May the Force be with you");
	
	Post post2 = new Post(sdf1.parse("28/07/2018 23:14:19"),
			"Good night guys",
			"See you tomorrow" ,
			5);
		
	post2.addComent(c3);
	post2.addComent(c4);
	
	System.out.println(post2);
			

	}

}
