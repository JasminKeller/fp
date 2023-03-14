package ch.hftm.fp.location;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ch.hftm.fp.location.model.Locality;
import ch.hftm.fp.location.model.LocalityTableData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import ch.hftm.fp.address.AddressController;


public class LocalityController implements Initializable {

    @FXML
    private TextField plzTxt;

    @FXML
    private TextField  locationTxt;

    @FXML
    private ListView<?> locationPLZListView;

    private static ObservableList<Locality> localityList;

    public static ObservableList<Locality> getlocationPLZList() {
        return localityList;
    }

    @FXML
    TableColumn<LocalityTableData, String> colPLZ;

    @FXML
    TableColumn<LocalityTableData, String> colLocation;

    @FXML
    TableView<LocalityTableData> localityTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showLocalitys();
    }

    private void showLocalitys() {
        List<Locality> localities = new LocalityService().getLocalities();

        colPLZ.setCellValueFactory( cellValue -> cellValue.getValue().getPlz() );
        colLocation.setCellValueFactory( cellValue -> cellValue.getValue().getLocation() );

        localityTable.setItems(FXCollections.observableList( localities.stream()
                .map( LocalityTableData::new )
                .toList() ));
    }

    @FXML
    void clearNewLocationPLZ() {
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

        clearNewLocationPLZ();

        showLocalitys();

    }



}
