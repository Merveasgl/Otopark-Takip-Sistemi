public class ParkDugum {
    String plaka;
    String parkYeriNo;
    String aracSahibi;
    String girisSaati;

    ParkDugum sonraki; //bir sonraki araca giden bağlantı
    ParkDugum onceki; //geriye giden bağlantı

    public ParkDugum(String plaka, String parkYeriNo, String aracSahibi, String girisSaati) {
        this.plaka = plaka;
        this.parkYeriNo = parkYeriNo;
        this.aracSahibi = aracSahibi;
        this.girisSaati = girisSaati;
        this.sonraki = null;
        this.onceki = null;
    }
}

