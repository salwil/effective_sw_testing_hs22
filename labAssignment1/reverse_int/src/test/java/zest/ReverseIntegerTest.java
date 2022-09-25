package zest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseIntegerTest {

    private ReverseInteger revInt = new ReverseInteger();

    @Test
    void reverseIntOneDigit() {
        assertEquals(revInt.reverse(0),0);
        assertEquals(revInt.reverse(1),1);
    }
    @Test
    void reverseIntTwoDigits() {
        assertEquals(revInt.reverse(21),12);
    }

    @Test
    void reverseIntWithZeroes() {
        assertEquals(revInt.reverse(210),12);
    }

    public static Stream<Arguments> maxIntegers() {
        return Stream.of(
                Arguments.of(0, 2147483647)
                //Arguments.of(214748364, 463847412),
                //Arguments.of(214748374, 473847412)
                //Arguments.of(463847412, 2147483647 / 10),
                //Arguments.of(563847412, 2147483647 / 10 + 1),
                //Arguments.of(0, 2147483647 + 1)
                //Arguments.of(0, 2147447417),
                //Arguments.of(2147447412, 2147447412)
        );
    }

    @ParameterizedTest
    @MethodSource("maxIntegers")
    void reverseIntMax(int expected, int input){
        assertEquals(expected, revInt.reverse(input));
    }

    public static Stream<Arguments> minIntegers() {
        return Stream.of(
                Arguments.of(-214748364, -463847412)
                //Arguments.of(-214748365, -563847412),
                //Arguments.of(-214748366, -663847412),
                //Arguments.of(0, -2147483648),
                //Arguments.of(0, -2147483648 - 1),
                //Arguments.of(0, -2147483647),
                //Arguments.of(-2147447412, -2147447412)
        );
    }

    @ParameterizedTest
    @MethodSource("minIntegers")
    void reverseIntMin(int expected, int input){
        assertEquals(expected, revInt.reverse(input));
    }
}
