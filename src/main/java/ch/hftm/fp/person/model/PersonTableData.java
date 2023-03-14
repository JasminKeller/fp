package ch.hftm.fp.person.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonTableData
{
    private StringProperty firstname;
    private StringProperty lastname;

    public PersonTableData( Person person )
    {
        this.firstname = new SimpleStringProperty( person.getFirstname() );
        this.lastname = new SimpleStringProperty( person.getLastname() );
    }
}
