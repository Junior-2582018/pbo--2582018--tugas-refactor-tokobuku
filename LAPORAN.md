# LAPORAN REFACTORING TOKO BUKU – SOLID

## 1. Single Responsibility Principle (SRP)

**Kode awal yang bermasalah:**

```java
class Toko {
    ArrayList<Buku> keranjang = new ArrayList<>();
    EmailSender email = new EmailSender();
    FileRiwayat riwayat = new FileRiwayat();

    void checkout(String pelanggan, String alamatEmail, String metode) {
        // proses checkout
    }
}
```

**Penjelasan:**

Pada kode awal, class `Toko` memiliki terlalu banyak tanggung jawab. Class ini mengelola keranjang, menghitung harga, mencetak struk, memproses pembayaran, menyimpan riwayat, dan mengirim email. Hal ini membuat kode sulit dirawat.

**Hasil refactoring:**

Tanggung jawab dipisahkan ke dalam class `Keranjang`, `StrukPrinter`, `CheckoutService`, `FileRiwayat`, dan `EmailSender`.

## 2. Open/Closed Principle (OCP)

**Kode awal yang bermasalah:**

```java
switch (b.jenis) {
    case "CETAK":
        return b.getHarga() + hitungOngkir(b);
    case "DIGITAL":
        return b.getHarga() * 80 / 100;
    case "AUDIO":
        return b.getHarga() * 90 / 100;
}
```

Kode metode pembayaran juga menggunakan pemeriksaan `if` berdasarkan nama metode.

**Penjelasan:**

Kode awal harus diubah setiap kali ada jenis buku atau metode pembayaran baru. Hal ini membuat program sulit dikembangkan.

**Hasil refactoring:**

Menggunakan class `BukuCetak`, `BukuDigital`, `BukuAudio`, interface `MetodeBayar`, serta implementasi `Tunai`, `Transfer`, dan `EWallet`.

## 3. Liskov Substitution Principle (LSP)

**Kode awal yang bermasalah:**

```java
public int getBeratGram() {
    if (!jenis.equals("CETAK")) {
        throw new UnsupportedOperationException(
            judul + " tidak punya berat"
        );
    }
    return beratGram;
}
```

**Penjelasan:**

Semua jenis buku dipaksa memiliki perilaku yang sama, padahal buku digital dan audio tidak memiliki berat untuk pengiriman. Pemanggilan metode tersebut bahkan dapat menghasilkan error.

**Hasil refactoring:**

Menggunakan class turunan `BukuCetak`, `BukuDigital`, dan `BukuAudio`. Setiap class memiliki perilaku sesuai jenis bukunya tanpa memaksakan operasi yang tidak didukung.

## 4. Interface Segregation Principle (ISP)

**Kode awal yang bermasalah:**

```java
interface Produk {
    String getJudul();
    String getPenulis();
    int getHarga();
    int getBeratGram();
    String linkUnduh();
    int getDurasiMenit();
}
```

**Penjelasan:**

Interface `Produk` terlalu besar karena menggabungkan fungsi yang tidak dibutuhkan semua jenis buku. Buku cetak tidak membutuhkan link unduhan, sedangkan buku digital tidak membutuhkan berat pengiriman.

**Hasil refactoring:**

Memisahkan kemampuan menjadi interface `BisaDikirim` dan `BisaDiunduh`. Dengan demikian, setiap buku hanya menerapkan kemampuan yang sesuai.

## 5. Dependency Inversion Principle (DIP)

**Kode awal yang bermasalah:**

```java
class Toko {
    EmailSender email = new EmailSender();
    FileRiwayat riwayat = new FileRiwayat();
}
```

**Penjelasan:**

Class `Toko` bergantung langsung pada implementasi konkret untuk mengirim email dan menyimpan riwayat. Hal ini membuat implementasi sulit diganti.

**Hasil refactoring:**

Membuat interface `PenyimpanRiwayat` dan `PengirimNotifikasi`. Class `CheckoutService` menerima `StrukPrinter`, `PenyimpanRiwayat`, dan `PengirimNotifikasi` melalui constructor.

## YAGNI dan KISS

Menurut saya, tidak semua bagian program perlu dibuat menjadi interface atau class tambahan. Abstraksi sebaiknya hanya digunakan ketika memang dibutuhkan, seperti pada metode pembayaran, penyimpanan riwayat, dan pengiriman notifikasi. Untuk fungsi sederhana seperti format rupiah, cukup menggunakan class `FormatRupiah` tanpa membuat abstraksi yang berlebihan. Dengan menerapkan YAGNI dan KISS, program menjadi lebih sederhana, mudah dipahami, dan mudah dikembangkan.