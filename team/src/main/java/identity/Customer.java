package identity;

import enums.Address;

public class Customer extends Person{
    public Customer(String name, Address address, String email, String phone){
        super(name,address,email,phone);
    }
}