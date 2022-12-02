<!--NO_HARDWRAPS-->

# Solutions

1. Have a look at the `CardEventHandlerTest` (integration).  
   a) What would you have to change in the `play_last_card_new_round_new_match` test to make a unittest instead of an integration test out of it?  
   *Solution: We would have to mock all the repository objects (`gameRepository`, `matchRepository`, `gameRepository`). And inject them to the `CardEventHandler`
object. Instead of doing assertions on the different repositories, we would check whether certain methods have been called with Mockito `verify`
method for example.*  
   b) Why wouldn't it make any sense to convert this test into a unittest?  
    *Solution: Because the purpose of this class is to test whether the entities are saved correctly, after the execution of the `handleAfterSave`.  
method. Converting it into a unittest would be possible theoretically but the test would be very tightly coupled to the method under test, because
it would need a lot of knowledge about what happens inside this method for doing various verifications.*
2. Have a look at the `CardValidatorTest` (integration).  
   a) In what terms is the `playing_card_with_not_active_turn_throws_error` test a good test and where do you see potential for improval?  
    *Solution: The name of the method is meaningful. The test uses the object builder pattern for constructing the large game object. A weakness
of the test is, that the assertion on the thrown exception is maybe a bit too sensitive. When only the formulation of the message is changed, the 
test will fail, even if the functionality itself works correctly.*  
   b) Would it make sense to convert this test into a unittest? Justify your answer.  
*Solution: The way the card validation functionality is designed and implemented, it probably does not make sense to convert it into a unittest.
However, it may be questioned whether the validation of a card should be isolated more so that the validation could be tested without need of saving
objects and reading them from the respositories.*
3. `RoundTest`  
   a) How could this test class be improved?  
   b)