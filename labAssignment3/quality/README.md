<!--NO_HARDWRAPS-->

# Instructions

This exercise consists of analysing tests [^1] from the backend of a project[^2] that implements a card game 
application (written in the course of the IFI SoPra Module in spring 2022). Write your opinion about the
structure of the tests and two specific test classes by answering the following questions.

1. What do you think about how the test suites are structured at highlevel? What are advantages of structuring the test suites the way they are, what are disadvantages?
8. What is the purpose of the classes in the util folder? In what terms do they contribute to better test code quality?
3. Have a look at the `integration/CardEventHandlerTest`.  
   a) What would you have to change in the `play_last_card_new_round_new_match` test to make a unittest instead of an integration test out of it?  
   b) Why wouldn't it make sense to convert this test into a unittest?
4. Have a look at the `integration/CardValidatorTest`  
   a) In what terms is the `playing_card_with_not_active_turn_throws_error` test a good test and where do you see potential for improval?  
   b) Would it make sense to convert this test into a unittest? Justify your answer.

Write your answers in a `answer.md` file that you put in this folder.

[^1]: https://github.com/sopra-fs22-group-36/screw-your-neighbor-server/tree/main/src/test/java/ch/uzh/ifi/hase/soprafs22/screwyourneighborserver  
[^2]: https://github.com/sopra-fs22-group-36/screw-your-neighbor-server
