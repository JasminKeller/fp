package ch.hftm.fp.person;

import ch.hftm.fp.person.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
    }
}
