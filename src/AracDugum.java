public class AracDugum {
    String plaka;
    long girisZamani;
    AracDugum sonraki;   // bir sonraki aracı gosterir

    
    public AracDugum(String plaka) {  //sadece dışarıdan gerekli bilgileri aldık 
        this.plaka = plaka;
        this.girisZamani = System.currentTimeMillis();   //sisteme giriş anı
        this.sonraki = null;  //yeni gelen aracın arkası ilk başta boş
    }
}
