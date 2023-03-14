package ch.hftm.fp.address;

import ch.hftm.fp.App;
import ch.hftm.fp.address.model.Address;
import ch.hftm.fp.location.LocalityService;
import ch.hftm.fp.location.model.Locality;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AddressController implements Initializable {
    @FXML
    TextField addressTxt;

    @FXML
    private ComboBox<String> locationPLZDropdown;

    // Import the localityList from the LocalityController class
    private LocalityService localityService = new LocalityService();
    private ObservableList<Locality> localityList = FXCollections.observableList(localityService.getLocalities());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadLocationPLZDropdown();
    }


    public void loadLocationPLZDropdown(){
        // set locationPLZDropdown with existing locationPLZ of class Locality
        locationPLZDropdown.setItems(getlocationPLZ());
        if (!localityList.isEmpty()) {
            locationPLZDropdown.getSelectionModel().selectFirst();
        }
    }


    // Method to return an ObservableList of locationPLZ names
    public ObservableList<String> getlocationPLZ() {
        return localityList.stream()
                .map(locality -> locality.getPlz() + " " + locality.getLocation())
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
    }


    public void saveAddress(ActionEvent event)
    {
        var street = addressTxt.getText();

        var address = Address.builder()
                .street( street )
                .locality(null)
                .build();

        new AddressService().saveAddress( address );
    }

    public void clearAdressTextFields( ActionEvent event )
    {
        addressTxt.setText(null);
    }

    public void showLocality( ActionEvent actionEvent )
    {
        try
        {
            Stage stage = new Stage();
            stage.setTitle("Ortschaften");

            FXMLLoader loader = new FXMLLoader(App.class.getResource("view/Ortschaften.fxml"));
            Scene scene = new Scene(loader.load(), 1100, 600);

            stage.setScene( scene );
            stage.show();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
}
