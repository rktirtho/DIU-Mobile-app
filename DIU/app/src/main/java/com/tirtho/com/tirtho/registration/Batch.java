package com.tirtho.com.tirtho.registration;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Batch {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("batch_name")
    @Expose
    private String batchName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

}
