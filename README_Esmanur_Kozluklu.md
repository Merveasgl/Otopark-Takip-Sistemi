# Otopark Doluluk ve Araç Takip Sistemi - Bireysel Çalışma Raporu
**Öğrenci:** Esmanur Kozluklu

**Görev Alanı:** Park Süresi Dolumu & Yıkama Bitişi Mesajları/ Hatalı İşlemleri Geri Alma

**Sorumlu Olunan Veri Yapısı:** Stack(Yığın)

---

## Üstlendiğim Görevler
- Otopark sisteminde park süresi dolan araçların otomatik olarak tespit edilmesi ve Telegram botu aracılığıyla kullanıcıya bildirim gönderilmesi.
- Oto yıkama işlemi tamamlandığında Telegram üzerinden anlık bildirim gönderilmesi.
- *Bildirim Logları:* Sistem tarafından gönderilen bildirimlerin ve gerçekleşen işlemlerin kayıt altına alınması.
- *Simülasyon Aracı:* "+1 Saat İleri Sar" butonu ile sistem saatinin manuel olarak ilerletilmesi ve zaman bazlı işlemlerin test edilmesi.
- *Hatalı İşlemleri Geri Alma (Undo):* Kullanıcının gerçekleştirdiği son işlemin geri alınmasını sağlayan mekanizmanın oluşturulması.
- Geri alma işlemlerinde Stack veri yapısının LIFO (Last In First Out) mantığıyla kullanılması.
- *Simülasyon/Ayarlar Paneli:* Bildirim ve zaman kontrol işlemlerinin yönetilebileceği kullanıcı arayüzünün tasarlanması.
- ## Kullanılan Veri Yapısı ve Tercih Nedeni

- *Veri Yapısı:* Stack (Yığın - LIFO)
- *Tercih Nedeni:*
  - Kullanıcının gerçekleştirdiği son işlemin ilk olarak geri alınması gerektiği için Stack veri yapısı tercih edilmiştir.
  - LIFO mantığı sayesinde son yapılan işlem öncelikli olarak geri alınabilir.
  - İşlemlerin sıralı şekilde saklanması ve geri alma mekanizmasının kolay yönetilmesi sağlanmıştır.
  - Bildirim logları sayesinde sistemde gerçekleşen olayların geçmişe dönük takibi mümkün hale getirilmiştir.

## Temel Sınıf ve Metot Taslağı

- *UndoStack (Geri Alma Sınıfı):*
  - Stack<Islem>: Geri alınabilir işlemleri tutan yığın veri yapısı.
  - push(Islem islem): Gerçekleştirilen işlemi yığına ekleme.
  - pop(): Son işlemi yığından çıkararak geri alma.
  - peek(): Geri alınabilecek son işlemi görüntüleme.
  - isEmpty(): Yığının boş olup olmadığını kontrol etme.

- *BildirimLog (Bildirim Kayıt Sınıfı):*
  - Bildirim mesajlarını, türlerini ve gönderim zamanlarını saklama.
  - Gönderilen bildirimleri kayıt altına alma.
  - Bildirim geçmişini görüntüleme.

- *SimulasyonPaneli (Simülasyon Sınıfı):*
  - saatiIlerlet(): Sistem saatini bir saat ileri alma.
  - sureKontrol(): Park süresi dolan araçları kontrol etme.
  - bildirimTesti(): Bildirim mekanizmasını test etme.

- *TelegramBildirim (Bildirim Sınıfı):*
  - Park süresi dolan araçlar için Telegram bildirimi gönderme.
  - Oto yıkama işlemi tamamlandığında bildirim gönderme.
  - Bildirim mesajlarını oluşturma ve gönderim işlemlerini yönetme.
