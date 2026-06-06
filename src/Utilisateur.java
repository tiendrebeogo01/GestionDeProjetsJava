import java.util.ArrayList;

public class Utilisateur {
    private String nom;
    private String email;
    private String role;
    private ArrayList<Projet> projets;

    public Utilisateur(String nom, String email, String role) {
        this.nom = nom;
        this.email = email;
        this.role = role;
        this.projets = new ArrayList<>();
    }

    public void ajouterProjet(Projet p) { projets.add(p); }
    public void supprimerProjet(Projet p) { projets.remove(p); }
    public ArrayList<Projet> getProjets() { return projets; }

    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
}
