package check.two.string.arrays.are.equivalent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    /*
    Given two string arrays word1 and word2, return true if the two arrays represent the same string,
    and false otherwise.
    A string is represented by an array if the array elements concatenated in order forms the string.

    Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
    Output: true

    Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
    Output: false

    Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
    Output: true

    */

    @Test
    void areEqual_whenInputsAreEqual_shouldReturnTrue() {
        var solution = new Solution();
        Assertions.assertTrue(solution.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
    }

    @Test
    void areEqual_whenInputsAreNotEqual_1_shouldReturnFalse() {
        var solution = new Solution();
        Assertions.assertFalse(solution.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddegg"}));
    }

    @Test
    void areEqual_whenInputsAreEqual_1_shouldReturnTrue() {
        var solution = new Solution();
        Assertions.assertTrue(solution.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
    }

    @Test
    void areEqual_whenInputsAreNotEqual_shouldReturnFalse() {
        var solution = new Solution();
        Assertions.assertFalse(solution.arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
    }

}
