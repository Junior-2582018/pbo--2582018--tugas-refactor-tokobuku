package solid;

public class BukuAudio extends Buku implements BisaDiunduh {

    private final int durasiMenit;

    public BukuAudio(String judul, String penulis, int harga, int durasiMenit) {
        super(judul, penulis, harga);
        this.durasiMenit = durasiMenit;
    }

    @Override
    public int getHargaAkhir() {
        return getHarga() * 90 / 100;
    }

    @Override
    public String getKeterangan() {
        return durasiMenit + " menit, diskon 10%";
    }

    @Override
    public String linkUnduh() {
        String slug = getJudul().toLowerCase().replace(' ', '-');
        return "https://toko.buku/audio/" + slug;
    }
}