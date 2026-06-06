public class Tache {
    private String titre;
    private String description;
    private String statut;   // "À faire", "En cours", "Terminé"
    private String priorite; // "Basse", "Moyenne", "Haute"
    private String dateLimite;

    public Tache(String titre, String description, String statut, String priorite, String dateLimite) {
        this.titre = titre;
        this.description = description;
        this.statut = statut;
        this.priorite = priorite;
        this.dateLimite = dateLimite;
    }

    // Getters & Setters
    public String getTitre() { return titre; }
    public String getDescription() { return description; }
    public String getStatut() { return statut; }
    public String getPriorite() { return priorite; }
    public String getDateLimite() { return dateLimite; }

    public void setStatut(String statut) { this.statut = statut; }
    public void setPriorite(String priorite) { this.priorite = priorite; }

    @Override
    public String toString() {
        return titre + " (" + statut + ", priorité: " + priorite + ")";
    }
}
