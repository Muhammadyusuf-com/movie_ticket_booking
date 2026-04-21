package identity;

import enums.AccountStatus;

public class Admin extends Account{
    public Admin(String id,String password,AccountStatus status,Person person){
        super(id,password,status,person);
    }
    public boolean addMovie(Movie newMovie){
        return true;
    }
    public boolean addShow(Show newShow){
        return true;
    }
    public boolean blockUser(Account account){
        if(account.getStatus() == AccountStatus.Blocked){
            return false;
        }
        else {
            account.setStatus(AccountStatus.Blocked);
            return true;
        }
    }
}
