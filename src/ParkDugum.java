public class ParkDugum {
    String plaka;
    String parkYeriNo;
    String aracSahibi;
    String girisSaati;

    ParkDugum sonraki;
    ParkDugum onceki;

    public ParkDugum(String plaka, String parkYeriNo, String aracSahibi, String girisSaati) {
        this.plaka = plaka;
        this.parkYeriNo = parkYeriNo;
        this.aracSahibi = aracSahibi;
        this.girisSaati = girisSaati;
        this.sonraki = null;
        this.onceki = null;
    }
}
