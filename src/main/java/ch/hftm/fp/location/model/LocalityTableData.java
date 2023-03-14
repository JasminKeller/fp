package ch.hftm.fp.location.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalityTableData
{
    private StringProperty plz;
    private StringProperty location;

    public LocalityTableData( Locality locality )
    {
        this.plz = new SimpleStringProperty( locality.getPlz() );
        this.location = new SimpleStringProperty( locality.getLocation() );
    }
}
