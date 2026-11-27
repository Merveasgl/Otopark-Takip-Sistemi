public class OtoparkBagliListe {
    ParkDugum bas; // listenin ilk dugumu
    ParkDugum son; // listenin son dugumu
    int kapasite;
    int aracSayisi;

    public OtoparkBagliListe(int kapasite) {
        this.bas = null;
        this.son = null;
        this.kapasite = kapasite;
        this.aracSayisi = 0;
    }

    public boolean plakaVarMi(String plaka) {
        ParkDugum gecici = bas;
        while (gecici != null) {
            if (gecici.plaka.equalsIgnoreCase(plaka)) {
                return true;
            }
            gecici = gecici.sonraki;
        }
        return false;
    }

    public boolean parkYeriDoluMu(String parkYeriNo) {
        ParkDugum gecici = bas;
        while (gecici != null) {
            if (gecici.parkYeriNo.equalsIgnoreCase(parkYeriNo)) {
                return true;
            }
            gecici = gecici.sonraki;
        }
        return false;
    }

    public boolean aracEkle(String plaka, String parkYeriNo, String aracSahibi, String girisSaati) {
        // eklemeden once kapasite, plaka ve yer kontrolu
        if (aracSayisi >= kapasite) {
            System.out.println("Hata: Otopark dolu! (" + plaka + " eklenemedi)");
            return false;
        }
        if (plakaVarMi(plaka)) {
            System.out.println("Hata: " + plaka + " plakali arac zaten iceride!");
            return false;
        }
        if (parkYeriDoluMu(parkYeriNo)) {
            System.out.println("Hata: " + parkYeriNo + " numarali park yeri dolu!");
            return false;
        }

        ParkDugum yeni = new ParkDugum(plaka, parkYeriNo, aracSahibi, girisSaati);

        if (bas == null) {
            bas = yeni;
            son = yeni;
        } else {
            son.sonraki = yeni; // ileri bag
            yeni.onceki = son;  // geri bag
            son = yeni;
        }

        aracSayisi++;
        System.out.println("Eklendi: " + plaka + " -> " + parkYeriNo);
        return true;
    }

    public boolean aracSil(String plaka) {
        ParkDugum gecici = bas;

        // silinecek plakayi bulana kadar gez
        while (gecici != null && !gecici.plaka.equalsIgnoreCase(plaka)) {
            gecici = gecici.sonraki;
        }

        if (gecici == null) {
            System.out.println("Hata: " + plaka + " plakali arac bulunamadi.");
            return false;
        }

        if (gecici == bas && gecici == son) { // tek eleman varsa
            bas = null;
            son = null;
        } else if (gecici == bas) { // bastan silme
            bas = bas.sonraki;
            bas.onceki = null;
        } else if (gecici == son) { // sondan silme
            son = son.onceki;
            son.sonraki = null;
        } else { // aradan silme
            gecici.onceki.sonraki = gecici.sonraki;
            gecici.sonraki.onceki = gecici.onceki;
        }

        aracSayisi--;
        System.out.println("Silindi: " + plaka);
        return true;
    }

    public void listele() {
        if (bas == null) {
            System.out.println("Otopark su an bos.");
            return;
        }
        System.out.println("--- Otoparktaki Araclar (" + aracSayisi + "/" + kapasite + ") ---");
        ParkDugum gecici = bas;
        while (gecici != null) {
            System.out.println(gecici.parkYeriNo + " - " + gecici.plaka + " (" + gecici.aracSahibi + " | " + gecici.girisSaati + ")");
            gecici = gecici.sonraki;
        }
    }
}