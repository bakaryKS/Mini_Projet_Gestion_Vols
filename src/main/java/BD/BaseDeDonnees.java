package BD;
import Modele.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDonnees {
    private static final String FICHIER_BD = "database.txt";

    private List<Personne> personnes;
    private List<Employe> employes;
    private List<Passager> passagers;
    private List<Vol> vols;
    private List<Avion> avions;
    private List<Aeroport> aeroports;
    private List<Reservation> reservations;

    // Constructeur
    public BaseDeDonnees() {
        this.personnes = new ArrayList<>();
        this.employes = new ArrayList<>();
        this.passagers = new ArrayList<>();
        this.vols = new ArrayList<>();
        this.avions = new ArrayList<>();
        this.aeroports = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    // CRUD pour Passagers
    public void ajouterPassager(Passager passager) {
        passagers.add(passager);
        personnes.add(passager);
        sauvegarderDansFichier("SECTION PASSAGER",passager.toString());
        System.out.println("Passager ajouté: " + passager.getNom());
    }

    public Passager getPassager(int id) {
        for (Passager p : passagers) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public void modifierPassager(int id, String nom, String adresse, String contact) {
        Passager p = getPassager(id);
        if (p != null) {
            p.setNom(nom);
            p.setAdresse(adresse);
            p.setContact(contact);
            sauvegarderDansFichier("SECTION PASSAGER MODIFIER", p.toString());
        }
    }

    public void supprimerPassager(int id) {
        Passager p = getPassager(id);
        if (p != null) {
            passagers.remove(p);
            personnes.remove(p);
          //  sauvegarderDansFichier("PASSAGER_SUPPRIME", toString(id));
        }
    }

    public List<Passager> getTousLesPassagers() {
        return passagers;
    }

    // CRUD pour Pilotes
    public void ajouterPilote(Pilote pilote) {
        employes.add(pilote);
        personnes.add(pilote);
        sauvegarderDansFichier("SECTION PILOTE AJOUTE ", pilote.toString());
        System.out.println("Pilote ajouté: " + pilote.getNom());
    }

    public Pilote getPilote(int id) {
        for (Employe e : employes) {
            if (e.getId() == id && e instanceof Pilote) {
                return (Pilote) e;
            }
        }
        return null;
    }

    // CRUD pour Personnel de cabine
    public void ajouterPersonnelCabine(PersonnelCabine personnel) {
        employes.add(personnel);
        personnes.add(personnel);
        sauvegarderDansFichier("SECTION PERSONNEL CABINE AJOUTE ", personnel.toString());
        System.out.println("Personnel ajouté: " + personnel.getNom());
    }

    public PersonnelCabine getPersonnelCabine(int id) {
        for (Employe e : employes) {
            if (e.getId() == id && e instanceof PersonnelCabine) {
                return (PersonnelCabine) e;
            }
        }
        return null;
    }

    // CRUD pour Vols
    public void ajouterVol(Vol vol) {
        vols.add(vol);
        sauvegarderDansFichier("SECTION VOL AJOUTE ", vol.toString());
        System.out.println("Vol ajouté: " + vol.getNumeroVol());
    }

    public Vol getVol(String numeroVol) {
        for (Vol v : vols) {
            if (v.getNumeroVol().equals(numeroVol)) return v;
        }
        return null;
    }

    public void modifierVol(String numeroVol, String statut) {
        Vol v = getVol(numeroVol);
        if (v != null) {
            v.setStatut(statut);
            sauvegarderDansFichier("SECTION VOL MODIFIE ", v.toString());
        }
    }

    public void supprimerVol(String numeroVol) {
        Vol v = getVol(numeroVol);
        if (v != null) {
            vols.remove(v);
           // sauvegarderDansFichier("VOL_SUPPRIME: " + numeroVol);
        }
    }

    public List<Vol> getTousLesVols() {
        return vols;
    }

    // CRUD pour Avions
    public void ajouterAvion(Avion avion) {
        avions.add(avion);
        sauvegarderDansFichier("SECTION AVION AJOUTE: ", avion.toString());
        System.out.println("Avion ajouté: " + avion.getImmatriculation());
    }

    public Avion getAvion(String immatriculation) {
        for (Avion a : avions) {
            if (a.getImmatriculation().equals(immatriculation)) return a;
        }
        return null;
    }

    public List<Avion> getTousLesAvions() {
        return avions;
    }

    // CRUD pour Aéroports
    public void ajouterAeroport(Aeroport aeroport) {
        aeroports.add(aeroport);
        sauvegarderDansFichier("SECTION AEROPORT AJOUTE", aeroport.toString());
        System.out.println("Aéroport ajouté: " + aeroport.getNom());
    }

    public Aeroport getAeroport(String nom) {
        for (Aeroport a : aeroports) {
            if (a.getNom().equals(nom)) return a;
        }
        return null;
    }

    public List<Aeroport> getTousLesAeroports() {
        return aeroports;
    }

    // CRUD pour Réservations
    public void ajouterReservation(Reservation reservation) {
        reservations.add(reservation);
        sauvegarderDansFichier("SECTION RESERVATION AJOUTEE ", reservation.toString());
        System.out.println("Réservation ajoutée: " + reservation.getNumeroReservation());
    }

    public Reservation getReservation(int numeroReservation) {
        for (Reservation r : reservations) {
            if (r.getNumeroReservation() == numeroReservation) return r;
        }
        return null;
    }

    public List<Reservation> getToutesLesReservations() {
        return reservations;
    }

    // Sauvegarde dans fichier
    private void sauvegarderDansFichier(String section, String data) {
        try {
            File file = new File(FICHIER_BD);
            List<String> lignes = new ArrayList<>();

            // Lire tout le fichier
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String ligne;
                while ((ligne = br.readLine()) != null) {
                    lignes.add(ligne);
                }
            }

            // Trouver la section et insérer la donnée
            for (int i = 0; i < lignes.size(); i++) {
                if (lignes.get(i).equalsIgnoreCase("--- " + section + " ---")) {
                    lignes.add(i + 1, data); // insère juste après le titre
                    break;
                }
            }

            // Réécrire tout le fichier
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (String ligne : lignes) {
                    bw.write(ligne);
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            System.err.println("Erreur sauvegarde: " + e.getMessage());
        }
    }

    // Chargement fichier
    public void chargerDepuisFichier() {
        File file = new File(FICHIER_BD);
        if (!file.exists()) {
            System.out.println("Fichier inexistant. Création...");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println("Chargé: " + ligne);
            }
        } catch (IOException e) {
            System.err.println("Erreur chargement: " + e.getMessage());
        }
    }

    // Statistiques
    public void afficherStatistiques() {
        System.out.println("\n=== STATISTIQUES COMPAGNIE ===");
        System.out.println("Total Passagers: " + passagers.size());
        System.out.println("Total Employés: " + employes.size());
        System.out.println("Total Vols: " + vols.size());
        System.out.println("Total Avions: " + avions.size());
        System.out.println("Total Aéroports: " + aeroports.size());
        System.out.println("Total Réservations: " + reservations.size());
    }
}
