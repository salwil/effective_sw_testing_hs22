package zest;

import net.jqwik.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MaxLongTest {

    private final MaxLong maxLong = new MaxLong();

    @Property
    void aIsMax(
            @ForAll ("maxValues") long max,
            @ForAll ("notMaxValues") long notMax,
            @ForAll ("notMaxValues") long otherNotMax) {
        assertTrue(maxLong.max(max, notMax, otherNotMax) == max);
    }

    @Property
    void bIsMax(
            @ForAll ("maxValues") long max,
            @ForAll ("notMaxValues") long notMax,
            @ForAll ("notMaxValues") long otherNotMax) {
        assertTrue(maxLong.max(notMax, max, otherNotMax) == max);
    }

    @Property
    void cIsMax(
            @ForAll ("maxValues") long max,
            @ForAll ("notMaxValues") long notMax,
            @ForAll ("notMaxValues") long otherNotMax) {
        assertTrue(maxLong.max(notMax, otherNotMax, max) == max);
    }

    // Small ranges are chosen such that not too many combinations are possible i.e. combinations like all values
    // are the same or two values are the same are covered.

    @Provide
    private Arbitrary<Long> maxValues () {
        return Arbitraries.oneOf(
                Arbitraries.oneOf(
                        Arbitraries.longs().between(2L, 5L)
                )
        );
    }

    @Provide
    private Arbitrary<Long> notMaxValues () {
        return Arbitraries.oneOf(
                Arbitraries.oneOf(
                        Arbitraries.longs().between(-2L, 2L)
                )
        );
    }

    @Test
    void largestPossibleValue ()
    {
        assertTrue(maxLong.max(Long.MAX_VALUE, 8, 3) == Long.MAX_VALUE);
    }

    @Test
    void smallestPossibleValue ()
    {
        assertTrue(maxLong.max(Long.MIN_VALUE, 8, 3) == 8);
    }

    // Note: it's not possible (and also not necessary) to achieve 100% mutation coverage for this task. The
    // changed conditional boundary mutants will survive, but that's ok, because the program would also be
    // correct, when the conditions were b >= a instead of b > a resp. c >= a instead of c > a.
}