package rei;

import java.io.IOException;
import java.util.Scanner;

public class FindingWords {

	public static void main(String[] args) throws IOException {
		
		 Scanner in = new Scanner(System.in);
		 System.out.println("Enter a String: ");
		 String input = in.nextLine();
		  
		   
		  Boolean realWord = Dictionary.isEnglishWord(input);
		  
		  if(realWord) {
			  System.out.println("Given String exists in dictionary");
		  } else {
			  System.out.println("Given String doesn't exists in dictionary");
		  }
		  
		 //Dictionary.isEnglishWord(input);
	
	}
	
}
