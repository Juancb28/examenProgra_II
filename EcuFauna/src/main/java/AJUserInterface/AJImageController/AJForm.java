package AJUserInterface.AJImageController;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AJForm {
    private static Stage AJFormStage;
    private static Scene AJScene;
    private static Group AJRoot;
    private static Pane AJPane;
    private static Label AJLabel;

    public static void AJShowStageForm() {
        AJFormStage = new Stage();
        AJRoot = new Group();
        AJScene = new Scene(AJRoot);

        AJFormStage.setWidth(650);
        AJFormStage.setHeight(600);
        AJFormStage.setFullScreen(false);
        AJFormStage.setResizable(false);
        AJFormStage.centerOnScreen();
        AJFormStage.setTitle("EcuFauna 2K24A");
        AJFormStage.getIcons().add(new Image(new AJLogo().AJGetPathImage()));
        AJFormStage.setScene(AJScene);
        AJFormStage.show();

        AJStructureForm();
    }

    private static void AJStructureForm() {
        AJPane = new Pane();
        AJPane.setStyle("-fx-background-color: #D3D3D3;");
        AJPane.setLayoutX(35);
        AJPane.setLayoutY(15);
        AJPane.setPrefWidth(565);
        AJPane.setPrefHeight(100);

        AJRoot.getChildren().add(AJPane);

        AJLabel = new Label("Cedula:");
        AJLabel.setLayoutX(95);
        AJLabel.setLayoutY(35);
        AJLabel.setFont(new Font("Arial", 18));
        
        AJRoot.getChildren().add(AJLabel);
        
        AJLabel = new Label("Nombres:");
        AJLabel.setLayoutX(95);
        AJLabel.setLayoutY(70);
        AJLabel.setFont(new Font("Arial", 18));
        
        AJRoot.getChildren().add(AJLabel);

    }

}
