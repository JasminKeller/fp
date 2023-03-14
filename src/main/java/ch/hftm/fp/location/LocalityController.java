package ch.hftm.fp.location;

import java.net.URL;
import java.util.ResourceBundle;

import ch.hftm.fp.location.model.Locality;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class LocalityController implements Initializable {

    @FXML
    private TextField plzTxt;

    @FXML
    private TextField  locationTxt;

    @FXML
    private ListView<?> locationPLZListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    @FXML
    void clearNewLocationPLZ(ActionEvent event) {
        plzTxt.setText("");
        locationTxt.setText("");
    }

    @FXML
    void saveLocationPLZ(ActionEvent event) {

        var plz = plzTxt.getText();
        var location = locationTxt.getText();

        Locality locality = Locality.builder()
            .plz(plz)
            .location(location)
            .build();
        
        new LocalityService().saveLocality(locality);

    }


}
