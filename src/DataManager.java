import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataManager {
    private static final String FILE_NAME = "projets.json";
    private static final Gson gson = new Gson();

    // Sauvegarder projets et leurs tâches
    public static void sauvegarder(ArrayList<Projet> projets) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(projets, writer);
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    // Charger projets et leurs tâches
    public static ArrayList<Projet> charger() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type type = new TypeToken<ArrayList<Projet>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            System.out.println("Aucun fichier trouvé, démarrage avec liste vide.");
            return new ArrayList<>();
        }
    }
}
