package ch.hftm.fp.person;

import ch.hftm.fp.App;
import ch.hftm.fp.person.model.Person;
import ch.hftm.fp.person.model.PersonTableData;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class PersonController implements Initializable
{
    @FXML
    TextField inputFirstname;

    @FXML
    TextField inputLastname;

    @FXML
    DatePicker inputDateOfBirth;

    @FXML
    TableColumn<PersonTableData, String> colFirstname;

    @FXML
    TableColumn<PersonTableData, String> colLastname;

    @FXML
    TableView<PersonTableData> personTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showPersons();
    }

    private void showPersons() {
        List<Person> persons = new PersonService().getPersons();

        colFirstname.setCellValueFactory( cellValue -> cellValue.getValue().getFirstnameProperty() );
        colLastname.setCellValueFactory( cellValue -> cellValue.getValue().getLastnameProperty() );

        personTable.setItems(FXCollections.observableList( persons.stream()
                .map( PersonTableData::new )
                .toList() ));
    }

    public void savePerson(ActionEvent actionEvent)
    {
        var firstname = inputFirstname.getText();
        var lastname = inputLastname.getText();
        var dateOfBirth = inputDateOfBirth.getValue();

        Instant instant = Instant.from(dateOfBirth.atStartOfDay(ZoneId.systemDefault()));

        Person person = Person.builder()
                .firstname( firstname )
                .lastname( lastname )
                .birthdate( Date.from(instant) )
                .build();

        new PersonService().savePerson( person );

        clearPersonTextFields();

        showPersons();
    }

    public void clearPersonTextFields() {
        inputFirstname.setText( null );
        inputLastname.setText( null );
        inputDateOfBirth.setValue( null );
    }

    

    public void showAddresses( ActionEvent actionEvent )
    {
        try
        {
            Stage stage = App.getAddressStage();
            stage.setTitle("Adressen");
            stage.setUserData( personTable.getSelectionModel().getSelectedItem() );

            FXMLLoader loader = new FXMLLoader(App.class.getResource("view/Adressen.fxml"));
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
