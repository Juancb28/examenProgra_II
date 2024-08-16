package AJUserInterface;

import java.io.InputStream;
import java.util.Objects;

import AJUserInterface.AJImageController.AJImageDesign;
import AJUserInterface.AJImageController.AJLogo;
import javafx.animation.PauseTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AJSplash implements AJImageDesign {

    private static Scene scene;
    private static Stage stage;
    private static ImageView AJImageSplash;
    private static ProgressBar AJProgressBar;
    private static Label AJProgressBarLabel;
    private static Label AJNameLabel;
    private static Group AJRoot;
    private static Boolean isComplete;

    public AJSplash() {
        setIsComplete(false);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        AJSplash.stage = stage;
    }

    public static Boolean getIsComplete() {
        return isComplete;
    }

    public static void setIsComplete(Boolean isComplete) {
        AJSplash.isComplete = isComplete;
    }

    @Override
    public InputStream AJGetPathImage() {
        return Objects.requireNonNull(getClass().getResourceAsStream("/Images/SplashImage.png"));
    }

    public static void AJShowSplash() {
        AJImageSplash = new ImageView(new Image(new AJSplash().AJGetPathImage()));
        AJRoot = new Group();
        scene = new Scene(AJRoot, 410, 240);
        AJProgressBar = new ProgressBar();
        AJProgressBarLabel = new Label("0%");
        AJNameLabel = new Label("EcuFauna");

        AJImageSplash.setFitWidth(410);
        AJImageSplash.setFitHeight(240);
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.setOpacity(0.9);
        stage.centerOnScreen();
        stage.setTitle("EcuFauna");
        stage.getIcons().add(new Image(new AJLogo().AJGetPathImage()));
        stage.setScene(scene);
        stage.show();
        
        AJNameLabel.setFont(new Font("Elephant", 45));
        AJNameLabel.setLayoutX(95);
        AJNameLabel.setLayoutY(85);
        AJNameLabel.setTextFill(Color.WHITE);
        AJProgressBar.setStyle("-fx-accent: green;");
        AJRoot.getChildren().addAll(AJImageSplash, AJProgressBar, AJProgressBarLabel, AJNameLabel);

        updateProgress(0);

    }

    private static void updateProgress(int progress) {
        PauseTransition pause = new PauseTransition(Duration.millis(250));
        if (progress <= 100) {
            AJProgressBar.setLayoutX(10);
            AJProgressBar.setLayoutY(220);
            AJProgressBar.setPrefWidth(390);
            AJProgressBar.setProgress(progress / 100.0);
            AJProgressBarLabel.setLayoutX(200);
            AJProgressBarLabel.setLayoutY(220);
            AJProgressBarLabel.setText(progress + "%");

            if (progress == 55) {
                AJProgressBarLabel.setStyle("-fx-text-fill: white;");
            }

            pause.setOnFinished(event -> {
                if (progress == 100) {
                    stage.close();
                    try {
                        // AJLogin.setAJLoginStage(stage);
                        AJLogin.AJShowLogin();
                        // AJForm.AJShowStageForm();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else
                    updateProgress(progress + 1);

            });
            pause.play();
        }
    }

}
