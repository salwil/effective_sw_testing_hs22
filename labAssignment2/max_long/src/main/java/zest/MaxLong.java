package zest;

/**
 * Solution inspired by: https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/math/NumberUtils.html#max-long-long-long-
 */
class MaxLong {

public static long max(long a, final long b, final long c) {
        if (b > a) {
            a = b;
        }
        if (c > a) {
            a = c;
        }
        return a;
    }
}