package ec.edu.epn;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import AJUserInterface.AJImageController.AJSplash;

/**
 * JavaFX App
 */
public class App extends Application {

    @SuppressWarnings({ "exports", "static-access" })
    @Override
    public void start(Stage stage) throws IOException {
        AJSplash.setStage(stage);
        new AJSplash().AJShowSplash();
    }

    public static void main(String[] args) {
        launch();
    }

}