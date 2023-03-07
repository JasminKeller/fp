package ch.hftm.fp.person.model;

import ch.hftm.fp.address.model.Address;

import java.util.Date;
import java.util.List;

public class Person
{
    private String firstname;
    private String lastname;

    private Date birthdate;
    private Address mainAddress;
    private List<Address> addresses;
}
