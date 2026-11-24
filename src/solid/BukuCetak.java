package solid;

public class BukuCetak extends Buku implements BisaDikirim {

    private final int beratGram;

    public BukuCetak(String judul, String penulis, int harga, int beratGram) {
        super(judul, penulis, harga);
        this.beratGram = beratGram;
    }

    @Override
    public int getBeratGram() {
        return beratGram;
    }

    private int hitungOngkir() {
        return ((beratGram + 499) / 500) * 5000;
    }

    @Override
    public int getHargaAkhir() {
        return getHarga() + hitungOngkir();
    }

    @Override
    public String getKeterangan() {
        return beratGram + " gram, ongkir "
                + FormatRupiah.format(hitungOngkir());
    }
}