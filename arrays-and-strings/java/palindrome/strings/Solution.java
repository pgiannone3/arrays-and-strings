package palindrome.strings;

public class Solution {

    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase().replace(" ", "").replaceAll("[^a-zA-Z\\d\\s]", "");

        for(int i = 0; i<s1.length()/2; i++) {
            var firstChar = s1.charAt(i);
            var lastChar = s1.charAt(s1.length()-1-i);

            if(firstChar != lastChar) {
                return false;
            }
        }
        return true;
    }
}
