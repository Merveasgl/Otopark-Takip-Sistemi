import java.util.Stack;

public class UndoStack {

    private Stack<Islem> islemler;

    public UndoStack() {
        islemler = new Stack<>();
    }

    // Yeni işlemi stack'a ekleme
    public void islemEkle(Islem islem) {
        islemler.push(islem);
    }

    // Son işlemi geri almak için çıkarma
    public Islem geriAl() {
        if (!islemler.isEmpty()) {
            return islemler.pop();
        }
        return null;
    }

    // Son işlemi görüntüleme
    public Islem sonIslem() {
        if (!islemler.isEmpty()) {
            return islemler.peek();
        }
        return null;
    }

    // Stack'ın boş olup olmadığını kontrol etme
    public boolean bosMu() {
        return islemler.isEmpty();
    }

    // Stack'taki işlem sayısı
    public int boyut() {
        return islemler.size();
    }
}
