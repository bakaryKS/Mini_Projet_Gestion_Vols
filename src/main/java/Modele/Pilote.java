package Modele;

import java.util.ArrayList;
import java.util.List;

public class Pilote extends Employe{
    private String licence;
    private int heuresDeVol;
    private List<Vol> volsAssignes;

    // Constructeur
    public Pilote(int id, String nom, String adresse, String contact,
                  int numeroEmploye, String dateEmbauche, String licence, int heuresDeVol) {
        super(id, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
        this.volsAssignes = new ArrayList<>();
    }

    // Getters
    public String getLicence() {
        return licence;
    }

    public int getHeuresDeVol() {
        return heuresDeVol;
    }

    public List<Vol> getVolsAssignes() {
        return volsAssignes;
    }

    // Setters
    public void setHeuresDeVol(int heuresDeVol) {
        this.heuresDeVol = heuresDeVol;
    }

    @Override
    public String getRole() {
        return "Pilote";
    }

    // Méthode pour assigner un vol
    public void assignerVol(Vol vol) {
        volsAssignes.add(vol);
        System.out.println("Vol assigné au pilote : " + this.getNom());
    }

    // Méthode pour obtenir les vols assignés
    public void afficherVols() {
        System.out.println("Vols assignés pour le pilote " + this.getNom() + " :");
        for (Vol vol : volsAssignes) {
            System.out.println("  - " + vol.getNumeroVol());
        }
    }

    @Override
    public String toString() {
        return "Pilote{" +
                "licence='" + licence + '\'' +
                ", heuresDeVol=" + heuresDeVol +
                ", nombreVolsAssignes=" + volsAssignes.size() +
                '}';
    }
}
