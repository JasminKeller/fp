package ch.hftm.fp.person.model;

import ch.hftm.fp.address.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person
{
    private String uuid;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private Address mainAddress;
    private List<Address> addresses;
}
