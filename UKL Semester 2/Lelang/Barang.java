package Lelang;

import java.util.ArrayList;

public class Barang extends Lelang {

    private ArrayList<Integer> idMasyarakat = new ArrayList<Integer>();
    private ArrayList<String> namaBarang = new ArrayList<String>();
    private ArrayList<String> gantiHarga = new ArrayList<String>();
    private ArrayList<Integer> hargaAwal = new ArrayList<Integer>();
    private ArrayList<Integer> hargaTertinggi = new ArrayList<Integer>();
    private ArrayList<Boolean> status = new ArrayList<Boolean>();
    public int jumlahBarang = namaBarang.size();

    public Barang() {
        this.namaBarang.add("Sepeda");
        this.hargaAwal.add(700_000);
        this.status.add(true);

        this.namaBarang.add("Mobil");
        this.hargaAwal.add(700_000);
        this.status.add(true);

        // mengganti harga ke lebih tinggi
        for(int i = 0;i<jumlahBarang;i++){
            hargaTertinggi.add(hargaAwal.get(i));
        }
    }

    public void removeBarang(int id) {
        this.namaBarang.remove(id);
        this.hargaAwal.remove(id);
        this.status.remove(id);
    }

    public void setIdMasyarakat(int id) {
        this.idMasyarakat.add(id);
    }

    public void setNamaBarang(String barang) {
        this.namaBarang.add(barang);
    }

    public void setHargaAwal(int hargaAwal) {
        this.hargaAwal.add(hargaAwal);
    }

    public void gantiHarga(int id, int harga) {
        this.hargaAwal.set(id, harga);
    }

    public void setStatus(boolean status) {
        this.status.add(status);
    }

    public int getIdMasyarakat(int id) {
        return this.idMasyarakat.get(id);
    }

    public String getNamaBarang(int id) {
        return this.namaBarang.get(id);
    }

    public int getHargaAwal(int id) {
        return this.hargaAwal.get(id);
    }

    public boolean getStatus(int id) {
        return this.status.get(id);
    }

    public void showBarang() {
        int n = namaBarang.size();
        for (int i = 0; i < n; i++) {
            System.out.println("==========================");
            System.out.println("Nama Barang\t : " + getNamaBarang(i));
            System.out.println("Harga Awal\t : " + getHargaAwal(i));
            System.out.println("Status\t\t : " + getStatus(i));
            System.out.println("ID Barang\t : " + i);
        }
    }

}
