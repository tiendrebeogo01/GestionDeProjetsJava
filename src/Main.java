import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private Utilisateur user = new Utilisateur("Eric", "erictiendrebeogo01611962@gmail.com");
    private ObservableList<Projet> projets = FXCollections.observableArrayList();
    private ObservableList<Tache> taches = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestion de Projets");

        // Table Projets
        TableView<Projet> tableProjets = new TableView<>(projets);
        TableColumn<Projet, String> colNom = new TableColumn<>("Nom");
        colNom.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNom()));
        TableColumn<Projet, String> colDesc = new TableColumn<>("Description");
        colDesc.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDescription()));
        tableProjets.getColumns().addAll(colNom, colDesc);

        // Table Tâches
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
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Progression du projet");
                alert.setHeaderText(newProj.getNom());
                alert.setContentText("Avancement : " + newProj.progression() + "%");
                alert.showAndWait();
            }
        });

        VBox layout = new VBox(10,
                new Label("Projets :"), tableProjets,
                new Label("Tâches :"), tableTaches);

        Scene scene = new Scene(layout, 900, 700);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Exemple de données
        Projet p1 = new Projet("Projet Java", "Application de gestion");
        p1.ajouterTache(new Tache("Coder interface", "Faire l'UI", "En cours", "Haute"));
        p1.ajouterTache(new Tache("Tests", "Vérifier les fonctionnalités", "Non commencé", "Moyenne"));
        user.ajouterProjet(p1);
        projets.add(p1);
    }

    public static void main(String[] args) { launch(args); }
}
