package AJUserInterface;

import AJBusinessLogic.AJBLGenoAlimento;
import AJBusinessLogic.AJBLIngestaNativa;
import AJUserInterface.AJImageController.AJAnt;
import AJUserInterface.AJImageController.AJLogo;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AJForm {
    private static Stage AJFormStage;
    private static Scene AJScene;
    private static Group AJRoot;
    private static Pane AJPane;
    private static Label AJLabel;
    private static ImageView AJImageView;
    private static Button AJButton;
    private static TextField AJTextField;
    private static ChoiceBox<String> AJChoiceBoxGeno;
    private static ChoiceBox<String> AJChoiceBoxInge;
    private static GridPane AJGridPane;

    private static final String AJCedulaAlumno = "1752176097";
    private static final String AJNombresAlumno = "Arroyo Juan";

    public static void AJShowStageForm() throws Exception {
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

    private static void AJStructureForm() throws Exception {
        AJBLGenoAlimento AJblGen = new AJBLGenoAlimento();
        AJBLIngestaNativa AJblInge = new AJBLIngestaNativa();

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

        AJTextField = new TextField();
        AJTextField.setLayoutX(375);
        AJTextField.setLayoutY(40);
        AJTextField.setText(AJCedulaAlumno);
        AJTextField.setAlignment(Pos.CENTER);
        AJTextField.setFont(new Font("Arial", 8));
        AJTextField.setScaleX(2.5);
        AJTextField.setScaleY(1.5);
        AJTextField.setEditable(false);


        AJRoot.getChildren().add(AJTextField);

        AJLabel = new Label("Nombres:");
        AJLabel.setLayoutX(95);
        AJLabel.setLayoutY(70);
        AJLabel.setFont(new Font("Arial", 18));

        AJRoot.getChildren().add(AJLabel);

        AJTextField = new TextField();
        AJTextField.setLayoutX(375);
        AJTextField.setLayoutY(75);
        AJTextField.setText(AJNombresAlumno);
        AJTextField.setAlignment(Pos.CENTER);
        AJTextField.setFont(new Font("Arial", 8));
        AJTextField.setScaleX(2.5);
        AJTextField.setScaleY(1.5);
        AJTextField.setEditable(false);

        AJRoot.getChildren().add(AJTextField);

        AJLabel = new Label("Hormiguero virtual");
        AJLabel.setLayoutX(100);
        AJLabel.setLayoutY(175);
        AJLabel.setFont(new Font("Arial", 20));
        AJLabel.setStyle("-fx-text-fill: blue;");

        AJRoot.getChildren().add(AJLabel);

        AJImageView = new ImageView(new Image(new AJAnt().AJGetPathImage()));
        AJImageView.setX(35);
        AJImageView.setY(135);
        AJImageView.setScaleX(1);
        AJImageView.setScaleY(1);

        AJRoot.getChildren().add(AJImageView);

        AJButton = new Button("crear hormiga larva");
        AJButton.setStyle("-fx-background-color: #4C4C4C;" + "-fx-text-fill: white;");
        AJButton.setLayoutX(300);
        AJButton.setLayoutY(165);
        AJButton.setMinSize(300, 45);
        AJButton.setFont(new Font("Arial", 18));

        AJButton.setOnMouseClicked(e -> {
            System.out.println("crear hormiga larva"); // TODO: crear bl
        });

        AJRoot.getChildren().add(AJButton);

        AJChoiceBoxGeno = new ChoiceBox<>();
        for (int i = 0; i < AJblGen.AJReadAll().size(); i++) {
            AJChoiceBoxGeno.getItems().add(AJblGen.AJReadBy(i + 1).getNombreGenoAlimento()); // TODO: Pasar getall bl
        }
        AJChoiceBoxGeno.setValue("Sin seleccionar");
        AJChoiceBoxGeno.setLayoutX(35);
        AJChoiceBoxGeno.setLayoutY(365);
        AJChoiceBoxGeno.setMinSize(250, 35);

        AJRoot.getChildren().add(AJChoiceBoxGeno);

        AJButton = new Button("alimentar con GenoAlimento");
        AJButton.setStyle("-fx-background-color: #4C4C4C;" + "-fx-text-fill: white;");
        AJButton.setLayoutX(300);
        AJButton.setLayoutY(365);
        AJButton.setMinSize(300, 35);
        AJButton.setFont(new Font("Arial", 18));

        AJButton.setOnMouseClicked(e -> {
            System.out.println("calimentar con GenoAlimento"); // TODO: Pasar BL genoalimento
        });

        AJRoot.getChildren().add(AJButton);

        AJChoiceBoxInge = new ChoiceBox<>();
        for (int i = 0; i < AJblInge.AJReadAll().size(); i++) {
            AJChoiceBoxInge.getItems().add(AJblInge.AJReadBy(i + 1).getNombreIngestaNativa()); // TODO: Pasar getall bl
        }
        AJChoiceBoxInge.setValue("Sin seleccionar");
        AJChoiceBoxInge.setLayoutX(35);
        AJChoiceBoxInge.setLayoutY(410);
        AJChoiceBoxInge.setMinSize(250, 35);

        AJRoot.getChildren().add(AJChoiceBoxInge);

        AJButton = new Button("alimentar con Ingesta Nativa");
        AJButton.setStyle("-fx-background-color: #4C4C4C;" + "-fx-text-fill: white;");
        AJButton.setLayoutX(300);
        AJButton.setLayoutY(410);
        AJButton.setMinSize(300, 35);
        AJButton.setFont(new Font("Arial", 18));

        AJButton.setOnMouseClicked(e -> {
            System.out.println("alimentar con Ingesta Nativa"); // TODO: Pasar BL Ingestanativa
        });

        AJRoot.getChildren().add(AJButton);

        AJPane = new Pane();
        AJPane.setStyle("-fx-background-color: #D3D3D3;");
        AJPane.setLayoutX(35);
        AJPane.setLayoutY(470);
        AJPane.setPrefWidth(565);
        AJPane.setPrefHeight(80);

        AJRoot.getChildren().add(AJPane);

        AJButton = new Button("ELIMINAR");
        AJButton.setStyle("-fx-background-color: #5C77CE;" + "-fx-text-fill: black;");
        AJButton.setLayoutX(85);
        AJButton.setLayoutY(485);
        AJButton.setMinSize(200, 45);
        AJButton.setFont(new Font("Arial", 18));

        AJButton.setOnMouseClicked(e -> {
            System.out.println("Eliminar"); // TODO: eliminar bl
        });

        AJRoot.getChildren().add(AJButton);

        AJButton = new Button("GUARDAR");
        AJButton.setStyle("-fx-background-color: #5C77CE;" + "-fx-text-fill: black;");
        AJButton.setLayoutX(350);
        AJButton.setLayoutY(485);
        AJButton.setMinSize(200, 45);
        AJButton.setFont(new Font("Arial", 18));

        AJButton.setOnMouseClicked(e -> {
            System.out.println("Guardar"); // TODO: guardar BL
        });

        AJRoot.getChildren().add(AJButton);

        AJGridPane = new GridPane();
        AJGridPane.setMinSize(565, 130);
        AJGridPane.setLayoutX(35);
        AJGridPane.setLayoutY(220);
        AJGridPane.setHgap(5.5);
        AJGridPane.setVgap(4.5);

        AJGridPane.setStyle("-fx-background-color: #CFCFCF;");

        // Add 6x3 Labels to the GridPane
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 6; col++) {
                Label label = new Label("Item " + (row * 6 + col + 1));
                label.setMinSize(90, 40);
                label.setStyle("-fx-background-color: white; -fx-alignment: center; -fx-border-color: black;");

                // Add an event handler to the label
                label.setOnMouseClicked(event -> {
                    // Handle the click event here
                    System.out.println(label.getText() + " clicked!");
                    // You can replace the above line with code to generate the required information
                });

                // Add the label to the GridPane
                AJGridPane.add(label, col, row);
            }
        }

        AJRoot.getChildren().add(AJGridPane);

    }

}
