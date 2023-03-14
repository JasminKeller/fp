package ch.hftm.fp.address;

import ch.hftm.fp.address.model.Address;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

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
}
