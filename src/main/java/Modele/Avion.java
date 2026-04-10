package Modele;

import java.util.ArrayList;
import java.util.List;

public class Avion {

    private String immatriculation;
    private String modele;
    private int capacite;
    private List<Vol> vols;

    // Constructeur
    public Avion(String immatriculation, String modele, int capacite) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.capacite = capacite;
        this.vols = new ArrayList<>();
    }

    // Getters
    public String getImmatriculation() {
        return immatriculation;
    }

    public String getModele() {
        return modele;
    }

    public int getCapacite() {
        return capacite;
    }

    public List<Vol> getVols() {
        return vols;
    }

    // Setters
    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    // Méthode pour assigner un vol
    public void assignerVol(Vol vol) {
        vols.add(vol);
        vol.setAvion(this);
        System.out.println("Vol assigné à l'avion : " + immatriculation);
    }

    // Méthode pour vérifier la disponibilité
    public boolean verifierDisponibilite(String heureDepart, String heureArrivee) {
        for (Vol vol : vols) {
            if (vol.getHeureDepart().equals(heureDepart) ||
                    vol.getHeureArrivee().equals(heureArrivee)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "immatriculation='" + immatriculation + '\'' +
                ", modele='" + modele + '\'' +
                ", capacite=" + capacite +
                '}';
    }}
