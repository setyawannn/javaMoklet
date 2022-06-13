package Lelang;

import java.util.ArrayList;

public class Lelang {

    private ArrayList<Integer> idPenawar = new ArrayList<Integer>();
    private ArrayList<Integer> idBarang = new ArrayList<Integer>();
    private ArrayList<Integer> hargaTawar = new ArrayList<Integer>();

    public void setIdPenawar(int id) {
        this.idPenawar.add(id);
    }

    public void setIdBarang(int id) {
        this.idBarang.add(id);
    }

    public void setHargaTawar(int harga) {
        this.hargaTawar.add(harga);
    }
}
