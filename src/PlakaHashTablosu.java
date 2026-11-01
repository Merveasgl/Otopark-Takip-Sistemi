import java.util.Locale;
public class PlakaHashTablosu {
    private static class HashDugum {
        ParkDugum arac;
        HashDugum sonraki;

        HashDugum(ParkDugum arac, HashDugum sonraki) {
            this.arac = arac;
            this.sonraki = sonraki;
        }
    }
    private HashDugum[] tablo = new HashDugum[17];
    // Plakayi arama icin duzenler
    private String duzenle(String plaka) {
        return plaka.replaceAll("\\s+", "")
                    .toUpperCase(Locale.ROOT);
    }
    // Plakanin tablodaki yerini bulur
    private int hash(String plaka) {
        return Math.floorMod(
            duzenle(plaka).hashCode(), tablo.length
        );
    }
    // Plakaya gore arac arar
    public ParkDugum ara(String plaka) {
        if (plaka == null || plaka.trim().isEmpty())
            return null;
        for (HashDugum d = tablo[hash(plaka)];
             d != null; d = d.sonraki) {
            if (duzenle(d.arac.plaka).equals(duzenle(plaka)))
                return d.arac;
        }
        return null;
    }
    // Yeni arac ekler
    public boolean ekle(ParkDugum arac) {
        if (arac == null || arac.plaka == null ||
            arac.plaka.trim().isEmpty()) return false;
        if (ara(arac.plaka) != null) return false;
        int i = hash(arac.plaka);
        tablo[i] = new HashDugum(arac, tablo[i]);
        return true;
    }
    // Hash tablosundan plaka kaydini siler
    public boolean sil(String plaka) {
        if (plaka == null || plaka.trim().isEmpty())
            return false;
        int i = hash(plaka);
        HashDugum onceki = null, d = tablo[i];
        while (d != null) {
            if (duzenle(d.arac.plaka).equals(duzenle(plaka))) {
                if (onceki == null)
                    tablo[i] = d.sonraki;
                else
                    onceki.sonraki = d.sonraki;
                return true;
            }
            onceki = d;
            d = d.sonraki;
        }
        return false;
    }
}

