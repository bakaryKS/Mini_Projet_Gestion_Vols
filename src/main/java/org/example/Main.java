package org.example;

import BD.BaseDeDonnees;
import Modele.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== SYSTEME DE GESTION AERIENNE - TEST ===\n");

        BaseDeDonnees bd = new BaseDeDonnees();

        // Test 1 : Créer et afficher un passager
        System.out.println("--- Test 1 : Gestion des passagers ---");
        Passager passager1 = new Passager(1, "Bakary SACKO", "10 WQ St", "555-0001", "FR123456");
        bd.ajouterPassager(passager1);
        passager1.getInfos();
        System.out.println();

        // Test 2 : Créer un aéroport
        System.out.println("--- Test 2 : Gestion des aéroports ---");
        Aeroport aeroport1 = new Aeroport("JFK", "New York", "John F. Kennedy International");
        Aeroport aeroport2 = new Aeroport("LHR", "London", "London Heathrow");
        bd.ajouterAeroport(aeroport1);
        bd.ajouterAeroport(aeroport2);
        System.out.println();

        // Test 3 : Créer un avion
        System.out.println("--- Test 3 : Gestion des avions ---");
        Avion avion1 = new Avion("N12345", "Boeing 747", 300);
        bd.ajouterAvion(avion1);
        System.out.println();

        // Test 4 : Créer un vol
        System.out.println("--- Test 4 : Gestion des vols ---");
        Vol vol1 = new Vol("AA100", "New York", "London",
                "08:00", "20:00", "Prévu");
        bd.ajouterVol(vol1);
        vol1.planifierVol();
        avion1.assignerVol(vol1);
        System.out.println();

        // Test 5 : Créer et assigner un pilote
        System.out.println("--- Test 5 : Gestion des pilotes ---");
        Pilote pilote1 = new Pilote(100, "John Smith", "123 Pilot St",
                "555-1234", 5001, "2010-03-15",
                "ATPL", 15000);
        bd.ajouterPilote(pilote1);
        System.out.println("Rôle : " + pilote1.getRole());
        pilote1.assignerVol(vol1);
        vol1.setPilote(pilote1);
        System.out.println();

        // Test 6 : Créer et assigner un personnel de cabine
        System.out.println("--- Test 6 : Gestion du personnel de cabine ---");
        PersonnelCabine personnel1 = new PersonnelCabine(200, "Emily Brown", "456 Staff Ave",
                "555-5678", 6001, "2015-07-20",
                "Chef de cabine");
        bd.ajouterPersonnelCabine(personnel1);
        System.out.println("Rôle : " + personnel1.getRole());
        personnel1.assignerVol(vol1);
        vol1.setPersonnelCabine(personnel1);
        System.out.println();

        // Test 7 : Réserver un vol
        System.out.println("--- Test 7 : Réservation de vol ---");
        Reservation reservation1 = passager1.reserverVol(vol1, "2024-12-01", "Confirmée");
        bd.ajouterReservation(reservation1);
        reservation1.confirmationReservation();
        reservation1.toString();
        System.out.println();

        // Test 8 : Ajouter un passager au vol
        System.out.println("--- Test 8 : Ajouter un passager au vol ---");
        vol1.ajouterPassager(passager1);
        System.out.println();

        // Test 9 : Afficher les infos du vol
        System.out.println("--- Test 9 : Informations du vol ---");
        vol1.afficherVol();
        System.out.println();

        // Test 10 : Vérifier la disponibilité de l'avion
        System.out.println("--- Test 10 : Vérifier la disponibilité de l'avion ---");
        boolean disponible = avion1.verifierDisponibilite("08:00", "20:00");
        System.out.println("Avion disponible pour ce créneau : " + disponible);
        System.out.println();

        // Test 11 : Afficher les statistiques
        System.out.println("--- Test 11 : Affichage des statistiques ---");
        bd.afficherStatistiques();
        System.out.println();

        System.out.println("=== TOUS LES TESTS SONT TERMINES ===");
    }

}