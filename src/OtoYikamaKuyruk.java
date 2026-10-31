public class OtoYikamaKuyruk {
    private AracDugum bas;   //ilk yikanacak arac
    private AracDugum son;   //siradaki son arac
    private int elemanSayisi;

    public OtoYikamaKuyruk() {    // Kuyruk ilk oluştuğunda ici bostur
        this.bas = null;
        this.son = null;
        this.elemanSayisi = 0;
    }

    public boolean bosMu() {    // Sirada arac var mi yok mu kontrolu
        return bas == null;
    }
    
  
    public void ekle(String plaka) {     // Siranin sonuna yeni araç ekleme
        AracDugum yeniArac = new AracDugum(plaka);
        if (bosMu()) {     
            bas = yeniArac;
            son = yeniArac;
        } else {
            son.sonraki = yeniArac;
            son = yeniArac;
        }
        elemanSayisi++;
    }

    public AracDugum cikar() {     // Siranin basindaki araci yikamaya alıp almama sonrada sıradan cikarma
        if (bosMu()) {
            System.out.println("Kuyruk bos, yikanacak arac yok.");
            return null;
        }
        AracDugum cikanArac = bas;       // çıkan aractan sonra sıra tamamen bosaldıysa sonu da sıfırlıyoruz
        bas = bas.sonraki;
        if (bas == null) {
            son = null;
        }
        elemanSayisi--;
        return cikanArac;
    }
    public AracDugum ilkArac() {    
        return bas;
    }
    public int getElemanSayisi() {
        return elemanSayisi;
    }
}
