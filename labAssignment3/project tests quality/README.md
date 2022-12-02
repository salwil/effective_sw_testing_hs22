<!--NO_HARDWRAPS-->

# Instructions

This exercise consists of analysing tests from a project, written in the course of the IFI SoPra Module in spring 2022. Write your opinion about two test classes by answering the following questions.

1. Have a look at the `CardEventHandlerTest`.
    a. What would you have to change in the `play_last_card_new_round_new_match` test to make a unittest instead of an integration test out of it?
    b. Why wouldn't it make any sense to convert this test into a unittest?
2. Have a look at the `CardValidatorTest`
    a. In what terms is the `playing_card_with_not_active_turn_throws_error` test a good test and where do you see potential for improval?
    b.
What do you like about this test and what would you do differently?
3. How could the class under test be redesigned to make testing easier?
4. Do you see potential code quality issues that could lead to decreased code quality when the test further evolves?
5. What is the purpose of the classes in the util folder? In what terms do they contribute better test code quality?

Write your answers in a `answer.md` file that you put in this folder.

[1] https://github.com/sopra-fs22-group-36/screw-your-neighbor-server/tree/main/src/test/java/ch/uzh/ifi/hase/soprafs22/screwyourneighborserver
[2] https://github.com/sopra-fs22-group-36/screw-your-neighbor-server