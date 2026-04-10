package Modele;

import Modele.*;

import java.util.ArrayList;
import java.util.List;

public class Vol {
    private String numeroVol;
    private String origine;
    private String destination;
    private String heureDepart;
    private String heureArrivee;
    private String statut;
    private Avion avion;
    private Pilote pilote;
    private PersonnelCabine personnelCabine;
    private Aeroport aeroportOrigine;
    private Aeroport aeroportDestination;
    private List<Passager> passagers;

    // Constructeur
    public Vol(String numeroVol, String origine, String destination,
               String heureDepart, String heureArrivee, String statut) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.statut = statut;
        this.passagers = new ArrayList<>();
    }

    // Getters
    public String getNumeroVol() {
        return numeroVol;
    }

    public String getOrigine() {
        return origine;
    }

    public String getDestination() {
        return destination;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public String getHeureArrivee() {
        return heureArrivee;
    }

    public String getStatut() {
        return statut;
    }

    public Avion getAvion() {
        return avion;
    }

    public Pilote getPilote() {
        return pilote;
    }

    public PersonnelCabine getPersonnelCabine() {
        return personnelCabine;
    }

    public List<Passager> getPassagers() {
        return passagers;
    }

    // Setters
    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }

    public void setPersonnelCabine(PersonnelCabine personnelCabine) {
        this.personnelCabine = personnelCabine;
    }

    // Méthodes de gestion du vol
    public void planifierVol() {
        System.out.println("Le vol " + numeroVol + " a été planifié de " +
                origine + " à " + destination);
    }

    public void annulerVol() {
        this.statut = "Annulé";
        System.out.println("Le vol " + numeroVol + " a été annulé");
    }

    public void modifierVol(String heureDepart, String heureArrivee) {
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        System.out.println("Le vol " + numeroVol + " a été modifié");
    }

    public void ajouterPassager(Passager passager) {
        if (avion != null && passagers.size() < avion.getCapacite()) {
            passagers.add(passager);
            System.out.println("Passager " + passager.getNom() + " ajouté au vol " + numeroVol);
        } else {
            System.out.println("Impossible d'ajouter le passager - vol complet ou aucun avion assigné");
        }
    }

    public void afficherVol() {
        System.out.println("Informations du vol :");
        System.out.println("  Numéro : " + numeroVol);
        System.out.println("  Origine : " + origine);
        System.out.println("  Destination : " + destination);
        System.out.println("  Départ : " + heureDepart);
        System.out.println("  Arrivée : " + heureArrivee);
        System.out.println("  Statut : " + statut);
        if (avion != null) {
            System.out.println("  Avion : " + avion.getModele());
        }
        System.out.println("  Nombre de passagers : " + passagers.size());
    }

    @Override
    public String toString() {
        return "Vol{" +
                "numeroVol='" + numeroVol + '\'' +
                ", origine='" + origine + '\'' +
                ", destination='" + destination + '\'' +
                ", statut='" + statut + '\'' +
                '}';
    }
}