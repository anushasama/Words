package rei;

import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PermutationsTest {

	@Test
	public void validPermutation() {

		Set<String> allPermutations = new HashSet<String>();
		String input = "working";
		String output = "gnikrow";
		Permutations.permutations("", input, allPermutations);
		assertTrue(allPermutations.contains(output));
	
	}
	
	@Test
	public void notAValidPermutation() {

		Set<String> allPermutations = new HashSet<String>();
		String input = "working";
		String output = "king";
		Permutations.permutations("", input, allPermutations);
		assertTrue(!allPermutations.contains(output));
	
	}

	@Test
	public void validCombinations() {
		Set<String> allCombinations = new HashSet<String>();
		String input = "work";
		String output = "or";
		Permutations.combinations(allCombinations, input, input.length());
		assertTrue(allCombinations.contains(output));
	
	}
	
	@Test
	public void notValidCombinations() {
		Set<String> allCombinations = new HashSet<String>();
		String input = "work";
		String output = "krow";
		Permutations.combinations(allCombinations, input, input.length());
		assertTrue(!allCombinations.contains(output));
	
	}

}
