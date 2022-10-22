package zest;

import net.jqwik.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Zeroes2EndTest {

    Zeroes2End zeroes2End = new Zeroes2End();

    @Property
    void withoutZeroes(
            @ForAll("arrayWithoutZeroes") int[] array) {
        assertThat(array == zeroes2End.pushZeroesToEnd(array, array.length));
    }

    @Property
    void withZeroes(
            @ForAll("arrayWithZeroes") int[] array) {
        int[] result = zeroes2End.pushZeroesToEnd(array, array.length);
        assertThat(result).contains(array);
        //assertThat(result[result.length-1] == 0);
    }

    // Small ranges are chosen such that not too many combinations are possible i.e. combinations like all values
    // are the same or two values are the same are covered.

    @Provide
    private Arbitrary<int[]> arrayWithoutZeroes () {
        Arbitrary<Integer> integerArbitrary = Arbitraries.integers().between(1, 10);
        Arbitrary<int[]> arrayArbitrary = integerArbitrary.array(int[].class).ofMinSize(0).ofMaxSize(5);
        RandomGenerator<int[]> generator = arrayArbitrary.generator(1);
        return arrayArbitrary;
    }

    @Provide
    private Arbitrary<int[]> arrayWithZeroes () {
        Arbitrary<Integer> integerArbitrary = Arbitraries.integers().between(0, 10);
        Arbitrary<int[]> arrayArbitrary = integerArbitrary.array(int[].class).ofMinSize(0).ofMaxSize(5);
        RandomGenerator<int[]> generator = arrayArbitrary.generator(1);
        return arrayArbitrary;
    }
}
