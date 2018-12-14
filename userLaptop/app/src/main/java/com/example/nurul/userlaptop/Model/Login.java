package com.example.nurul.userlaptop.Model;

import com.google.gson.annotations.SerializedName;

public class Login {
    @SerializedName("id_user")
    private String iduser;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;


    public Login(String idPembeli, String nama, String alamat, String telp, String photoUrl) {
        this.iduser = idPembeli;
        this.username = username;
        this.password = password;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIdPembeli(String idPembeli) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
