package solid;

public class CheckoutService {

    private final StrukPrinter printer;
    private final PenyimpanRiwayat riwayat;
    private final PengirimNotifikasi notifikasi;

    public CheckoutService(StrukPrinter printer,
                           PenyimpanRiwayat riwayat,
                           PengirimNotifikasi notifikasi) {
        this.printer = printer;
        this.riwayat = riwayat;
        this.notifikasi = notifikasi;
    }

    public void checkout(String pelanggan, String alamatEmail,
                         Keranjang keranjang, MetodeBayar metodeBayar) {

        int bayar = printer.cetak(pelanggan, keranjang, metodeBayar);

        riwayat.simpan(
                pelanggan + ";" + keranjang.jumlahBuku()
                        + " buku;" + FormatRupiah.format(bayar)
        );

        notifikasi.kirim(
                alamatEmail,
                "Terima kasih " + pelanggan
                        + ", total bayar " + FormatRupiah.format(bayar)
        );
    }
}