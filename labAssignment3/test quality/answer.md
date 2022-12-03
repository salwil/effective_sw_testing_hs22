<!--NO_HARDWRAPS-->

# Solutions

1. What do you think about how the test suites are structured at highlevel? What are advantages of structuring the test suites the way they are, what are disadvantages?  
      *Answer: The taxonomy of the different test folders does not orient towards business logic, but rather
      towards implementation details. When a functionality changes, the related tests may be in various different test classes and even in different folders.
      Alternatively the tests could also be grouped aligned to the classes and methods they test.
      However the advantage of structuring the tests this way, is that for example the large tests are separated from the unittests. Integration tests can be
      easily omitted, for example during TDD phase, and be run only before deploying new code.*
2. What is the purpose of the classes in the `util` folder?  
*Answer: This folder contains builders for large objects. The game object is composed of many "sub-objects", like a matches, rounds, players etc.
The GameBuilder abstracts away the logic of creating and linking those objects together. The builders contribute to long-term
test code quality in terms of maintainability and understandability. They are an important tool to lower the hurdle for future tests can be
thanks to their simplicity and intuitive usage. When objects or the way how they are linked together evolve, the related changes have
to be adjusted only in the builder classes, and every test that uses the builders and does not create the objects it needs itself, will 
benefit from the changes immediately.*
3. Have a look at the `CardEventHandlerTest` (integration):  
   a) What would you have to change in the `play_last_card_new_round_new_match` test to make a unittest instead of an integration test out of it?  
   *Answer: We would have to mock all the repository objects (`gameRepository`, `matchRepository`, `gameRepository`) and inject them to the `CardEventHandler`
   object. Instead of doing assertions on the different repositories, we would check whether certain methods have been called with Mockito `verify`
   method for example.*  
   b) Why wouldn't it make any sense to convert this test into a unittest?  
   *Answer: Because the purpose of this class is to test whether the entities are saved correctly, after the execution of the `handleAfterSave`
   method. Converting it into a unittest would be possible theoretically but the test would be very tightly coupled to the method under test, because
   it would need a lot of knowledge about what happens inside this method for doing verifications on method calls.*
4. Have a look at the `CardValidatorTest` (integration):  
   a) In what terms is the `playing_card_with_not_active_turn_throws_error` test a good test and where do you see potential for improval?  
   *Answer: The name of the method is meaningful. It is obvious, what it tests, there is no closer explanation necessary. The test uses
   the object builder pattern for constructing the large game object. A weakness of the test is, that the assertion on the thrown exception is
   maybe a bit too sensitive. When only the formulation of the message is changed, the test will fail, even if the functionality itself works
   correctly.*  
   b) Would it make sense to convert this test into a unittest? Justify your answer.  
   *Answer: The way the card validation functionality is designed and implemented, it probably does not make sense to convert it into a unittest.
   However, it may be questioned whether the validation of a card should be isolated, i.e. that it is not so tighly coupled to the repositories.
   Then, the validation could eventually be tested without need of saving objects and reading them from the respositories.*
5. `RoundTest`  
   a) How could this test class be improved?  
   b)