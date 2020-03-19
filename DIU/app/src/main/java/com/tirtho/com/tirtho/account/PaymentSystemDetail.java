
package com.tirtho.com.tirtho.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentSystemDetail {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("paymentsystem_id")
    @Expose
    private String paymentsystemId;
    @SerializedName("semestername")
    @Expose
    private String semestername;
    @SerializedName("semestertype")
    @Expose
    private String semestertype;
    @SerializedName("created_by")
    @Expose
    private Object createdBy;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentsystemId() {
        return paymentsystemId;
    }

    public void setPaymentsystemId(String paymentsystemId) {
        this.paymentsystemId = paymentsystemId;
    }

    public String getSemestername() {
        return semestername;
    }

    public void setSemestername(String semestername) {
        this.semestername = semestername;
    }

    public String getSemestertype() {
        return semestertype;
    }

    public void setSemestertype(String semestertype) {
        this.semestertype = semestertype;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

}
