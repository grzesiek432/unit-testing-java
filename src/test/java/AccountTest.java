import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AccountTest {

    @Test
    public void myTest1()
    {

        Account account = new Account();
        assertFalse(account.isActive(),"Check if new account is not active");
    }

    @Test
    public void myTest2()
    {

        Account account = new Account();
        assertFalse(account.isActive());
        account.activate();
        assertTrue(account.isActive());

    }



}
