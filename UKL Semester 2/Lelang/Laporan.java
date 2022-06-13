package Lelang;

import java.util.Scanner;

public class Laporan {
    static Masyarakat masyarakat = new Masyarakat();
    static Petugas petugas = new Petugas();
    static Barang barang = new Barang();
    static Scanner input = new Scanner(System.in);

    public static void showApp() {
        boolean program = true;
        System.out.println("========SELAMAT DATANG========");
        System.out.print("Apakah Anda Punya Akun? (y/n) ");
        String akun = input.next();
        if (akun.equalsIgnoreCase("y")) {
            login();
        } else {
            signUp();
        }

        while (program) {
            System.out.println("========== MENU ==========");
            System.out.println("1. Tampilkan Petugas");
            System.out.println("2. Tampilkan User");
            System.out.println("3. Tampilkan Barang Lelang");
            System.out.println("4. Jual Barang");
            System.out.println("5. Ikut Lelang");
            System.out.println("6. Exit");
            System.out.print("Pilih Menu: ");
            int menu = input.nextInt();

            if (menu == 1) {
                petugas.showPetugas();
            } else if (menu == 2) {
                masyarakat.showMasyarakat();
            } else if (menu == 3) {
                barang.showBarang();
            } else if (menu == 4) {
                sell();
            } else if (menu == 5) {
                lelang();
            } else if (menu == 6) {
                program = false;
            }
        }
    }

    public static void lelang() {
        barang.showBarang();
        System.out.print("Masukan ID Barang Yang Ingin Anda Lelang: ");
        int idBarang = input.nextInt();

        if (barang.getStatus(idBarang)) {
            System.out.print("Masukan Harga Tawar: ");
            int tawar = input.nextInt();
            if (tawar > barang.getHargaAwal(idBarang)) {
                barang.gantiHarga(idBarang, tawar);
                System.out.println("Harga " + barang.getNamaBarang(idBarang) + ": " + barang.getHargaAwal(idBarang));
                // Menang Lelang
                System.out.println("Selamat, Anda Telah Memenangkan Lelang");
                System.out.print("Tekan 'y' untuk melakukan pembelian ");
                String confirm = input.next();
                if (confirm.equalsIgnoreCase("y")) {
                    barang.removeBarang(idBarang);
                    System.out.println("Terima Kasih Telah Berpartisipasi");
                } else {
                    System.out.println("Barang Dikembalikan Ke Harga Semula");
                }

            } else {
                System.out.println("Harga Yang Anda Masukan Kurang Dari Harga Yang Tertera");
            }
        } else {
            System.out.println("Maaf Barang Ini Sudah Terjual");
        }
    }

    public static void sell() {
        boolean status = true;
        System.out.print("Masukan Nama Barang: ");
        String nama = input.next();
        barang.setNamaBarang(nama);
        System.out.print("Masukan Harga Barang: ");
        int harga = input.nextInt();
        barang.setHargaAwal(harga);
        barang.setStatus(status);
        System.out.println("Selamat Barang Anda Sudah Diupload");
    }

    public static void login() {
        System.out.print("Masukan ID: ");
        int id = input.nextInt();
        System.out.println("Hallo " + masyarakat.getNama(id));
    }

    public static void signUp() {
        System.out.println("Buat Akun");
        System.out.println("1. Petugas");
        System.out.println("2. User");
        System.out.print("Masukan Jawaban: ");
        int jawaban = input.nextInt();

        if (jawaban == 1) {
            System.out.print("Masukan Nama: ");
            String nama = input.next();
            petugas.setNama(nama);
            System.out.print("Masukan Alamat: ");
            String alamat = input.next();
            petugas.setAlamat(alamat);
            System.out.print("Masukan Telepon: ");
            String telepon = input.next();
            petugas.setTelepon(telepon);
            System.out.println("Selamat Akun Anda Sudah Terdaftar");
        } else if (jawaban == 2) {
            System.out.print("Masukan Nama: ");
            String nama = input.next();
            masyarakat.setNama(nama);
            System.out.print("Masukan Alamat: ");
            String alamat = input.next();
            masyarakat.setAlamat(alamat);
            System.out.print("Masukan Telepon: ");
            String telepon = input.next();
            masyarakat.setTelepon(telepon);
            System.out.println("Selamat Akun Anda Sudah Terdaftar");
        }

    }

}
