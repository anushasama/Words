package rei;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SearchWords {
	
	public static void main(String[] args) throws IOException, InterruptedException {

		String str = getInput();
		
		// creating a new dictionary object
		Dictionary dictionary = new Dictionary();

		SearchWords permutation = new SearchWords();

		Set<String> finalStrings = new HashSet<String>();
		Set<String> allPermutations = new HashSet<String>();
		final Set<String> allCombinations = new HashSet<String>();

		Permutations.permutations("", str, allPermutations);

		allPermutations.forEach(word -> {
			Permutations.combinations(allCombinations, word, word.length());
		});

		finalStrings.addAll(allPermutations);
		finalStrings.addAll(allCombinations);

		ArrayList<String> sortedWords = new ArrayList<String>(finalStrings);
		Collections.sort(sortedWords);

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
	
	public static String getInput() {
		System.out.println("Enter string: ");
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();
		return inputStr.toLowerCase();
	}

}