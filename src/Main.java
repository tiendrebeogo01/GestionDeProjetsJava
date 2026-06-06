import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {
    private Utilisateur user1 = new Utilisateur("Eric", "eric@example.com", "Chef de projet");
    private ObservableList<Projet> projets;
    private ObservableList<Tache> taches = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Application de Gestion de Projets");

        // Charger projets et tâches depuis fichier
        ArrayList<Projet> projetsCharges = DataManager.charger();
        projets = FXCollections.observableArrayList(projetsCharges);
        user1.getProjets().addAll(projetsCharges);

        // TableView Projets
        TableView<Projet> tableProjets = new TableView<>(projets);
        TableColumn<Projet, String> colNom = new TableColumn<>("Nom");
        colNom.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNom()));
        TableColumn<Projet, String> colDesc = new TableColumn<>("Description");
        colDesc.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDescription()));
        tableProjets.getColumns().addAll(colNom, colDesc);

        // TableView Tâches
        TableView<Tache> tableTaches = new TableView<>(taches);
        TableColumn<Tache, String> colTitre = new TableColumn<>("Titre");
        colTitre.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTitre()));
        TableColumn<Tache, String> colStatut = new TableColumn<>("Statut");
        colStatut.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatut()));
        TableColumn<Tache, String> colPriorite = new TableColumn<>("Priorité");
        colPriorite.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getPriorite()));
        tableTaches.getColumns().addAll(colTitre, colStatut, colPriorite);

        // Synchroniser tâches avec projet sélectionné
        tableProjets.getSelectionModel().selectedItemProperty().addListener((obs, oldProj, newProj) -> {
            if (newProj != null) {
                taches.setAll(newProj.getTaches());
            }
        });

        VBox layout = new VBox(10,
                new Label("Projets :"), tableProjets,
                new Label("Tâches :"), tableTaches);

        Scene scene = new Scene(layout, 900, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
