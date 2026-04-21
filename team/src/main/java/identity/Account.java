package identity;

import enums.AccountStatus;

import java.io.Serializable;

public abstract class Account implements Serializable {
    private String id;
    private String passwrod;
    private AccountStatus status;
    private Person person;
    public Account(String id, String passwrod,AccountStatus status,Person person){
        this.id = id;
        this.passwrod = passwrod;
        this.status = status;
        this.person = person;
    }
    public boolean resetPassword(String newPasswrod){
        this.passwrod = newPasswrod;
        return true;

    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
