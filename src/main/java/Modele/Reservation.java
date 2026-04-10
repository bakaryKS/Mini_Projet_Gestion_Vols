package Modele;

public class Reservation {
    private static int nombreDeReservations = 1000;
    private int numeroReservation;
    private int idPassager;
    private String numeroVol;
    private String dateReservation;
    private String statut;

    // Constructeur
    public Reservation(int idPassager, String numeroVol, String dateReservation, String statut) {
        this.numeroReservation = nombreDeReservations++;
        this.idPassager = idPassager;
        this.numeroVol = numeroVol;
        this.dateReservation = dateReservation;
        this.statut = statut;
    }

    // Getters
    public int getNumeroReservation() {
        return numeroReservation;
    }

    public int getIdPassager() {
        return idPassager;
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public String getStatut() {
        return statut;
    }

    // Setters
    public void setStatus(String statut) {
        this.statut = statut;
    }

    // Méthodes de gestion des réservations
    public void confirmationReservation() {
        this.statut = "Confirmee";
        System.out.println("Reservation " + numeroReservation + " confirmee");
    }

    public void annulerReservation() {
        this.statut = "annulee";
        System.out.println("Reservation " + numeroReservation + " annulee");
    }

    public void modifierReservation(String nouveauNumVol) {
        this.numeroVol = nouveauNumVol;
        System.out.println("Reservation " + numeroReservation + " modifiee");
    }

    public void getReservations() {
        System.out.println(" Information Reservation :");
        System.out.println(" Numero Reservation : " + numeroReservation);
        System.out.println(" ID Passenger : " + idPassager);
        System.out.println(" Numero vol: " + numeroVol);
        System.out.println(" Date Reservation : " + dateReservation);
        System.out.println(" Statut: " + statut);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "numeroReservation=" + numeroReservation +
                ", idPassager=" + idPassager +
                ", numeroVol='" + numeroVol + '\'' +
                ", dateReservation='" + dateReservation + '\'' +
                ", statut='" + statut + '\'' +
                '}';
    }
}
