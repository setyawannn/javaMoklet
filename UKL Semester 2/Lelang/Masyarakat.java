package Lelang;

import java.util.ArrayList;

public class Masyarakat implements User {

    private ArrayList<String> namaMasyarakat = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();

    public Masyarakat() {
        this.namaMasyarakat.add("Celline");
        this.alamat.add("Sawojajar");
        this.telepon.add("081333717212");

        this.namaMasyarakat.add("Piggy");
        this.alamat.add("Sawojajar");
        this.telepon.add("081333717212");
    }

    @Override
    public void setNama(String namaMasyarakat) {
        this.namaMasyarakat.add(namaMasyarakat);
    }

    @Override
    public void setAlamat(String alamat) {
        this.alamat.add(alamat);
    }

    @Override
    public void setTelepon(String telepon) {
        this.telepon.add(telepon);
    }

    @Override
    public String getNama(int id) {
        return this.namaMasyarakat.get(id);
    }

    @Override
    public String getAlamat(int id) {
        return this.alamat.get(id);
    }

    @Override
    public String getTelepon(int id) {
        return this.telepon.get(id);
    }

    public void showMasyarakat() {
        int n = namaMasyarakat.size();
        for (int i = 0; i < n; i++) {
            System.out.println("==========================");
            System.out.println("Nama\t : " + getNama(i));
            System.out.println("Alamat\t : " + getAlamat(i));
            System.out.println("Telepon\t : " + getTelepon(i));
        }
    }

}
