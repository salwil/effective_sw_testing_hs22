<!--NO_HARDWRAPS-->

# Instructions

For the following problem and its implementation, you have to follow the order below:

Use [Mockito](https://site.mockito.org/) **test doubles** for testing the warehouse project. In the documentation
of the tests (e.g., javadoc) and the naming of the methods/tests, it must be clear what your rationale was behind your testing decision.

Automate the test cases as **JUnit5** test methods, by filling in the example test class located in the folder `src/test/java`.

You find the (incomplete) implementation of the warehouse project in the folder `src/main/java/`.

---

# Problem: Warehouse

(Inspired by [Mockito Exercise](https://github.com/octo-technology-downunder/mockito-exercise))
# Exercise
Notice the structure of the project. Imagine that all the components that you have in `external` package are the one relying on some external service.
You have following tasks to accomplish:
1. Finish the implementation of `WareHouse`
2. Write one or more test cases for the `WareHouse` with following requirements:
- Use Mock or Stub or Spy to inject dependencies as per needed.
- Create a list of 5 products in your test and use it to test `processProducts` method.
- Test if `calculatePriceWithGST` of `GSTCalculator` is called 5 times.
- Test if `productRepository` is called with right method parameters
- Test if `EmailService` is called with right parameters

# Hints
- You have to add dependencies to the Gradle build file for using Mockito
- Completing the implementation of `WareHouse` includes also thoughts about code design that supports dependency injection