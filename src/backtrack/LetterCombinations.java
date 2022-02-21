package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two words, print all letter combinations in any order.
 *
 * str1 = "ab", str2 = "cd"
 * result = ["ac", "ad", "bc", "bd"]
 */

public class LetterCombinations {
    public static void main(String[] args) {
        String[] words = {"abc", "def"};

        List<String> result = letterCombinations(words);

        System.out.println(result);
    }

    public static List<String> letterCombinations(String[] words) {
        List<String> res = new ArrayList<>();
        backtrack(words, res, new StringBuilder(), 0);

        return res;
    }

    private static void backtrack(String[] words, List<String> res, StringBuilder memo, int index) {
        if (memo.length() == words.length) {
            res.add(memo.toString());
            return;
        } else {
            String allPossibleLetters = words[index];
            for (char ch: allPossibleLetters.toCharArray()) {
                memo.append(ch);
                backtrack(words, res, memo, index + 1);
                memo.deleteCharAt(memo.length() - 1);
            }
        }
    }
}
