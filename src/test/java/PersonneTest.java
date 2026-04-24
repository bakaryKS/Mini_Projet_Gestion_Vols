import Modele.Personne;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PersonneTest {


    class PersonneTestable extends Personne {
        public PersonneTestable(int id, String nom, String adresse, String contact) {
            super(id, nom, adresse, contact);
        }
    }

    @Test
    void testCreationPersonne() {
        Personne p = new PersonneTestable(1, "Ali", "Paris", "123456");

        assertEquals(1, p.getId());
        assertEquals("Ali", p.getNom());
        assertEquals("Paris", p.getAdresse());
        assertEquals("123456", p.getContact());
    }

    @Test
    void testSetNom() {
        Personne p = new PersonneTestable(1, "Ali", "Paris", "123456");

        p.setNom("Ahmed");

        assertEquals("Ahmed", p.getNom());
    }

    @Test
    void testSetAdresse() {
        Personne p = new PersonneTestable(1, "Ali", "Paris", "123456");

        p.setAdresse("Lyon");

        assertEquals("Lyon", p.getAdresse());
    }

    @Test
    void testToString() {
        Personne p = new PersonneTestable(1, "Ali", "Paris", "123456");

        String result = p.toString();

        assertTrue(result.contains("Ali"));
        assertTrue(result.contains("Paris"));
    }
}