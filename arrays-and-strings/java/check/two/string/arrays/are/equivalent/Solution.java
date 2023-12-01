package check.two.string.arrays.are.equivalent;

public class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if(word1[0].charAt(0) != word2[0].charAt(0)) return false;

        if(findLastChar(word1) != findLastChar(word2)) return false;

        return String.join("", word1).equals(String.join("", word2));
    }


    private char findLastChar(String[] word) {
        String lastElement = word[word.length - 1];
        return lastElement.charAt(lastElement.length() - 1);
    }
}
