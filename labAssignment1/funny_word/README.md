<!--NO_HARDWRAPS-->

# Instructions

For the following problem and its implementation, you have to (recommended: follow the order below):

1. Use **specification-based testing** techniques to derive tests for this method. In the documentation of the tests (e.g., javadoc) it must be clear what you considered as boundaries and which specific points you decided to test and why.
2. Use **structural testing** techniques to augment your test suite. You should achieve the highest possible (ideally, 100%) branch+condition coverage.

Automate the test cases as **JUnit5** test methods, by filling in the example test class located in the folder `src/test/java/zest`.

You find the implementation of the problem's solution in the folder `src/main/java/zest`.

The tests are going to be evaluated according to the points 1 and 2, also by using the tool [Andy](https://github.com/cse1110/andy). You can find examples of problems and solutions for this kind of tests (specification-based and structural), as well as see Andy in action, [here](https://github.com/cse1110/assignments/tree/main/domain-and-structural-testing).

---

# Problem: Funny Word Check
(Inspired by [GfG's Funny String](https://www.geeksforgeeks.org/funny-string/))

## Description

Reverse the given string. Iterate through each character of that string, compare the absolute difference in the ASCII values of the characters at positions 0 and 1, 1 and 2, 2 and 3 and so on to the end. If the list of absolute differences is the same for both strings, they are funny otherwise not.

### Example 1

**Input**: `HKMNPS`

**Output**: `true`

**Explanation**:  
Let r be the reverse of original string s  
`s = "HKMNPS`  
`r = "SPNMKH"`  
`|H-K| = 3  = |S-P|`  
`|K-M| = 2  = |P-N|`  
`|M-N| = 1  = |N-M|`  
`|N-P| = 2  = |M-K|`  
`|P-S| = 3  = |K-H|`  
Since each comparison is equal so given string is funny.

### Example 2

**Input**: `bdwy`

**Output**: `false`

### Constraints
-   `1 <= n <= 10`, n = length of the input String
