package pl.chojnacki.grzegorz.testing;

public class Account {

    private boolean active;

    private Address defaultDeliveryAddress;
    private String email;

    public Account()
    {
        this.active=false;
    }

    public Account(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;

        if(defaultDeliveryAddress != null)
        {
            activate();
        }else {
            this.active=false;
        }
    }

    public void activate()
    {
        this.active=true;
    }

    public boolean isActive() {
        return this.active;
    }


    public Address getDefaultDeliveryAddress() {
        return defaultDeliveryAddress;
    }

    public void setDefaultDeliveryAddress(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
    }

    public void setEmail(String email) {

        if(email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")) {
            this.email = email;
        }else
        {
            throw new IllegalArgumentException("Wrong email format");
        }
    }
}
