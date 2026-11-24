package solid;

public class StrukPrinter {

    public int cetak(String pelanggan, Keranjang keranjang,
                     MetodeBayar metodeBayar) {

        System.out.println("================ STRUK =================");
        System.out.println("Pelanggan : " + pelanggan);

        int total = 0;

        for (Buku buku : keranjang.getDaftarBuku()) {
            System.out.println(buku.getJudul() + " (" + buku.getPenulis() + ")");
            System.out.println("  Harga       : "
                    + FormatRupiah.format(buku.getHarga()));
            System.out.println("  Keterangan  : " + buku.getKeterangan());
            System.out.println("  Harga akhir : "
                    + FormatRupiah.format(buku.getHargaAkhir()));

            total += buku.getHargaAkhir();
        }

        int bayar = metodeBayar.hitungTotalBayar(total);

        System.out.println("-----------------------------------------");
        System.out.println("Total belanja : " + FormatRupiah.format(total));
        System.out.println("Metode bayar  : " + metodeBayar.getNamaMetode());
        System.out.println("Total bayar   : " + FormatRupiah.format(bayar));

        int totalBerat = 0;

        for (BisaDikirim buku : keranjang.getDaftarKirim()) {
            totalBerat += buku.getBeratGram();
        }

        System.out.println("Berat kiriman : " + totalBerat + " gram");

        System.out.println("-------------- LINK UNDUH ---------------");

        for (BisaDiunduh buku : keranjang.getDaftarUnduhan()) {
            System.out.println(buku.linkUnduh());
        }

        System.out.println("-----------------------------------------");

        return bayar;
    }
}