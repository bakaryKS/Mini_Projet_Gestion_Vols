import Modele.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VolTest {

    @Test
    void testCreationVol() {
        Vol vol = new Vol("TO350", "Paris", "Rome", "10:15", "12:00", "Planifié");

        assertEquals("TO350", vol.getNumeroVol());
        assertEquals("Paris", vol.getOrigine());
        assertEquals("Rome", vol.getDestination());
        assertEquals("10:15", vol.getHeureDepart());
        assertEquals("12:00", vol.getHeureArrivee());
        assertEquals("Planifié", vol.getStatut());
        assertTrue(vol.getPassagers().isEmpty());
    }

    @Test
    void testSetStatut() {
        Vol vol = new Vol("TO350", "Paris", "Rome", "10:15", "12:00", "Planifié");

        vol.setStatut("Retardé");

        assertEquals("Retardé", vol.getStatut());
    }

    @Test
    void testAnnulerVol() {
        Vol vol = new Vol("TO350", "Paris", "Rome", "10:15", "12:00", "Planifié");

        vol.annulerVol();

        assertEquals("Annulé", vol.getStatut());
    }

    @Test
    void testModifierVol() {
        Vol vol = new Vol("TO350", "Paris", "Rome", "10:15", "12:00", "Planifié");

        vol.modifierVol("11:00", "12:45");

        assertEquals("11:00", vol.getHeureDepart());
        assertEquals("12:45", vol.getHeureArrivee());
    }




    @Test
    void testAjouterPassagerSansAvion() {
        Vol vol = new Vol("TO350", "Paris", "Rome", "10:15", "12:00", "Planifié");
        Passager passager = new Passager(1, "Ali", "Paris", "0600000000", "P12345");

        vol.ajouterPassager(passager);

        assertEquals(0, vol.getPassagers().size());
    }


    @Test
    void testToString() {
        Vol vol = new Vol("TO350", "Paris", "Rome", "10:15", "12:00", "Planifié");

        String result = vol.toString();

        assertTrue(result.contains("TO350"));
        assertTrue(result.contains("Paris"));
        assertTrue(result.contains("Rome"));
        assertTrue(result.contains("Planifié"));
    }
}