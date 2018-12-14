package com.example.lenovo.kataloglaptop.Model;

import com.google.gson.annotations.SerializedName;

public class  Laptop {
    @SerializedName("id_laptop")
    private String idLaptop;
    @SerializedName("merk")
    private String merk;
    @SerializedName("tipe")
    private String tipe;
    @SerializedName("ram")
    private int ram;
    @SerializedName("processor")
    private String processor;
    @SerializedName("warna")
    private String warna;
    @SerializedName("harga")
    private int harga;
    @SerializedName("photo_url")
    private String photoUrl;
    private String action;

    public Laptop(String idLaptop, String merk, String tipe, int ram, String processor, String warna, int harga, String photoUrl, String
            action) {
        this.idLaptop = idLaptop;
        this.merk = merk;
        this.tipe = tipe;
        this.ram = ram;
        this.processor = processor;
        this.warna = warna;
        this.harga = harga;
        this.photoUrl = photoUrl;
        this.action = action;
    }

    public String getIdLaptop() {
        return idLaptop;
    }

    public void setIdLaptop(String idLaptop) {
        this.idLaptop = idLaptop;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getAction() { return action; }

    public void setAction(String action) {
        this.action = action;
    }

}
