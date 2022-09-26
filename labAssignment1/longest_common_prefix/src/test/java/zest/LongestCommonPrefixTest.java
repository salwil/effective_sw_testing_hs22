package zest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonPrefixTest {
    LongestCommonPrefix lcp = new LongestCommonPrefix();

    private static Stream<Arguments> commonPrefix() {
        return Stream.of(
                Arguments.of(new String[]{"abc", "acd"}, "a"),
                Arguments.of(new String[]{"abcd", "abc", "ab"}, "ab"),
                Arguments.of(new String[]{"b", "b"}, "b"),
                // The three test cases below are enough for branch and mutation coverage,
                // but we should add some more variants and corner test cases:
                Arguments.of(new String[]{"abc", "abd"}, "ab"),
                Arguments.of(new String[]{"b"}, "b"),
                Arguments.of(new String[]{"bc", "b"}, "b"),
                Arguments.of(new String[]{"abc", "abc", "abc"}, "abc")
        );
    }

    private static Stream<Arguments> noCommonPrefix() {
        return Stream.of(
                Arguments.of(new String[]{"abc", "xyz"}, ""),
                Arguments.of(new String[]{"bcd", "a"}, ""),
                Arguments.of(new String[]{"abc", ""}, ""),
                // The three test cases below are enough for branch and mutation coverage,
                // but I prefer to add one more:
                Arguments.of(new String[]{"a", "bcd"}, "")
        );
    }

    private static Stream<Arguments> emptyInputs() {
        return Stream.of(
                Arguments.of(new String[]{""}, ""),
                Arguments.of(null, ""),
                Arguments.of(new String[]{}, "")
        );
    }

    @ParameterizedTest
    @MethodSource("commonPrefix")
    void longestCommonPrefix(String[] strs, String expected) {
        assertEquals(lcp.longestCommonPrefix(strs), expected);
    }

    @ParameterizedTest
    @MethodSource("noCommonPrefix")
    void noCommonPrefix(String[] strs, String expected) {
        assertEquals(lcp.longestCommonPrefix(strs), expected);
    }

    @ParameterizedTest
    @MethodSource("emptyInputs")
    void noCommonPrefixEmptyInputs(String[] strs, String expected) {
        assertEquals(lcp.longestCommonPrefix(strs), expected);
    }
}
