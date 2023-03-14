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
}