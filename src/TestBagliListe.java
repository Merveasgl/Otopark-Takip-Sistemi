public class TestBagliListe {
    public static void main(String[] args) {
        OtoparkBagliListe liste = new OtoparkBagliListe(10);

        liste.aracEkle("44 AB 123", "A-01", "Ali Yilmaz", "10:00");
        liste.aracEkle("34 CD 456", "A-02", "Ayse Demir", "10:30");

        liste.listele();
    }
}
