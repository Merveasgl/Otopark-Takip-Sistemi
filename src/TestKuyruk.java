public class TestKuyruk {
    public static void main(String[] args) throws InterruptedException {
        OtoYikamaKuyruk yikamaKuyrugu = new OtoYikamaKuyruk();
        double birimUcret = 25.0; // Saniye basina ornek ucret

        System.out.println("=== OTO YIKAMA KUYRUK TESTI ===");
        yikamaKuyrugu.ekle("23 SY 101");        // Siraya arac ekleme (FIFO testi)
        yikamaKuyrugu.ekle("34 BM 202");
        yikamaKuyrugu.ekle("06 NY 303");

        System.out.println("Siradaki toplam arac sayisi: " + yikamaKuyrugu.getElemanSayisi());

        if (yikamaKuyrugu.ilkArac() != null) {
            System.out.println("Sirada bekleyen ilk arac: " + yikamaKuyrugu.ilkArac().plaka);
        }

        System.out.println("\n--- Yikama Islemleri Basliyor ---");

        Thread.sleep(2000); // Sure farkini gormek icin 2 saniye bekleme

        AracDugum yikanan1 = yikamaKuyrugu.cikar();      // Siradan arac cikarma (ilk giren cikar)
        if (yikanan1 != null) {
            long sure1 = yikamaKuyrugu.gecenSaniye(yikanan1);
            double ucret1 = yikamaKuyrugu.ucretHesapla(yikanan1, birimUcret);
            System.out.println("Yikamaya alindi: " + yikanan1.plaka + " | Sure: " + sure1 + " sn | Ucret: " + ucret1 + " TL");
        }

        Thread.sleep(1000); // Ikinci arac icin 1 saniye daha bekleme

        AracDugum yikanan2 = yikamaKuyrugu.cikar();
        if (yikanan2 != null) {
            long sure2 = yikamaKuyrugu.gecenSaniye(yikanan2);
            double ucret2 = yikamaKuyrugu.ucretHesapla(yikanan2, birimUcret);
            System.out.println("Yikamaya alindi: " + yikanan2.plaka + " | Sure: " + sure2 + " sn | Ucret: " + ucret2 + " TL");
        }

        System.out.println("\nKalan toplam arac: " + yikamaKuyrugu.getElemanSayisi());
    }
}
