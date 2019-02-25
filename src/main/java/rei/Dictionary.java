package rei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {

	final static String dictionaryURL = "https://docs.oracle.com/javase/tutorial/collections/interfaces/examples/dictionary.txt";

	static Set<String> dictionaryList = new HashSet<String>();

	Dictionary() throws IOException {

		dictionaryList = getDictionary();
		for (String s : dictionaryList) {
		    System.out.println(s);
		}

	}

	Set<String> getDictionary() throws IOException {
		URL dictionary = new URL(dictionaryURL);
		URLConnection dictCon = dictionary.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(dictCon.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			this.dictionaryList.add(in.readLine());
		}
		in.close();
		return dictionaryList;

	}

	static boolean isEnglishWord(String word) throws IOException {

		Boolean status = false;

		dictionaryList.contains(word);

		for (String item : dictionaryList) {
			if (item.equals(word)) {
				status = true;
				break;
			}
		}

		return status;

	}

}
