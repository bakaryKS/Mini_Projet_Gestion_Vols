package Modele;

public class Aeroport {
    private String nom;
    private String ville;
    private String description;

    // Constructeur
    public Aeroport(String nom, String ville, String description) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Aeroport{" +
                "nom='" + nom + '\'' +
                ", ville='" + ville + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
