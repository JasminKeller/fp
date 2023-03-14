package ch.hftm.fp.address.model;

import ch.hftm.fp.person.model.Person;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressTableData
{
    private StringProperty street;
    private CheckBox favoriteCheckBox;
    private Button deleteButton;

    public AddressTableData( Address address, Person person )
    {
        this.street = new SimpleStringProperty( address.getStreet() );

        favoriteCheckBox = new CheckBox();
        favoriteCheckBox.selectedProperty().addListener( (observableValue, oldValue, newValue) -> {
            if( newValue )
            {
                person.setMainAddress( address );
            }
        } );










    }
}
