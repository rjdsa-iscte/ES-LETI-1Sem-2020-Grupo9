package GUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Rule_file_handler {
	public static  File file;
	
	
	public static File create_new() {
	File temp = new File ("rules.txt");
	
	try {
		if (temp.createNewFile())
		{
			file =temp;
		    System.out.println("File is created!");
		} else {
		    System.out.println("File already exists, please load it!");
		}
	} catch (IOException e) {
		System.out.println("An error has occured!");
		e.printStackTrace();
	}
	return temp;
	}
	
	public static void load_file() {
		file = new File ("rules.txt");
		//String [][] matrix = new String [4][4];
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			
	            for ( int row = 0; sc.hasNextLine(); row ++ )
	                for ( int column = 0; column <= 4; column ++ ) {
	                   	String current_word = sc.next();
	                	System.out.println("line:" + row + "  column:" + column + "  valor:"  + current_word );
	                 //matrix [ row ] [ column ] = current_word;
	                 
	                     
	                }
	             
	    		
			
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
} 


