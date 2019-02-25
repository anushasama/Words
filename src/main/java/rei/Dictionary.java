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
		
		String dictionaryURL = "https://raw.githubusercontent.com/anushasama/Words/master/src/main/resources/words";
		
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
	
	static boolean isEngilsh(String word) {
		Boolean status = false;
		Wiktionary wiktionary = new Wiktionary(DB_PATH, Language.GERMAN);
		wiktionary.addWiktionary(DB_PATH, Language.English);
		wiktionary.setWordLanguage(Language.German);
		List<WiktionaryWord> wordList = wiktionary.getWords(word);
		
		return status;
		
	}
	
	
	
}
