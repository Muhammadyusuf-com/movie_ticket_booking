package identity;

import enums.AccountStatus;

public class FrontDeskOfficer  extends Account{
    public FrontDeskOfficer(String id, String password, AccountStatus status,Person person){
        super(id,password,status,person);
    }
}