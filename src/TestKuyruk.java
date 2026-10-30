public class TestKuyruk {
    public static void main(String[] args) {
        OtoYikamaKuyruk yikamaKuyrugu = new OtoYikamaKuyruk();

        System.out.println("=== OTO YIKAMA KUYRUK TESTI ===");

        yikamaKuyrugu.ekle("23 SY 101");        // Sıraya arac ekleme (FIFO testi)
        yikamaKuyrugu.ekle("34 BM 202");
        yikamaKuyrugu.ekle("06 NY 303");

        System.out.println("Siradaki toplam arac sayisi: " + yikamaKuyrugu.getElemanSayisi());

        if (yikamaKuyrugu.ilkArac() != null) {
            System.out.println("Sirada bekleyen ilk arac: " + yikamaKuyrugu.ilkArac().plaka);
        }

        System.out.println("\n--- Yikama Islemleri Basliyor ---");

        AracDugum yikanan1 = yikamaKuyrugu.cikar();      // Sıradan arac cikarma (ilk giren çıkar)
        if (yikanan1 != null) {
            System.out.println("Yikamaya alindi: " + yikanan1.plaka);
        }

        AracDugum yikanan2 = yikamaKuyrugu.cikar();
        if (yikanan2 != null) {
            System.out.println("Yikamaya alindi: " + yikanan2.plaka);
        }

        System.out.println("\nKalan toplam arac: " + yikamaKuyrugu.getElemanSayisi());
    }
}
