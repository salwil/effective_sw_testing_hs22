package zest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesesTest {

    private final GenerateParentheses gp = new GenerateParentheses();

    private static Stream<Arguments> generateParentheses() {
        return Stream.of(
                Arguments.of(1, of("()")),
                Arguments.of(2, of("(())", "()()")),
                // The two test cases below are enough for the branch and mutation coverage,
                // but I think we should do some more variation:
                Arguments.of(3, of("((()))", "(()())", "(())()", "()(())", "()()()"))
        );
    }

    static Stream<Arguments> validInputs() {
        IntStream stream = IntStream.range(1, 9);
        Stream<Arguments> arguments = stream.mapToObj(argument -> Arguments.of(argument));
        return arguments;
    }

    @ParameterizedTest
    @MethodSource
    public void generateParentheses(int input, List<String> result) {
        assertEquals(gp.generateParentheses(input), result);
    }

    // For branch and mutation coverage no invalid inputs are required, still we should test it.
    @Test
    public void negativeInput() {
        assertThrows(NegativeArraySizeException.class, () -> gp.generateParentheses(-1));
    }

    @Test
    public void inputIsZero() {
        List<String> strings = gp.generateParentheses(0);
        assertEquals(strings, of(""));
    }

    // Finally lets run the method with some random inputs:
    @ParameterizedTest
    @MethodSource("validInputs")
    public void generateParanthesesRandomInputs(int input) {
        assertTrue(gp.generateParentheses(input).size() > 0);
    }
}