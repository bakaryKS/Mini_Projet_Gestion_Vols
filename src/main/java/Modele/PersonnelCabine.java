package Modele;

import java.util.ArrayList;
import java.util.List;

public class PersonnelCabine extends Employe{
    private String qualification;
    private List<Vol> volsAssignes;

    // Constructeur
    public PersonnelCabine(int id, String nom, String adresse, String contact,
                           int numeroEmploye, String dateEmbauche, String qualification) {
        super(id, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
        this.volsAssignes = new ArrayList<>();
    }

    // Getters
    public String getQualification() {
        return qualification;
    }

    public List<Vol> getVolsAssignes() {
        return volsAssignes;
    }

    // Setters
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String getRole() {
        return "Personnel de cabine";
    }

    // Méthode pour assigner un vol
    public void assignerVol(Vol vol) {
        volsAssignes.add(vol);
        System.out.println("Vol assigné au personnel de cabine : " + this.getNom());
    }

    // Méthode pour obtenir les vols assignés
    public void afficherVols() {
        System.out.println("Vols assignés pour le personnel " + this.getNom() + " :");
        for (Vol vol : volsAssignes) {
            System.out.println("  - " + vol.getNumeroVol());
        }
    }

    @Override
    public String toString() {
        return "PersonnelCabine{" +
                "qualification='" + qualification + '\'' +
                ", nombreVolsAssignes=" + volsAssignes.size() +
                '}';
    }
}
