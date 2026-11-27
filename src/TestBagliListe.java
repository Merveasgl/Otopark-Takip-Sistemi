public class TestBagliListe {
    public static void main(String[] args) {
        OtoparkBagliListe liste = new OtoparkBagliListe(3);

        liste.aracEkle("44 AB 123", "A-01", "Ali Yilmaz", "10:00");
        liste.aracEkle("34 CD 456", "A-02", "Ayse Demir", "10:30");
        liste.aracEkle("23 EF 789", "A-03", "Mehmet Kaya", "11:00");

        // kapasite dolu testi
        liste.aracEkle("06 GH 111", "A-04", "Can Ak", "11:15");

        liste.listele();

        // ortadan silip ayni plaka ve dolu yer denemesi
        liste.aracSil("34 CD 456");
        liste.aracEkle("44 AB 123", "A-02", "Tekrar Plaka", "11:30");
        liste.aracEkle("01 XY 999", "A-01", "Dolu Yer", "11:35");

        // bastan, sondan ve olmayan plaka silme
        liste.aracSil("44 AB 123");
        liste.aracSil("23 EF 789");
        liste.aracSil("99 ZZ 000");

        liste.listele();
    }
}