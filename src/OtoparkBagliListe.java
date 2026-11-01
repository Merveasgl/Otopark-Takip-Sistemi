public class OtoparkBagliListe {
    ParkDugum bas;
    ParkDugum son;
    int kapasite;
    int aracSayisi;

    public OtoparkBagliListe(int kapasite) {
        this.bas = null;
        this.son = null;
        this.kapasite = kapasite;
        this.aracSayisi = 0;
    }

    public void aracEkle(String plaka, String parkYeriNo, String aracSahibi, String girisSaati) {
        ParkDugum yeni = new ParkDugum(plaka, parkYeriNo, aracSahibi, girisSaati);

        if (bas == null) {
            bas = yeni;
            son = yeni;
        } else {
            son.sonraki = yeni;
            yeni.onceki = son;
            son = yeni;
        }
        aracSayisi++;
    }

    public void listele() {
        ParkDugum gecici = bas;
        while (gecici != null) {
            System.out.println(gecici.parkYeriNo + " - " + gecici.plaka + " (" + gecici.aracSahibi + ")");
            gecici = gecici.sonraki;
        }
    }

    public void aracSil(String plaka) {
        // Silme islemi sonraki asamada eklenecek
    }

    public boolean plakaVarMi(String plaka) {
        // Plaka kontrolu sonraki asamada eklenecek
        return false;
    }
}

