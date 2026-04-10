package Modele;

import Modele.Personne;
import Modele.Reservation;

import java.util.ArrayList;
import java.util.List;

public class Passager extends Personne {

        private String passport;
        private List<Reservation> reservations;

        // Constructeur
        public Passager(int id, String nom, String adresse, String contact, String passport) {
            super(id, nom, adresse, contact);
            this.passport = passport;
            this.reservations = new ArrayList<>();
        }


        // Getters
        public String getPassport() {
            return passport;
        }

        public List<Reservation> getReservations() {
            return reservations;
        }

        // Setters
        public void setPassport(String passport) {
            this.passport = passport;
        }

        // Méthode pour réserver un vol
        public Reservation reserverVol(Vol vol, String dateReservation, String status) {
            Reservation reservation = new Reservation(
                    this.getId(),
                    vol.getNumeroVol(),
                    dateReservation,
                    status
            );
            reservations.add(reservation);
            System.out.println("Reservation reussie merci pour votre confiance! Booking ID: " + reservation.getNumeroReservation());
            return reservation;
        }

        // Méthode pour annuler une réservation
        public void annulerVol(int idReservation) {
            for (Reservation reservation : reservations) {
                if (reservation.getNumeroReservation() == idReservation) {
                    reservations.remove(reservation);
                    System.out.println("Reservation annulee avec succes !");
                    return;
                }
            }
            System.out.println("Reservation non trouvee!");
        }

        @Override
        public String toString() {
            return "Passager{" +
                    "passport='" + passport + '\'' +
                    ", reservations=" + reservations.size() +
                    '}';
        }

}
