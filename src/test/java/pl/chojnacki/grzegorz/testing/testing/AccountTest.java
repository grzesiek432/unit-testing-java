package pl.chojnacki.grzegorz.testing.testing;

import org.junit.jupiter.api.Test;
import pl.chojnacki.grzegorz.testing.Account;
import pl.chojnacki.grzegorz.testing.Address;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


public class AccountTest {

    @Test
    public void newAccountShouldNotBeActiveCreation()
    {
        //given
        //when
        Account account = new Account();

        //then
        assertFalse(account.isActive(),"Check if new account is not active");
        assertThat(account.isActive(),equalTo(false));
        assertThat(account.isActive(),is(false));
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
        assertThat(account.isActive(),is(true));

    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet()
    {
        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDeliveryAddress();

        //then
        assertNull(address);
        assertThat(address,nullValue());
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet()
    {
        //given
        Address address = new Address("Warszawska", "43");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);

        //when
        Address address1 = account.getDefaultDeliveryAddress();

        //then
        assertNotNull(address1);
        assertThat(address1,is(notNullValue()));



    }




}
