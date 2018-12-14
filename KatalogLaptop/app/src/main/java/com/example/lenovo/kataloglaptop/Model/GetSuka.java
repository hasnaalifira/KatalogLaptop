package com.example.lenovo.kataloglaptop.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetSuka {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Suka> listDataSuka;
    @SerializedName("message")
    String message;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Suka> getListDataSuka() {
        return listDataSuka;
    }

    public void setListDataSuka(List<Suka> listDataSuka) {
        this.listDataSuka = listDataSuka;
    }
}
