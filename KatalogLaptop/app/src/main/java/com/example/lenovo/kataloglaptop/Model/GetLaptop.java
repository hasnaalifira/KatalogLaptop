package com.example.lenovo.kataloglaptop.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetLaptop {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private List<Laptop> result = new ArrayList<Laptop>();
    @SerializedName("message")
    private String message;
    public GetLaptop() {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Laptop> getResult() {
        return result;
    }

    public void setResult(List<Laptop> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
