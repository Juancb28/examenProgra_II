package AJUserInterface;

import AJFramework.AJVerificacion.AJVerificarCredenciales;
import AJUserInterface.AJImageController.AJLogo;
import AJUserInterface.AJImageController.AJWarning;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AJLogin {

    private static Stage AJLoginStage;
    private static Scene AJScene;
    private static Group AJRoot;
    private static Pane AJPane;
    private static Label AJLabel;
    private static Button AJButton;
    private static StringBuilder contra;
    private static TextField AJTextFieldUsua;
    private static TextField AJTextFieldContra;
    private static int AJVecesMax;

    public static void AJShowLogin() throws Exception {
        AJVecesMax = 3;
        AJLoginStage = new Stage();
        AJRoot = new Group();
        AJScene = new Scene(AJRoot);

        AJLoginStage.setWidth(410);
        AJLoginStage.setHeight(240);
        AJLoginStage.setFullScreen(false);
        AJLoginStage.setResizable(false);
        AJLoginStage.centerOnScreen();
        AJLoginStage.setTitle("EcuFauna 2K24A - Login");
        AJLoginStage.getIcons().add(new Image(new AJLogo().AJGetPathImage()));
        AJLoginStage.setScene(AJScene);
        AJLoginStage.show();
        AJStructureForm();
    }

    private static void AJStructureForm() throws Exception {
        contra = new StringBuilder();

        AJPane = new Pane();
        AJPane.setStyle("-fx-background-color: #D3D3D3;");
        AJPane.setLayoutX(10);
        AJPane.setLayoutY(10);
        AJPane.setPrefWidth(375);
        AJPane.setPrefHeight(170);

        AJRoot.getChildren().add(AJPane);

        AJLabel = new Label("Usuario:");
        AJLabel.setLayoutX(30);
        AJLabel.setLayoutY(35);
        AJLabel.minHeight(10);
        AJLabel.minWidth(20);
        AJLabel.setFont(new Font("Arial", 18));

        AJRoot.getChildren().add(AJLabel);

        AJTextFieldUsua = new TextField();
        AJTextFieldUsua.setLayoutX(220);
        AJTextFieldUsua.setLayoutY(40);
        AJTextFieldUsua.setAlignment(Pos.CENTER);
        AJTextFieldUsua.setFont(new Font(6));
        AJTextFieldUsua.setScaleX(3);
        AJTextFieldUsua.setScaleY(1.5);

        AJRoot.getChildren().add(AJTextFieldUsua);

        AJLabel = new Label("Contraseña:");
        AJLabel.setLayoutX(30);
        AJLabel.setLayoutY(85);
        AJLabel.minHeight(10);
        AJLabel.minWidth(20);
        AJLabel.setFont(new Font("Arial", 18));

        AJRoot.getChildren().add(AJLabel);

        AJTextFieldContra = new TextField();
        AJTextFieldContra.setLayoutX(220);
        AJTextFieldContra.setLayoutY(90);
        AJTextFieldContra.setAlignment(Pos.CENTER);
        AJTextFieldContra.setFont(new Font(6));
        AJTextFieldContra.setScaleX(3);
        AJTextFieldContra.setScaleY(1.5);

        AJTextFieldContra.setOnKeyPressed(event -> {
            if (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode().isWhitespaceKey()) {
                contra.append(event.getText());
                AJTextFieldContra.setText("*".repeat(contra.length()));
                AJTextFieldContra.positionCaret(contra.length());
                event.consume();
            } else if (event.getCode() == KeyCode.BACK_SPACE && contra.length() > 0) {
                contra.deleteCharAt(contra.length() - 1);
                AJTextFieldContra.setText("*".repeat(contra.length()));
                AJTextFieldContra.positionCaret(contra.length());
                event.consume();
            }
        });

        AJTextFieldContra.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            if (code.isLetterKey() || code.isDigitKey() || code == KeyCode.SPACE) {
                contra.append(event.getText());
                AJTextFieldContra.setText("*".repeat(contra.length()));
                AJTextFieldContra.positionCaret(contra.length());
                event.consume();
            } else if (code == KeyCode.BACK_SPACE && contra.length() > 0) {
                contra.deleteCharAt(contra.length() - 1);
                AJTextFieldContra.setText("*".repeat(contra.length()));
                AJTextFieldContra.positionCaret(contra.length());
                event.consume();
            } else if (code == KeyCode.TAB || code == KeyCode.ENTER || code == KeyCode.ESCAPE) {
                event.consume();
            }
        });

        AJRoot.getChildren().add(AJTextFieldContra);

        AJButton = new Button("Iniciar Sesión");
        AJButton.setStyle("-fx-background-color: #4C4C4C;" + "-fx-text-fill: white;");
        AJButton.setLayoutX(240);
        AJButton.setLayoutY(125);
        AJButton.setMinSize(90, 45);
        AJButton.setFont(new Font("Arial", 18));

        AJButton.setOnMouseClicked(event -> AJVerificarDatos());

        AJRoot.getChildren().add(AJButton);

        AJScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                AJVerificarDatos();
            }
        });

    }

    @SuppressWarnings("static-access")
    private static void AJVerificarDatos() {
        if (new AJVerificarCredenciales().AJVerificarCuenta(AJTextFieldUsua.getText(), contra.toString())) {
            try {
                AJLoginStage.close();
                new AJForm().AJShowStageForm();
            } catch (Exception e) {
            }
        } else {
            AJVecesMax--;
            AJDatosIncorrectos();
            if (AJVecesMax == 0) {
                mostrarMensajeError();
            }
        }
    }

    private static void AJDatosIncorrectos() {
        AJLabel = new Label("! usuario y/o contraseña\nincorrecto");
        AJLabel.setLayoutX(30);
        AJLabel.setLayoutY(125);
        AJLabel.setStyle("-fx-text-fill: #C30825;");
        AJLabel.setFont(new Font(18));

        AJRoot.getChildren().add(AJLabel);
    }

    private static void mostrarMensajeError() {
        Stage errorStage = new Stage();
        errorStage.setTitle("Error");
        errorStage.getIcons().add(new Image(new AJWarning().AJGetPathImage()));

        Label errorMessage = new Label("Error al iniciar sesión. No\n\tmás intentos.");
        errorMessage.setLayoutX(20);
        errorMessage.setLayoutY(0);
        errorMessage.setFont(new Font(18));
        errorMessage.setStyle("-fx-text-fill: #C30825;");

        Button closeButton = new Button("Cerrar");
        closeButton.setLayoutX(100);
        closeButton.setLayoutY(70);
        closeButton.setOnAction(e -> {
            errorStage.close();
            System.exit(0);
        });

        Group root = new Group();
        root.getChildren().addAll(errorMessage, closeButton);

        Scene scene = new Scene(root, 250, 100);

        errorStage.setScene(scene);
        errorStage.show();
    };

}
