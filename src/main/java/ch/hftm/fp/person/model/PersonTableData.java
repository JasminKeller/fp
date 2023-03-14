package ch.hftm.fp.person.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonTableData extends Person
{
    private StringProperty firstnameProperty;
    private StringProperty lastnameProperty;

    public PersonTableData( Person person )
    {
        this.firstnameProperty = new SimpleStringProperty( person.getFirstname() );
        this.lastnameProperty = new SimpleStringProperty( person.getLastname() );
    }
}
