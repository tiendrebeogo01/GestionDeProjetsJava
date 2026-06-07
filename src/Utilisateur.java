import java.util.ArrayList;

public class Utilisateur {
    private String nom;
    private String email;
    private ArrayList<Projet> projets = new ArrayList<>();

    public Utilisateur(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public ArrayList<Projet> getProjets() { return projets; }

    public void ajouterProjet(Projet p) {
        projets.add(p);
    }

    @Override
    public String toString() {
        return nom + " (" + email + ")";
    }
}
