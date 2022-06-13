package LaundryCopas;

import java.util.ArrayList;

public class Transaksi{
    private ArrayList<Integer> idClient = new ArrayList<Integer>();
    private ArrayList<Integer> idJenisLaundry = new ArrayList<Integer>();
    private ArrayList<Integer> idHarga = new ArrayList<Integer>();
    private ArrayList<Integer> idDurasi = new ArrayList<Integer>();

    public Client client = new Client();
    public JenisLaundry laundry = new JenisLaundry();

    public Transaksi(){
        for(int i=0;i<client.size();i++){
            this.idClient.add(i);
        }
        for(int i=0;i<laundry.size();i++){
            this.idJenisLaundry.add(i);
        }
    }

    public int size(){
        return this.idClient.size();
    }

    public void setIDClient(int id){
        this.idClient.add(id);
    }

    public void setIDJenisLaundry(int id){
        this.idJenisLaundry.add(id);
    }

    public void setIdHarga(int id){
        this.idHarga.add(id);
    }

    public void setIdDurasi(int id){
        this.idDurasi.add(id);
    }

    public int getIDClient(int id){
        return this.idClient.get(id);
    }

    public int getIDJenisLaundry(int id){
        return this.idJenisLaundry.get(id);
    }

}
