package rei;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SearchWords {
	
	public static String getInput() {
		System.out.println("Enter string: ");
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();
		return inputStr.toLowerCase();
	}

	
	public static void main(String[] args) throws IOException, InterruptedException {

		String str = getInput();
		
		// creating a new dictionary object
		Dictionary dictionary = new Dictionary();

		// creating place holder sets
		Set<String> finalStrings = new HashSet<String>();
		Set<String> allPermutations = new HashSet<String>();
		Set<String> allCombinations = new HashSet<String>();

		//getting permutations
		Permutations.permutations("", str, allPermutations);

		//getting combination for each permutation
		allPermutations.forEach(word -> {
			Permutations.combinations(allCombinations, word, word.length());
		});

		// adding both perms and comb into final set
		finalStrings.addAll(allPermutations);
		finalStrings.addAll(allCombinations);

		//stroing in sorted array.
		ArrayList<String> sortedWords = new ArrayList<String>(finalStrings);
		Collections.sort(sortedWords);

		//for each word in sortedwords we are checking the word is englishword 
		//or not in a dictionary and storing result in status and print word if 
		//status is true
		System.out.println("Given words in dictionary are:");
		sortedWords.forEach(word -> {
			Boolean status = false;

			try {
				status = dictionary.isEnglishWord(word);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (status) {
				System.out.println(word);
			}

		});
		
		
	}
	
	
}