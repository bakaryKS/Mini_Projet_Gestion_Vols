package Modele;

public abstract class Personne {
        private int id;
        private String nom;
        private String adresse;
        private String contact;


        public Personne(int id, String nom, String adresse, String contact) {
            this.id = id;
            this.nom = nom;
            this.adresse = adresse;
            this.contact = contact;
        }

        // Getters
        public int getId() {
            return id;
        }

        public String getNom() {
            return nom;
        }

        public String getAdresse() {
            return adresse;
        }

        public String getContact() {
            return contact;
        }

        // Setters
        public void setName(String nom) {
            this.nom = nom;
        }

        public void setAddress(String adresse) {
            this.adresse = adresse;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        // Méthode pour afficher les informations
        public void getInfos() {
            System.out.println("ID: " + id + ", Name: " + nom +
                    ", Address: " + adresse + ", Contact: " + contact);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + nom + '\'' +
                    ", address='" + adresse + '\'' +
                    ", contact='" + contact + '\'' +
                    '}';
        }

    public void setNom(String nom) {
            this.nom = nom;
    }

    public void setAdresse(String adresse) {
            this.adresse = adresse;
    }
}
