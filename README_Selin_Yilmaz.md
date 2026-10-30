# Otopark Doluluk ve Araç Takip Sistemi - Bireysel Çalışma Raporu
**Öğrenci:** Selin Yılmaz  
**Görev Alanı:** Araç Çıkış & Süre/Ücret İşlemleri, Oto Yıkama Modülü  
**Sorumlu Olunan Veri Yapısı:** Kuyruk (Queue)  

---

## Üstlendiğim Görevler ve İşlevler
- Otoparktan ayrılan araçların çıkış işlemlerinin yapılması, içeride kalınan sürenin hesaplanması ve süreye göre toplam ücretin belirlenmesi.
- Oto yıkama servisine girmek isteyen araçların sıraya alınması ve sırayla yıkama işlemine gönderilmesi.
- Araç Giriş/Çıkış formu ile Oto Yıkama ekran arayüzünün (GUI) tasarlanması ve Java ses kütüphanesi kullanılarak temel ses efektlerinin (işlem onay sesi) eklenmesi.

## Kullanılan Veri Yapısı ve Tercih Nedeni
- **Veri Yapısı:** Bağlı Liste Tabanlı Kuyruk (Linked List Queue - FIFO)
- **Tercih Nedeni:** 
  * Oto yıkama sırası ve otopark çıkış gişesi gerçek hayatta ilk gelenin ilk hizmet aldığı (**FIFO - First-In, First-Out**) bir akışa sahiptir. Bu mantığı en doğrudan sağlayan yapı kuyruktur.
  * Sabit boyutlu dizi (array) yerine bağlı liste düğümleri kullanarak dinamik bir yapı kurduk. Böylece sırada bekleyen araç sayısı için baştan sabit bir sınır belirlemek zorunda kalmadık ve bellek yönetimini ihtiyaca göre dinamik tutmuş olduk.

## Temel Sınıf ve Düğüm Taslağı
- **`AracDugum` (Düğüm Sınıfı):**
  * `String plaka`: Aracın plakası
  * `long girisZamani`: Süre hesabı için sisteme giriş milisaniyesi
  * `AracDugum sonraki`: Kuyruktaki bir sonraki aracı gösteren referans
- **`OtoYikamaKuyruk` (Kuyruk Sınıfı):**
  * `AracDugum bas`: Kuyruğun en önündeki araç (front)
  * `AracDugum son`: Kuyruğun en arkasındaki araç (rear)
  * `int elemanSayisi`: Sırada bekleyen toplam araç sayısı
  * `ekle(String plaka)`: Kuyruğun sonuna yeni araç ekleme (enqueue)
  * `cikar()`: Kuyruğun başındaki aracı yıkamaya alma ve sıradan düşme (dequeue)
  * `ilkArac()`: Sıradaki ilk aracı silmeden görme (peek)
  * `bosMu()`: Kuyrukta araç olup olmadığını kontrol etme
