package com.example.lenovo.kataloglaptop.Model;

import com.google.gson.annotations.SerializedName;

public class Suka {
    @SerializedName("id_suka")
    private String idSuka;
    @SerializedName("id_laptop")
    private String idLaptop;
    @SerializedName("id_user")
    private String idUser;

    public Suka(String id_suka, String id_laptop, String id_user) {
        this.idSuka = id_suka;
        this.idLaptop = id_laptop;
        this.idUser = id_user;
    }

    public String getIdSuka() {
        return idSuka;
    }

    public void setIdSuka(String idSuka) {
        this.idSuka = idSuka;
    }

    public String getIdLaptop() {
        return idLaptop;
    }

    public void setIdLaptop(String idLaptop) {
        this.idLaptop = idLaptop;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
