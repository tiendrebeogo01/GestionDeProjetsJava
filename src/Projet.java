import java.util.ArrayList;

public class Projet {
    private String nom;
    private String description;
    private ArrayList<Tache> taches = new ArrayList<>();

    public Projet(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public ArrayList<Tache> getTaches() { return taches; }

    // Gestion des tâches
    public void ajouterTache(Tache t) {
        taches.add(t);
    }

    public void supprimerTache(String titre) throws Exception {
        boolean removed = taches.removeIf(t -> t.getTitre().equalsIgnoreCase(titre));
        if (!removed) {
            throw new Exception("Erreur : tâche '" + titre + "' introuvable !");
        }
    }

    public void modifierTache(String titre, String nouveauStatut) throws Exception {
        for (Tache t : taches) {
            if (t.getTitre().equalsIgnoreCase(titre)) {
                t.setStatut(nouveauStatut);
                return;
            }
        }
        throw new Exception("Erreur : tâche '" + titre + "' introuvable !");
    }

    // Suivi de l’avancement
    public double progression() {
        if (taches.isEmpty()) return 0;
        long terminees = taches.stream().filter(t -> t.getStatut().equalsIgnoreCase("Terminée")).count();
        return (double) terminees / taches.size() * 100;
    }

    @Override
    public String toString() {
        return nom + " - " + description + " (Progression : " + progression() + "%)";
    }
}
