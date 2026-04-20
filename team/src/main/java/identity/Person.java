package identity;

import enums.Address;

public class Person {
    private String name;
    private Address address;
    private String email;
    private String phone;
    public Person(String name,Address address,String email, String phone){
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
}