package LaundryCopas;

import java.util.Scanner;

public class Main {
    static Client client = new Client();
    static Petugas petugas = new Petugas();
    static Transaksi transaksi = new Transaksi();
    static JenisLaundry jenislaundry = new JenisLaundry();
    static Scanner input = new Scanner(System.in);
    static boolean tetap = true;

    public static void main(String[] args){

        System.out.println("Apakah anda petugas? (y/n)");
        String jawaban = input.next();
        if (jawaban.equalsIgnoreCase("y")) {
            System.out.print("Masukkan ID Anda ");
            int id = input.nextInt();
            System.out.println("Selamat Datang "+petugas.getNama(id));
            System.out.println("Apakah Anda Ingin Menambahkan Paket Laundry? (y/n) ");
            String jawab = input.next();
            if (jawab.equalsIgnoreCase("y")) {
                System.out.println("Masukan Nama Paket");
                input.skip("\\R?");
                String paket = input.nextLine();
                jenislaundry.setLaundry(paket);
                transaksi.setIDJenisLaundry(transaksi.size() + 2);
                System.out.println("Masukan Harga Paket");
                int harga = input.nextInt();
                jenislaundry.addHarga(harga);
                System.out.print("Masukan Durasi Paket");
                int durasi = input.nextInt();
                jenislaundry.setDurasi(durasi);
                showApp();
            }
        } else {
            showApp();
        }
    }

        public static void showApp() {
            System.out.print("Apakah anda sudah memiliki akun?(y/n) ");
            String jawab = input.next();
            if(jawab.equalsIgnoreCase("y")){
                System.out.print("Masukkan ID Anda ");
                int id = input.nextInt();
                System.out.println("Selamat Datang "+client.getNama(id));
                System.out.println("ID anda "+transaksi.getIDClient(id));
                menu(id);
            }
            else{
                System.out.print("Masukkan Nama ");
                String nama = input.next();
                client.setNama(nama);
                transaksi.setIDClient(transaksi.size());
                System.out.print("Masukkan Alamat");
                String alamat = input.next();
                client.setAlamat(alamat);
                System.out.print("Masukkan Nomor Telepon");
                String telepon = input.next();
                client.setTelepon(telepon);
                System.out.print("Masukkan saldo yang ingin anda tambahkan");
                int saldo = input.nextInt();
                client.addSaldo(saldo);
                System.out.println("Terimakasih telah mendaftar "+nama);
                int i = client.getId(nama);
                System.out.println("ID Anda "+transaksi.getIDClient(i));
                menu(i);
            }
        }

    public static void tampilLaundry(){
        int n = jenislaundry.size();
        for(int i=0;i<n;i++){
            System.out.println("--------" + jenislaundry.getLaundry(transaksi.getIDJenisLaundry(i)) + "--------");
            System.out.println("Harga  = "+jenislaundry.getHarga(transaksi.getIDJenisLaundry(i)));
            System.out.println("Durasi = "+jenislaundry.getDurasi(transaksi.getIDJenisLaundry(i)));
            System.out.println("ID     = "+transaksi.getIDJenisLaundry(transaksi.getIDJenisLaundry(i)));
        }
    }

    public static void menu(int id){
        while(tetap){
            System.out.println("-- Laundry --");
            System.out.println("1. List Laundry");
            System.out.println("2. List Petugas");
            System.out.println("3. List Client");
            System.out.println("4. Laundry");
            System.out.println("5. Exit");
            System.out.print("Pilih menu: ");
            int menu = input.nextInt();
            if(menu==1){
                tampilLaundry();
            }
            else if(menu==2){
                petugas.tampilPetugas();
            }
            else if(menu==3){
                client.tampilClient();
            }
            else if(menu==4){
                tampilLaundry();
                System.out.print("Masukkan Id laundry yang diinginkan");
                int laundry = input.nextInt();
                System.out.print("Masukkan berapa banyak laundry anda");
                int banyak = input.nextInt();
                int harga = jenislaundry.getHarga(laundry)*banyak;
                if(client.getSaldo(id)>=harga){
                    System.out.println("----------Total----------");
                    System.out.println("Jenis Laundry = "+jenislaundry.getLaundry(laundry));
                    System.out.println("Total Harga   = "+harga);
                    System.out.println("Durasi        = "+jenislaundry.getDurasi(laundry)+" menit");
                    client.setSaldo(id, client.getSaldo(id)-harga);
                    System.out.println("Terimakasih telah menggunkaan jasa kami");
                }
                else{
                    System.out.println("Saldo anda tidak cukup");
                }
            }
            else if(menu==5){
                System.out.println("Sampai Jumpa Lagi");
                tetap = false;
            }
            else{
                System.out.println("Input yang anda masukkan tidak sesuai");
            }
        }
    }
}
