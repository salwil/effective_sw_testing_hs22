package zest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseIntegerTest {

    private ReverseInteger revInt = new ReverseInteger();

    // Test on and off points.
    public static Stream<Arguments> positiveIntegers() {
        return Stream.of(
                // corner case derived with structural testing (kills mutant of line 12):
                Arguments.of(2147483641, 1463847412),
                Arguments.of(214748374, 473847412),
                // highest 32-bit integer:
                Arguments.of(0, 2147483647),
                // highest possible value that can be reversed:
                Arguments.of(2147447412, 2147447412)
        );
    }

    // Test on and off points.
    public static Stream<Arguments> negativeIntegers() {
        return Stream.of(
                // corner case derived with structural testing (kills mutant of line 13):
                Arguments.of(-2147483641, -1463847412),
                // lowest 32-bit integer:
                Arguments.of(0, -2147483648),
                //Arguments.of(0, -2147483647),
                // lowest possible value that can be reversed:
                Arguments.of(-2147447412, -2147447412)
        );
    }

    @Test
    void reverseIntOneDigit() {
        assertEquals(revInt.reverse(0), 0);
        assertEquals(revInt.reverse(1), 1);
    }

    @Test
    void reverseIntTwoDigits() {
        assertEquals(revInt.reverse(21), 12);
    }

    @Test
    void reverseIntWithZeroes() {
        assertEquals(revInt.reverse(210), 12);
        assertEquals(revInt.reverse(201), 102);
    }

    @ParameterizedTest
    @MethodSource("positiveIntegers")
    void reverseIntPositive(int expected, int input) {
        assertEquals(expected, revInt.reverse(input));
    }

    @ParameterizedTest
    @MethodSource("negativeIntegers")
    void reverseIntNegative(int expected, int input) {
        assertEquals(expected, revInt.reverse(input));
    }
}
