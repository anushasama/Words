package rei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Dictionary {
	
	static boolean isEnglishWord(String word) throws IOException {
			 
		Boolean status = false;
		
		String dictionaryURL = "https://docs.oracle.com/javase/tutorial/collections/interfaces/examples/dictionary.txt";
		
		URL dictionary = new URL(dictionaryURL);
		URLConnection dictCon = dictionary.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(dictCon.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
        	
        	if ( inputLine.equals(word)) {
        		//System.out.println(inputLine + "  " + word);
        		status = true;
        		break;
        	}
        }
       in.close();
			
       return status;
			
	}
	
	
	
}
