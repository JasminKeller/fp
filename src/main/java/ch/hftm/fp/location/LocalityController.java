package ch.hftm.fp.location;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ch.hftm.fp.App;
import ch.hftm.fp.location.model.Locality;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        plzTxt.setText(null);
        locationTxt.setText(null);
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
