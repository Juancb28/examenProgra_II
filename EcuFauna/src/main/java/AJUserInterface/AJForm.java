package AJUserInterface;

import AJBusinessLogic.AJBLGenoAlimento;
import AJBusinessLogic.AJBLHormiga;
import AJBusinessLogic.AJBLIngestaNativa;
import AJDataAccess.AJDataTransferObject.AJDTOHormiga;
import AJUserInterface.AJImageController.AJAnt;
import AJUserInterface.AJImageController.AJLogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.concurrent.atomic.AtomicInteger;

public class AJForm {
    private Stage AJFormStage;
    private Scene AJScene;
    private Group AJRoot;
    private Pane AJPane;
    private Label AJLabel;
    private ImageView AJImageView;
    private Button AJButton;
    private TextField AJTextField;
    private ChoiceBox<String> AJChoiceBoxGeno;
    private ChoiceBox<String> AJChoiceBoxInge;
    private ObservableList<AJDTOHormiga> hormigaList;
    private AJBLHormiga AJblHor;
    private AJDTOHormiga dto;
    AtomicInteger idAnt = new AtomicInteger(0);

    public void AJShowStageForm() throws Exception {
        AJFormStage = new Stage();
        AJRoot = new Group();
        AJScene = new Scene(AJRoot);

        AJFormStage.setWidth(650);
        AJFormStage.setHeight(600);
        AJFormStage.setFullScreen(false);
        AJFormStage.setResizable(false);
        AJFormStage.centerOnScreen();
        AJFormStage.setTitle("EcuFauna 2K24A - Form");
        AJFormStage.getIcons().add(new Image(new AJLogo().AJGetPathImage()));
        AJFormStage.setScene(AJScene);
        AJFormStage.show();

        AJStructureForm();
    }

    private void AJStructureForm() throws Exception {

        AJblHor = new AJBLHormiga();

        // Panel principal
        AJPane = new Pane();
        AJPane.setStyle("-fx-background-color: #D3D3D3;");
        AJPane.setLayoutX(35);
        AJPane.setLayoutY(15);
        AJPane.setPrefWidth(565);
        AJPane.setPrefHeight(100);
        AJRoot.getChildren().add(AJPane);

        // Etiqueta y campo de texto para cédula
        AJLabel = new Label("Cédula:");
        AJLabel.setLayoutX(95);
        AJLabel.setLayoutY(35);
        AJLabel.setFont(new Font("Arial", 18));
        AJRoot.getChildren().add(AJLabel);

        AJTextField = new TextField();
        AJTextField.setLayoutX(375);
        AJTextField.setLayoutY(40);
        AJTextField.setText(new AntController().getAJCedulaAlumno());
        AJTextField.setAlignment(Pos.CENTER);
        AJTextField.setFont(new Font("Arial", 8));
        AJTextField.setScaleX(2.5);
        AJTextField.setScaleY(1.5);
        AJTextField.setEditable(false);
        AJRoot.getChildren().add(AJTextField);

        // Etiqueta y campo de texto para nombres
        AJLabel = new Label("Nombres:");
        AJLabel.setLayoutX(95);
        AJLabel.setLayoutY(70);
        AJLabel.setFont(new Font("Arial", 18));
        AJRoot.getChildren().add(AJLabel);

        AJTextField = new TextField();
        AJTextField.setLayoutX(375);
        AJTextField.setLayoutY(75);
        AJTextField.setText(new AntController().getAJNombresAlumno());
        AJTextField.setAlignment(Pos.CENTER);
        AJTextField.setFont(new Font("Arial", 8));
        AJTextField.setScaleX(2.5);
        AJTextField.setScaleY(1.5);
        AJTextField.setEditable(false);
        AJRoot.getChildren().add(AJTextField);

        // Etiqueta de título
        AJLabel = new Label("Hormiguero virtual");
        AJLabel.setLayoutX(100);
        AJLabel.setLayoutY(175);
        AJLabel.setFont(new Font("Arial", 20));
        AJLabel.setStyle("-fx-text-fill: blue;");
        AJRoot.getChildren().add(AJLabel);

        // Imagen de hormiga
        AJImageView = new ImageView(new Image(new AJAnt().AJGetPathImage()));
        AJImageView.setX(35);
        AJImageView.setY(135);
        AJImageView.setScaleX(1);
        AJImageView.setScaleY(1);
        AJRoot.getChildren().add(AJImageView);

        // Botón para crear hormiga larva
        AJButton = new Button("Crear hormiga larva");
        AJButton.setStyle("-fx-background-color: #4C4C4C; -fx-text-fill: white;");
        AJButton.setLayoutX(300);
        AJButton.setLayoutY(165);
        AJButton.setMinSize(300, 45);
        AJButton.setFont(new Font("Arial", 18));
        AJButton.setOnMouseClicked(e -> {
            AJConfirmDialog();
        });
        AJRoot.getChildren().add(AJButton);

        // ChoiceBox para GenoAlimento
        AJChoiceBoxGeno = new ChoiceBox<>();

        for (int i = 0; i < new AJBLGenoAlimento().AJReadAll().size(); i++) {
            AJChoiceBoxGeno.getItems().add(new AJBLGenoAlimento().AJReadBy(i + 1).getNombreGenoAlimento());
        }

        AJChoiceBoxGeno.setValue("Sin seleccionar");
        AJChoiceBoxGeno.setLayoutX(35);
        AJChoiceBoxGeno.setLayoutY(365);
        AJChoiceBoxGeno.setMinSize(250, 35);
        AJRoot.getChildren().add(AJChoiceBoxGeno);

        TableView<AJDTOHormiga> tableView = new TableView<>();

        placeDataTable(tableView);

        tableView.setItems(hormigaList);

        tableView.setLayoutX(35);
        tableView.setLayoutY(220);
        tableView.setPrefSize(565, 125); // Tamaño del TableView

        AJRoot.getChildren().add(tableView);

        // Botón para alimentar con GenoAlimento
        AJButton = new Button("Alimentar con GenoAlimento");
        AJButton.setStyle("-fx-background-color: #4C4C4C; -fx-text-fill: white;");
        AJButton.setLayoutX(300);
        AJButton.setLayoutY(365);
        AJButton.setMinSize(300, 35);
        AJButton.setFont(new Font("Arial", 18));
        AJButton.setOnMouseClicked(e -> {
            dto = tableView.getSelectionModel().getSelectedItem();
            if (dto != null && AJChoiceBoxGeno.getValue() != null) {
                try {
                    dto.setIdGenoAlimento(new AntController().addGenoAlimento(AJChoiceBoxGeno.getValue()));
                    tableView.refresh();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                AJChoiceBoxGeno.setValue(null);
            }
        });
        AJRoot.getChildren().add(AJButton);

        // ChoiceBox para Ingesta Nativa
        AJChoiceBoxInge = new ChoiceBox<>();
        for (int i = 0; i < new AJBLIngestaNativa().AJReadAll().size(); i++) {
            AJChoiceBoxInge.getItems().add(new AJBLIngestaNativa().AJReadBy(i + 1).getNombreIngestaNativa());
        }
        AJChoiceBoxInge.setValue("Sin seleccionar");
        AJChoiceBoxInge.setLayoutX(35);
        AJChoiceBoxInge.setLayoutY(410);
        AJChoiceBoxInge.setMinSize(250, 35);
        AJRoot.getChildren().add(AJChoiceBoxInge);

        // Botón para alimentar con Ingesta Nativa
        AJButton = new Button("Alimentar con Ingesta Nativa");
        AJButton.setStyle("-fx-background-color: #4C4C4C; -fx-text-fill: white;");
        AJButton.setLayoutX(300);
        AJButton.setLayoutY(410);
        AJButton.setMinSize(300, 35);
        AJButton.setFont(new Font("Arial", 18));
        AJButton.setOnMouseClicked(e -> {
            System.out.println("Alimentar con Ingesta Nativa");
            AJChoiceBoxInge.setValue(null);
        });
        AJRoot.getChildren().add(AJButton);

        // TableView de AJDTOHormiga

        // Panel inferior
        AJPane = new Pane();
        AJPane.setStyle("-fx-background-color: #D3D3D3;");
        AJPane.setLayoutX(35);
        AJPane.setLayoutY(470);
        AJPane.setPrefWidth(565);
        AJPane.setPrefHeight(80);
        AJRoot.getChildren().add(AJPane);

        // Botón ELIMINAR
        AJButton = new Button("ELIMINAR");
        AJButton.setStyle("-fx-background-color: #5C77CE; -fx-text-fill: black;");
        AJButton.setLayoutX(85);
        AJButton.setLayoutY(485);
        AJButton.setMinSize(200, 45);
        AJButton.setFont(new Font("Arial", 18));
        AJButton.setOnMouseClicked(e -> {
            if (!tableView.getItems().isEmpty() && tableView.getSelectionModel().getSelectedItem() != null) {
                tableView.getItems().remove(tableView.getSelectionModel().getSelectedItem());
                tableView.refresh();
            } else {
                NonItemsObtained();
            }
            tableView.getSelectionModel().clearSelection();
        });
        AJRoot.getChildren().add(AJButton);

        // Botón GUARDAR
        AJButton = new Button("GUARDAR");
        AJButton.setStyle("-fx-background-color: #5C77CE; -fx-text-fill: black;");
        AJButton.setLayoutX(350);
        AJButton.setLayoutY(485);
        AJButton.setMinSize(200, 45);
        AJButton.setFont(new Font("Arial", 18));
        AJButton.setOnMouseClicked(e -> {
            System.out.println("Guardar");
        });
        AJRoot.getChildren().add(AJButton);
    }

    @SuppressWarnings("unchecked")
    private void placeDataTable(TableView<AJDTOHormiga> tableView) throws Exception {
        TableColumn<AJDTOHormiga, Integer> regNroCol = new TableColumn<>("RegNro");
        regNroCol.setCellValueFactory(new PropertyValueFactory<>("idAJHormiga"));

        TableColumn<AJDTOHormiga, String> tipoHormigaCol = new TableColumn<>("TipoHormiga");
        tipoHormigaCol.setCellValueFactory(new PropertyValueFactory<>("TipoHormiga"));

        TableColumn<AJDTOHormiga, String> ubicacionCol = new TableColumn<>("Ubicación");
        ubicacionCol.setCellValueFactory(new PropertyValueFactory<>("NombreProvincia"));

        TableColumn<AJDTOHormiga, String> sexoCol = new TableColumn<>("Sexo");
        sexoCol.setCellValueFactory(new PropertyValueFactory<>("NombreSexo"));

        TableColumn<AJDTOHormiga, String> genoAlimentoCol = new TableColumn<>("GenoAlimento");
        genoAlimentoCol.setCellValueFactory(new PropertyValueFactory<>("NombreGenoAlimento"));

        TableColumn<AJDTOHormiga, String> ingestaNativaCol = new TableColumn<>("IngestaNativa");
        ingestaNativaCol.setCellValueFactory(new PropertyValueFactory<>("NombreIngestaNativa"));

        TableColumn<AJDTOHormiga, String> estadoCol = new TableColumn<>("Estado");
        estadoCol.setCellValueFactory(new PropertyValueFactory<>("Estado"));

        tableView.getColumns().addAll(regNroCol, tipoHormigaCol, ubicacionCol, sexoCol, genoAlimentoCol,
                ingestaNativaCol, estadoCol);

        hormigaList = FXCollections.observableArrayList();

        for (int i = 0; i < AJblHor.AJReadAll().size(); i++) {
            AJDTOHormiga dto = new AJDTOHormiga(
                    AJblHor.AJReadBy(i).getIdAJHormiga(),
                    AJblHor.AJReadBy(i).getTipoHormiga(),
                    AJblHor.AJReadBy(i).getNombreProvincia(),
                    AJblHor.AJReadBy(i).getNombreSexo(),
                    AJblHor.AJReadBy(i).getNombreGenoAlimento(),
                    AJblHor.AJReadBy(i).getNombreIngestaNativa(),
                    AJblHor.AJReadBy(i).getEstado());

            dto.setIdAJHormiga(i + 1);
            hormigaList.add(dto);
        }
    }

    private void AJConfirmDialog() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText(null);
        alert.setContentText("¿Está seguro de crear una hormiga larva?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    hormigaList.add(new AntController().createAntPrototipe());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        });
    }

    private void NonItemsObtained() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("No ha seleccioando ninguna hormiga.");

        alert.showAndWait().ifPresent(response -> response.getButtonData());
    }

}
