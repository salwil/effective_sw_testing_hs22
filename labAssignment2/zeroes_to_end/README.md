<!--NO_HARDWRAPS-->

# Instructions

For the following problem and its implementation, you have to (recommended: follow the order below):

1. Use **property-based testing** techniques to derive tests for this
method, using [jqwik](https://jqwik.net/) as a platform. In the documentation
of the tests (e.g., javadoc) and the naming of the methods/tests, it must be
clear what your rationale was behind your testing decision.
2. Use **structural testing** techniques to augment your test suite. You should achieve the highest possible (ideally, 100%) branch+condition coverage.

Automate the test cases as **JUnit5** test methods, by filling in the example test class located in the folder `src/test/java/zest`.

You find the implementation of the problem's solution in the folder `src/main/java/zest`.

---

# Problem: Remove Occurrences

(Inspired by [Apache Commons Lang: long max](https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/ArrayUtils.html#removeAllOccurrences-char:A-char-))

## Description

The max method from Apache Commons Lang gets the maximum of three long values and returns it.

### Constraints
- 2<sup>63</sup> <= a <= 2<sup>63</sup> -1
- 2<sup>63</sup> <= b <= 2<sup>63</sup> -1
- 2<sup>63</sup> <= c <= 2<sup>63</sup> -1

### Examples
#### Example 1

**Input**:
```
3, 5.41, 8
```

**Output**:
```
8
```

#### Example 2

**Input**:
```
-8, -5, -3
```

**Output**:
```
-3
```
#### Example 3

**Input**:
```
-8, 2.41, 2.41
```

**Output**:
```
2.41
```



