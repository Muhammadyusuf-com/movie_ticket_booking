package identity;

import enums.AccountStatus;

public class Customer extends Account{
    public Customer(String id, String password, AccountStatus status,Person person){
        super(id,password,status,person);
    }
}