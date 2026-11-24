package solid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Keranjang {

    private final List<Buku> daftarBuku = new ArrayList<>();
    private final List<BisaDikirim> daftarKirim = new ArrayList<>();
    private final List<BisaDiunduh> daftarUnduhan = new ArrayList<>();

    public void tambah(BukuCetak buku) {
        daftarBuku.add(buku);
        daftarKirim.add(buku);
    }

    public void tambah(BukuDigital buku) {
        daftarBuku.add(buku);
        daftarUnduhan.add(buku);
    }

    public void tambah(BukuAudio buku) {
        daftarBuku.add(buku);
        daftarUnduhan.add(buku);
    }

    public List<Buku> getDaftarBuku() {
        return Collections.unmodifiableList(daftarBuku);
    }

    public List<BisaDikirim> getDaftarKirim() {
        return Collections.unmodifiableList(daftarKirim);
    }

    public List<BisaDiunduh> getDaftarUnduhan() {
        return Collections.unmodifiableList(daftarUnduhan);
    }

    public int jumlahBuku() {
        return daftarBuku.size();
    }
}