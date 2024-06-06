import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Paket {
    int id;
    String namaPelanggan;
    String alamatPengiriman;
    int tanggalPengiriman;
    String tipePengiriman;
    int waktuPengiriman;

    public Paket(int id, String namaPelanggan, int tanggalPengiriman, String tipePengiriman, String alamatPengiriman) {
        this.id = id;
        this.namaPelanggan = namaPelanggan;
        this.tanggalPengiriman = tanggalPengiriman;
        this.tipePengiriman = tipePengiriman;
        this.alamatPengiriman = alamatPengiriman;

        switch (tipePengiriman) {
            case "biasa":
                waktuPengiriman = 3;
                break;
            case "express":
                waktuPengiriman = 2;
                break;
            case "kilat":
                waktuPengiriman = 1;
                break;
            case "same day":
                waktuPengiriman = 0;
                break;
        }
    }
}

class DaftarPaket {
    ArrayList<Paket> paketList = new ArrayList<>();

    public void terimaKiriman(int id, String namaPelanggan, int tanggalPengiriman, String tipePengiriman, String alamatPengiriman) {
        Paket paket = new Paket(id, namaPelanggan, tanggalPengiriman, tipePengiriman, alamatPengiriman);
        paketList.add(paket);
    }

    public void cetakDataPaket() {
        Collections.sort(paketList, new Comparator<Paket>() {
            @Override
            public int compare(Paket p1, Paket p2) {
                return Integer.compare(p1.tanggalPengiriman + p1.waktuPengiriman, p2.tanggalPengiriman + p2.waktuPengiriman);
            }
        });

        for (Paket paket : paketList) {
            System.out.println("ID Paket: " + paket.id);
            System.out.println("Nama Pelanggan: " + paket.namaPelanggan);
            System.out.println("Alamat Pengiriman: " + paket.alamatPengiriman);
            System.out.println("Tanggal Pengiriman: " + paket.tanggalPengiriman);
            System.out.println("Tipe Pengiriman: " + paket.tipePengiriman);
            System.out.println("Waktu Pengiriman: " + paket.waktuPengiriman);
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DaftarPaket daftarPaket = new DaftarPaket();

        daftarPaket.terimaKiriman(1, "Yuli", 5, "express", "Jl. Ciganitri no. 15");
        daftarPaket.terimaKiriman(2, "Kiki", 6, "kilat", "Jl. Pogor no. 11");
        daftarPaket.terimaKiriman(3, "Toto", 7, "biasa", "Jl. Sukabirus no. 15");
        daftarPaket.terimaKiriman(4, "Juni", 8, "express", "Jl Telekomunikasi no. 2");
        daftarPaket.terimaKiriman(5, "Julia", 8, "same day", "Jl. Ciganitri no. 13");
        daftarPaket.terimaKiriman(6, "Agus", 9, "biasa", "Jl. Ciganitri no. 23");

        daftarPaket.cetakDataPaket();
    }
}