import java.util.ArrayList;

public class Projet {
    private String nom;
    private String description;
    private String dateDebut;
    private String dateFin;
    private ArrayList<Tache> taches;

    public Projet(String nom, String description, String dateDebut, String dateFin) {
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.taches = new ArrayList<>();
    }

    public void ajouterTache(Tache t) { taches.add(t); }
    public void supprimerTache(Tache t) { taches.remove(t); }
    public ArrayList<Tache> getTaches() { return taches; }

    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public String getDateDebut() { return dateDebut; }
    public String getDateFin() { return dateFin; }

    @Override
    public String toString() {
        return nom + " (" + dateDebut + " - " + dateFin + ")";
    }
}
