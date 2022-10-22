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

# Problem: Move zeroes to end of array

(Inspired by [GfG's Move zeroes to end of array](https://practice.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article))

## Description

The method receives an array of random numbers and returns an array with the same values in the same
order but with all zeroes moved to the end of the array. If the given array is empty or has more than
10 elements, an empty array is returned.

### Constraints
`0 >= n >= 10 with n, length of input array`

### Examples
#### Example 1
**Input**:
```
{1, 2, 0, 4, 3, 0, 5, 0}
```

**Output**:
```
{1, 2, 4, 3, 5, 0, 0, 0}
```

#### Example 2
**Input**:
```
{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}
```

**Output**:
```
{}
```