package ec.edu.epn;

import javafx.application.Application;
import javafx.stage.Stage;
import AJUserInterface.AJSplash;

/**
 * JavaFX App
 */
public class App extends Application {

    @SuppressWarnings({ "exports", "static-access" })
    @Override
    public void start(Stage stage) throws Exception {
          AJSplash.setStage(stage);
        new AJSplash().AJShowSplash();
    }

    public static void main(String[] args) throws Exception {
        launch();
    }

}