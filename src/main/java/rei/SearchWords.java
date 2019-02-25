package rei;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SearchWords {
    public static void main(String[] args) throws IOException, InterruptedException {
    	
    	System.out.println("Enter string: ");
    	Scanner sc = new Scanner(System.in);
    	String inputStr = sc.nextLine();
    	
    	// Convert string to lowercase 
    	String str = inputStr.toLowerCase();
    	
    	// creating a new dictionary object
    	Dictionary dictionary = new Dictionary();
   
    	Thread.sleep(3000);
    	
    	

        SearchWords permutation = new SearchWords();

        Set<String> finalStrings = new HashSet<String>();
        Set<String> allPermutations = new HashSet<String>();
        final Set<String> allCombinations = new HashSet<String>();

        permutation.permute("", str, allPermutations);

        allPermutations.forEach(word -> {
            SubString(allCombinations, word, word.length());
        });

        //finalStrings.addAll(allPermutations);
        finalStrings.addAll(allCombinations);

        ArrayList<String> sortedWords = new ArrayList<String>(finalStrings);
        Collections.sort(sortedWords);

        sortedWords.forEach(word -> {
         	Boolean status = false;
			try {
				status = dictionary.isEnglishWord(word);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         	if(status) {
         		System.out.println("Given word is in dictionary " + word);
         	}
        });
    }

    public static void SubString(Set<String> allCombinations, String str, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
            	//System.out.println(str.substring(i,j));
                allCombinations.add(str.substring(i, j));
            }
        }

    }

    void permute(String prefixString, String s, Set<String> set) {
        int n = s.length();

        if (n == 0) {
            if (!set.contains(prefixString)) {
            	//System.out.println(prefixString);
                set.add(prefixString);
            }
        } else {
            for (int i = 0; i < n; i++) {
                permute(prefixString + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n), set);
            }
        }
    }
}