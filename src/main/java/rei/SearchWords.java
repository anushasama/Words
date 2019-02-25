package rei;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SearchWords {
    public static void main(String[] args) {
        String str = "working";

        SearchWords permutation = new SearchWords();

        Set<String> finalStrings = new HashSet<>();
        Set<String> allPermutations = new HashSet<>();
        Set<String> allCombinations = new HashSet<>();

        permutation.permute("", str, allPermutations);

        allPermutations.forEach(word -> {
            SubString(allCombinations, word, word.length());
        });

        finalStrings.addAll(allPermutations);
        finalStrings.addAll(allCombinations);

        ArrayList sortedWords = new ArrayList(finalStrings);
        Collections.sort(sortedWords);

        sortedWords.forEach(word -> {
            System.out.println(word);
        });
    }

    public static void SubString(Set<String> allCombinations, String str, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                allCombinations.add(str.substring(i, j));
                allCombinations.add(str.substring(i, j));
            }
        }

    }

    void permute(String prefixString, String s, Set<String> set) {
        int n = s.length();

        if (n == 0) {
            if (!set.contains(prefixString)) {
                set.add(prefixString);
            }
        } else {
            for (int i = 0; i < n; i++) {
                permute(prefixString + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n), set);
            }
        }
    }
}