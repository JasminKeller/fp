package ch.hftm.fp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application
{
    private static Stage addressStage;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception
    {
        addressStage = new Stage();

        FXMLLoader loader = new FXMLLoader( App.class.getResource( "view/Personen.fxml" ) );
        Scene scene = new Scene( loader.load(), 1200, 600 );
        stage.setTitle( "Personen" );
        stage.setScene( scene );
        stage.show();
    }

    public static Stage getAddressStage()
    {
        return addressStage;
    }
}
