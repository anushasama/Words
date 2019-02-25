package rei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;

public class Dictionary {
	
		final static String dictionaryURL = "https://docs.oracle.com/javase/tutorial/collections/interfaces/examples/dictionary.txt";	
		static ArrayList<String> dictionaryList = new ArrayList();	
		Dictionary() throws IOException {
			
			dictionaryList = getDictionary();
	
		}
	
		ArrayList<String> getDictionary() throws IOException {
			
			URL dictionary = new URL(dictionaryURL);
			URLConnection dictCon = dictionary.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(dictCon.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				this.dictionaryList.add(inputLine);
			}
			
			in.close();
			ArrayList<String> sortedDictionaryList = new ArrayList<String>(this.dictionaryList);
			Collections.sort(sortedDictionaryList);
			return sortedDictionaryList;
		}
		
		boolean isEnglishWord(String word) throws IOException {	
			Boolean status = false;
			for (String item : dictionaryList) {
				if (item.equals(word)) {
					status = true;
					break;
				}
			}
			return status;
		}
	}
