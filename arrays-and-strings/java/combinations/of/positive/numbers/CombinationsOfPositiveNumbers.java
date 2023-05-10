package combinations.of.positive.numbers;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfPositiveNumbers {

    public List<List<Integer>> findCombinations(int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        findCombinations(targetSum,combination, 1, result);
        return result;
    }


    private static void findCombinations(int targetSum, List<Integer> combination, int start, List<List<Integer>> result) {

        if (targetSum == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= targetSum; i++) {
            combination.add(i);
            findCombinations(targetSum - i, combination, i, result);
            combination.remove(combination.size() - 1);
        }
    }
}
