package ch.hftm.fp.person;

import ch.hftm.fp.person.model.Person;
import ch.hftm.fp.person.model.PersonTableData;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
    TextField inputHometown;

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

        colFirstname.setCellValueFactory( cellValue -> cellValue.getValue().getFirstname() );
        colLastname.setCellValueFactory( cellValue -> cellValue.getValue().getLastname() );

        personTable.setItems(FXCollections.observableList( persons.stream()
                .map( PersonTableData::new )
                .toList() ));
    }

    public void savePerson(ActionEvent actionEvent)
    {
        var firstname = inputFirstname.getText();
        var lastname = inputLastname.getText();
        var dateOfBirth = inputDateOfBirth.getValue();
        var hometown = inputHometown.getText();

        Instant instant = Instant.from(dateOfBirth.atStartOfDay(ZoneId.systemDefault()));

        Person person = Person.builder()
                .firstname( firstname )
                .lastname( lastname )
                .birthdate( Date.from(instant) )
                .hometown( hometown )
                .build();

        new PersonService().savePerson( person );

        inputFirstname.setText( null );
        inputLastname.setText( null );
        inputDateOfBirth.setValue( null );
        inputHometown.setText( null );

        showPersons();
    }


    public void clearPersonTextFields(ActionEvent actionEvent) {
        inputFirstname.setText( null );
        inputLastname.setText( null );
        inputDateOfBirth.setValue( null );
    }

    
}
