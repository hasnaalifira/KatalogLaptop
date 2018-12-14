package com.example.nurul.userlaptop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetLaptop {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private List<Laptop> result = null;

    public GetLaptop(String status, List<Laptop> result) {
        super();
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GetLaptop withStatus(String status) {
        this.status = status;
        return this;
    }

    public List<Laptop> getResult() {
        return result;
    }

    public void setResult(List<Laptop> result) {
        this.result = result;
    }

    public GetLaptop withResult(List<Laptop> result) {
        this.result = result;
        return this;
    }

}
