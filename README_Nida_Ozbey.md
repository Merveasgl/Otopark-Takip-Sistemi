# Otopark Doluluk ve Araç Takip Sistemi - Bireysel Çalışma Raporu

**Öğrenci:** Nida Özbey

**Görev Alanı:** Otopark Park Yeri Yönetimi, Araç Giriş/Silme İşlemleri ve Dosya Sistemi

**Sorumlu Olunan Veri Yapısı:** Çift Yönlü Bağlı Liste (Doubly Linked List)


---

## Üstlendiğim Görevler ve İşlevler
- Otoparka gelen araçların boş park yerlerine giriş kaydının oluşturulması ve aynı plakalı aracın içerideyken ikinci kez kaydedilmesinin engellenmesi.
- İçeride bulunmayan araç kayıtlarının veya henüz kullanılmamış park yerlerinin sistemden silinmesi.
- Veritabanı kullanılmadan tüm otopark verilerinin özel uzantılı metin dosyasına (`.otk`) kaydedilmesi ve program ilk açıldığında dosyadan okunarak veri yapısına aktarılması.
- Ana otopark ekranının ve anlık park yeri doluluk ızgarasının (boş ve dolu yerlerin görselleştirilmesi) arayüzünün (GUI) tasarlanması.

## Kullanılan Veri Yapısı ve Tercih Nedeni
- **Veri Yapısı:** Çift Yönlü Bağlı Liste (Doubly Linked List)
- **Tercih Nedeni:**
  * Otoparka gün içerisinde giriş ve çıkış yapan araç sayısı sürekli değiştiği için sabit boyutlu dizi (array) yerine belleği ihtiyaca göre dinamik olarak kullanan bağlı liste yapısını tercih ettik.
  * Herhangi bir park yerindeki araç kaydı silindiğinde veya araç çıkış yaptığında, tek yönlü bağlı listedeki gibi önceki düğümü bulmak için listeyi baştan taramak yerine `onceki` (prev) ve `sonraki` (next) referansları sayesinde düğümü doğrudan aradan çıkarabilmek için çift yönlü bağlı liste kurduk.

## Temel Sınıf ve Düğüm Taslağı
- **`ParkDugum` (Düğüm Sınıfı):**
  * `String plaka`: Aracın plakası
  * `String parkYeriNo`: Aracın park ettiği yerin kodu (Örn: A-01)
  * `String aracSahibi`: Araç sahibinin adı ve soyadı
  * `String girisSaati`: Aracın otoparka giriş yaptığı saat
  * `ParkDugum sonraki`: Listedeki bir sonraki aracı gösteren referans (next)
  * `ParkDugum onceki`: Listedeki bir önceki aracı gösteren referans (prev)
- **`OtoparkBagliListe` (Bağlı Liste Sınıfı):**
  * `ParkDugum bas`: Listenin ilk düğümünü tutan referans (head)
  * `ParkDugum son`: Listenin son düğümünü tutan referans (tail)
  * `int kapasite`: Otoparkın maksimum araç kapasitesi
  * `int aracSayisi`: İçeride bulunan mevcut araç sayısı
  * `aracEkle(String plaka, String parkYeriNo, String aracSahibi, String girisSaati)`: Plaka ve kapasite kontrolü yaparak listenin sonuna yeni araç ekleme
  * `aracSil(String plaka)`: Plakası verilen aracın düğüm bağlantılarını kopararak listeden silme
  * `plakaVarMi(String plaka)`: Aynı plakalı aracın içeride olup olmadığını kontrol etme
  * `listele()`: Otoparktaki mevcut araçları baştan sona ekrana yazdırma
