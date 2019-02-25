package rei;

import java.util.Set;

public class Permutations {
	
	public static void combinations(Set<String> allCombinations, String str, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				// System.out.println(str.substring(i,j));
				allCombinations.add(str.substring(i, j));
			}
		}

	}
	public static void permutations(String prefixString, String s, Set<String> set) {
		int n = s.length();

		if (n == 0) {
			if (!set.contains(prefixString)) {
				// System.out.println(prefixString);
				set.add(prefixString);
			}
		} else {
			for (int i = 0; i < n; i++) {
				permutations(prefixString + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n), set);
			}
		}
	}

}
