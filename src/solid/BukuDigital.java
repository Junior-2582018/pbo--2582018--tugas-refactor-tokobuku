package solid;

public class BukuDigital extends Buku implements BisaDiunduh {

    private final double ukuranMB;

    public BukuDigital(String judul, String penulis, int harga, double ukuranMB) {
        super(judul, penulis, harga);
        this.ukuranMB = ukuranMB;
    }

    @Override
    public int getHargaAkhir() {
        return getHarga() * 80 / 100;
    }

    @Override
    public String getKeterangan() {
        return ukuranMB + " MB, diskon 20%";
    }

    @Override
    public String linkUnduh() {
        String slug = getJudul().toLowerCase().replace(' ', '-');
        return "https://toko.buku/ebook/" + slug;
    }
}