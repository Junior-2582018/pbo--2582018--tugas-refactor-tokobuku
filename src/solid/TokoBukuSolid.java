package solid;

public class TokoBukuSolid {

    public static void main(String[] args) {

        // Membuat keranjang belanja
        Keranjang keranjang = new Keranjang();

        // Menambahkan buku cetak
        keranjang.tambah(new BukuCetak(
                "Pemrograman Java",
                "John Doe",
                120000,
                750
        ));

        keranjang.tambah(new BukuCetak(
                "Algoritma Dasar",
                "Jane Smith",
                95000,
                400
        ));

        // Menambahkan buku digital
        keranjang.tambah(new BukuDigital(
                "Belajar OOP",
                "Ani Wijaya",
                80000,
                12.5
        ));

        // Menambahkan buku audio
        keranjang.tambah(new BukuAudio(
                "Kisah Programmer",
                "Budi Santoso",
                60000,
                240
        ));

        // Membuat dependensi checkout
        StrukPrinter printer = new StrukPrinter();
        PenyimpanRiwayat riwayat = new FileRiwayat();
        PengirimNotifikasi notifikasi = new EmailSender();

        // Membuat layanan checkout
        CheckoutService checkout = new CheckoutService(
                printer,
                riwayat,
                notifikasi
        );

        // Memproses pembayaran
        MetodeBayar metodeBayar = new EWallet();

        checkout.checkout(
                "Sari",
                "sari@mail.com",
                keranjang,
                metodeBayar
        );
    }
}