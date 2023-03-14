module fp
{
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;

    requires lombok;
    requires com.fasterxml.jackson.databind;

    opens ch.hftm.fp to javafx.fxml;
    exports ch.hftm.fp;
    opens ch.hftm.fp.person to javafx.fxml;
    exports ch.hftm.fp.person.model;
    exports ch.hftm.fp.address.model;
    exports ch.hftm.fp.location.model;
    opens ch.hftm.fp.address to javafx.fxml;
    opens ch.hftm.fp.location to javafx.fxml;
}