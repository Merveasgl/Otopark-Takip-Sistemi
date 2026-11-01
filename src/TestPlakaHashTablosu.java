public class TestPlakaHashTablosu {
    public static void main(String[] args) {
        OtoparkBagliListe liste = new OtoparkBagliListe(10);
        liste.aracEkle("44 AB 123", "A-01", "Ali", "10:00");
        liste.aracEkle("34 CD 456", "A-02", "Ayse", "11:00");
        PlakaHashTablosu hash = new PlakaHashTablosu();
        // Bagli listedeki araclari hash tablosuna ekle
        ParkDugum d = liste.bas;
        while (d != null) {
            hash.ekle(d);
            d = d.sonraki;
        }
        // Arama testi
        ParkDugum bulunan = hash.ara("44ab123");
        System.out.println("Aranan park yeri: " +
            (bulunan == null ? "Bulunamadi" : bulunan.parkYeriNo));
        // Ayni plakayi tekrar ekleme testi
        System.out.println("Tekrar ekleme: " + hash.ekle(liste.bas));
        // Silme testi
        System.out.println("Indeksten silme: " + hash.sil("44 AB 123"));
        System.out.println("Arac indekste var mi: " +
            (hash.ara("44 AB 123") != null));
    }
}
