
# Otopark Doluluk ve Araç Takip Sistemi - Bireysel Çalışma Raporu

**Öğrenci:** Merve Asağlı

**Görev Alanı:** Sorgulama, Sıralama ve Anlık İstatistik Paneli

**Sorumlu Olunan Veri Yapısı:** Hash Table (Karma Tablosu)

---

## 1. Üstlendiğim Görevler ve İşlevler

Bu bölümde otopark sistemindeki araç ve işlem kayıtlarının hızlı sorgulanması, sıralanması ve istatistiklerinin hesaplanması amaçlanmaktadır.

- Araçların plakalarına göre hızlı şekilde aranması.
- Araçların bulunduğu park yeri numarasına göre sorgulanması.
- Otoparkta aktif olarak bulunan araçların listelenmesi.
- Belirlenen iki tarih arasındaki giriş-çıkış işlemlerinin sorgulanması.
- Aktif araç girişlerinin giriş saatine göre sıralanması.
- Tamamlanan işlemlerin toplam park ücretine göre sıralanması.
- Toplam elde edilen cironun hesaplanması.
- Otoparkın anlık doluluk oranının hesaplanması.
- Otoparktaki mevcut araç sayısının gösterilmesi.
- Araçların ortalama kalış süresinin hesaplanması.
- Sorgulama, sıralama ve istatistik sonuçlarının grafiksel kullanıcı arayüzünde gösterilmesi.

## 2. Kullanılacak Veri Yapısı ve Tercih Nedeni

**Veri Yapısı:** Hash Table (Karma Tablosu)

**Tercih Nedeni:**

- Plaka bilgisi kullanılarak araç kayıtlarına hızlı erişim sağlanması hedeflenmektedir.
- Hash Table, uygun bir hash fonksiyonu ve çakışma yönetimiyle ortalama O(1) zaman karmaşıklığında arama yapabilir.
- Araç kayıtlarının sürekli değiştiği otopark sisteminde ekleme, arama ve silme işlemlerinin verimli gerçekleştirilmesi amaçlanmaktadır.
- Çakışmaların yönetilmesi için ayrı zincirleme (Separate Chaining) yöntemi planlanmaktadır.

## 3. Temel Sınıf ve Metot Taslağı

### PlakaHashTablosu

Plaka bilgisine göre araç kayıtlarının indekslenmesini sağlayacak sınıftır.

**Planlanan metotlar:**

- `ekle()`: Araç kaydını tabloya ekleme.
- `ara()`: Plakaya göre araç arama.
- `sil()`: Plakanın indeks kaydını kaldırma.
- `hashFonksiyonu()`: Plakadan tablo indisi hesaplama.

Araç bilgilerinin, ekip tarafından geliştirilen ortak kayıt sınıflarıyla ilişkilendirilmesi planlanmaktadır.

### SorgulamaServisi

- `plakayaGoreAra()`
- `parkYerineGoreAra()`
- `aktifAraclariListele()`
- `tarihAraligindaAra()`

### SiralamaServisi

- `girisSaatineGoreSirala()`
- `ucreteGoreSirala()`

Sıralama işlemlerinde Merge Sort algoritması kullanılması planlanmaktadır.

### IstatistikServisi

- `toplamCiroHesapla()`
- `dolulukOraniHesapla()`
- `aktifAracSayisiHesapla()`
- `ortalamaKalisSuresiHesapla()`

## 4. Grafiksel Kullanıcı Arayüzü (GUI)

Java Swing veya JavaFX kullanılarak aşağıdaki ekranların geliştirilmesi planlanmaktadır:

- Plaka ve park yerine göre arama ekranı.
- Tarih aralığı filtreleme alanı.
- Araç ve işlem sıralama tablosu.
- Otopark doluluk oranı ve gelir bilgilerinin gösterildiği istatistik paneli.

## 5. Diğer Modüllerle Entegrasyon

Sorgulama modülü, ekip üyelerinin geliştirdiği araç kayıt ve park yeri yönetim modülleriyle birlikte çalışacaktır.

Veriler program açıldığında özel uzantılı metin dosyasından bellekteki veri yapılarına aktarılacaktır.

Ekleme, güncelleme ve silme işlemlerinden sonra arama indeksleri güncellenecek; kayıtların kalıcı dosyaya yazılması ortak dosya yönetim sistemi üzerinden gerçekleştirilecektir.

Veritabanı kullanılmayacaktır.

## 6. Geliştirme Planı

- [ ] Hash Table sınıfının oluşturulması.
- [ ] Hash fonksiyonunun geliştirilmesi.
- [ ] Araç ekleme ve plaka arama işlemlerinin test edilmesi.
- [ ] Park yeri ve tarih aralığı sorgularının geliştirilmesi.
- [ ] Giriş saati ve ücrete göre sıralama işlemlerinin gerçekleştirilmesi.
- [ ] İstatistik hesaplama metotlarının geliştirilmesi.
- [ ] GUI ekranlarının hazırlanması.
- [ ] Diğer modüllerle entegrasyon ve test işlemlerinin tamamlanması.

---

**Not:** Bu dosya geliştirme planını içermektedir. Tamamlanan çalışmalar ve testler ilerleyen commit'lerle güncellenecektir.
