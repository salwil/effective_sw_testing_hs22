package zest;

import net.jqwik.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxLongTest {

    private final MaxLong maxLong = new MaxLong();

    @Property
    void aIsMax(
            @ForAll ("maxValues") long max,
            @ForAll ("notMaxValues") long notMax,
            @ForAll ("notMaxValues") long otherNotMax) {
        assertEquals(max, maxLong.max(max, notMax, otherNotMax));
    }

    @Property
    void bIsMax(
            @ForAll ("maxValues") long max,
            @ForAll ("notMaxValues") long notMax,
            @ForAll ("notMaxValues") long otherNotMax) {
        assertEquals(max, maxLong.max(notMax, max, otherNotMax));
    }

    @Property
    void cIsMax(
            @ForAll ("maxValues") long max,
            @ForAll ("notMaxValues") long notMax,
            @ForAll ("notMaxValues") long otherNotMax) {
        assertEquals(max, maxLong.max(notMax, otherNotMax, max));
    }

    // Small ranges are chosen such that not too many combinations are possible so that combinations like all values
    // are the same or two values are the same are covered for sure.

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
        assertEquals(Long.MAX_VALUE, maxLong.max(Long.MAX_VALUE, 8, 3));
    }

    @Test
    void smallestPossibleValue ()
    {
        assertEquals(8, maxLong.max(Long.MIN_VALUE, 8, 3) );
    }

    // Note: it's not possible (and also not necessary) to achieve 100% mutation coverage for this task. The
    // changed conditional boundary mutants will survive, but that's ok, because the program would also be
    // correct, when the conditions were b >= a instead of b > a resp. c >= a instead of c > a.
}