package zest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FunnyWordTest {

    private final FunnyWord funnyWord = new FunnyWord();

    public static Stream<Arguments> funnyWords() {
        return Stream.of(
                Arguments.of("HKMNPS"),
                Arguments.of("ABCDEEDCBA"),
                Arguments.of("QRHKMNPSIJ"),
                Arguments.of("XYZ"),
                Arguments.of("XY"),
                Arguments.of("ABCDEDCBA"));
    }

    /**
     * Inputs vary as few as possible and that we make the difference to a funny word
     * as small as possible (by only changing one single letter). That's how the chance
     * of catching boundary bugs increases.
     */
    public static Stream<Arguments> notFunnyWords() {
        return Stream.of(
                Arguments.of("RRHKMNPSIJ"),
                Arguments.of("QRHKMNPSII"),
                Arguments.of("RRHKNNPSII"),
                Arguments.of("RRHKMRRHKM"),
                Arguments.of("WYZ"),
                Arguments.of("ABCDEDCBB"));
    }

    /**
     * The first three tests are derived with structural testing
     */
    @ParameterizedTest
    @MethodSource("funnyWords")
    void isFunnyWord(String word) {
        assertTrue(funnyWord.checkFunny(word));
    }

    @ParameterizedTest
    @MethodSource("notFunnyWords")
    void isNotFunnyWord(String word) {
        assertFalse(funnyWord.checkFunny(word));
    }

    @Test
    void isNotFunnyWordBecauseTooLong() {
        assertFalse(funnyWord.checkFunny("ABCDEFEDCBA"));
    }

    /**
     * With the below tests, Andy's assessment is 100/100. Nevertheless, there are some tests that
     * might make sense, especially for corner cases (based on the specification).
     */
    @Test
    void isFunnyWordEmpty() {
        assertTrue(funnyWord.checkFunny(""));
    }

    @Test
    void isFunnyWordLength1() {
        assertTrue(funnyWord.checkFunny("Y"));
    }
}
