import Modele.Reservation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ReservationTest {
    @Test
    void testCreationReservation() {
        Reservation r = new Reservation(1, "TO350", "2024-12-10", "Confirmée");

        assertEquals(1, r.getIdPassager());
        assertEquals("TO350", r.getNumeroVol());
        assertEquals("2024-12-10", r.getDateReservation());
        assertEquals("Confirmée", r.getStatut());
    }



    @Test
    void testAnnulerReservation() {
        Reservation r = new Reservation(1, "TO350", "2024-12-10", "Confirmee");

        r.annulerReservation();

        assertEquals("annulee", r.getStatut());
    }

    @Test
    void testModifierReservation() {
        Reservation r = new Reservation(1, "TO350", "2024-12-10", "en attente");

        r.modifierReservation("TO999");

        assertEquals("TO999", r.getNumeroVol());
    }

    @Test
    void testSetStatus() {
        Reservation r = new Reservation(1, "TO350", "2024-12-10", "en attente");

        r.setStatus("Confirmee");

        assertEquals("Confirmee", r.getStatut());
    }

    @Test
    void testNumeroReservationAutoIncrement() {
        Reservation r1 = new Reservation(1, "TO350", "2024-12-10", "en attente");
        Reservation r2 = new Reservation(2, "TO351", "2024-12-11", "en attente");

        assertTrue(r2.getNumeroReservation() > r1.getNumeroReservation());
    }


}
