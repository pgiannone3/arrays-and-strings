package combinations.of.positive.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class CombinationsOfPositiveNumbersTest {

    @ParameterizedTest
    @MethodSource("provideInputAndExpectedList")
    void testUniquePathsRecursive_returnsCorrectNumberOfPathsForGivenGridSize(int input, List<List<Integer>> expected) {
        var sumCombination = new CombinationsOfPositiveNumbers();
        var result = sumCombination.findCombinations(input);
        Assertions.assertEquals(result, expected);
    }


    private static Stream<Arguments> provideInputAndExpectedList() {
        return Stream.of(
                Arguments.of(1, List.of(List.of(1))),
                Arguments.of(2, List.of(List.of(1, 1), List.of(2))),
                Arguments.of(3, List.of(List.of(1, 1, 1), List.of(1, 2), List.of(3))),
                Arguments.of(4, List.of(List.of(1, 1, 1, 1), List.of(1, 1, 2), List.of(1, 3), List.of(2,2), List.of(4))));
    }
}