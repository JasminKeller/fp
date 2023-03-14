package ch.hftm.fp.address;

import ch.hftm.fp.address.model.Address;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddressController implements Initializable {
    @FXML
    TextField addressTxt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

    public void createNewAddress( ActionEvent event )
    {

    }

    public void showLocality( ActionEvent actionEvent )
    {
        try
        {
            Stage stage = new Stage();
            stage.setTitle("Adressen");

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
