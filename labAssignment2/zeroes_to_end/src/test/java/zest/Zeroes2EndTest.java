package zest;

import net.jqwik.api.*;
import net.jqwik.api.arbitraries.ArrayArbitrary;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Function;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Zeroes2EndTest {

    Zeroes2End zeroes2End = new Zeroes2End();

    @Test
    void boundariesExceedingReturnsEmpty() {
        assertThat(new int[0] == zeroes2End.pushZeroesToEnd(new int[0]));
        int[] array = {0,1,2,3,4,5,6,7,8,9,10};
        assertThat(new int[0] == zeroes2End.pushZeroesToEnd(array));
    }

    @Test
    void arrayWithZeroesCheckSameOrder() {
        int[] array = {0,1,0,2,3,4,5};
        int[] expectedResult = {1,2,3,4,5,0,0};
        assertThat(expectedResult == zeroes2End.pushZeroesToEnd(array));
    }

    @Property
    void arrayWithoutZeroes(
            @ForAll("arrayWithoutZeroes") int[] array) {
        assertThat(array == zeroes2End.pushZeroesToEnd(array));
    }

    @Property
    void arrayWithZeroes(
            @ForAll("arrayWithZeroes") Integer[] array) {
        int[] primitiveArray = Arrays.stream(array).mapToInt(value -> value).toArray();
        System.out.print(Arrays.toString( primitiveArray));
        int[] result = zeroes2End.pushZeroesToEnd(primitiveArray);
        System.out.println(Arrays.toString( result));
        assertThat(result).contains(primitiveArray);
        assertThat(result.length == 0 || result[primitiveArray.length-1] == 0);
    }

    @Provide
    private ArrayArbitrary<Integer, Integer[]> arrayWithZeroes () {
        // Specify the frequency of appearance of the values provided in the second element of the tuple.
        Arbitrary<Integer> integers = Arbitraries.frequency(
                Tuple.of(1, Arbitraries.just(0)),
                Tuple.of(1, Arbitraries.integers().between(1, 7))
        ).flatMap(Function.identity()); // flatten down the structure, map elements to themselves
        return integers.array(Integer[].class).ofMinSize(0).ofMaxSize(10);
    }

    @Provide
    private Arbitrary<int[]> arrayWithoutZeroes () {
        Arbitrary<Integer> integerArbitrary = Arbitraries.integers().between(1, 10);
        Arbitrary<int[]> arrayArbitrary = integerArbitrary.array(int[].class).ofMinSize(0).ofMaxSize(5);
        return arrayArbitrary;
    }
}
