package Modele;

public abstract class Employe extends Personne {

    private int numeroEmploye;
    private String dateEmbauche;

    // Constructeur
    public Employe(int id, String nom, String adresse, String contact,
                   int numeroEmploye, String dateEmbauche) {
        super(id, nom, adresse, contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;
    }

    // Getters
    public int getNumeroEmploye() {
        return numeroEmploye;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    // Setters
    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    // Méthode abstraite
    public abstract String getRole();

    @Override
    public String toString() {
        return "Employe{" +
                "numeroEmploye=" + numeroEmploye +
                ", dateEmbauche='" + dateEmbauche + '\'' +
                '}';
    }
}
