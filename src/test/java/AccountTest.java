import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AccountTest {

    @Test
    public void newAccountShouldNotBeActiveCreation()
    {
        //given
        //when
        Account account = new Account();

        //then
        assertFalse(account.isActive(),"Check if new account is not active");
    }

    @Test
    public void newAccountShouldBeActiveAfterActivation()
    {
        //given
        Account account = new Account();


        //when
        account.activate();

        //then
        assertTrue(account.isActive());

    }



}
