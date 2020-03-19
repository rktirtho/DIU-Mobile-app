
package com.tirtho.com.tirtho.account;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymemtSystem {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("created_by")
    @Expose
    private Object createdBy;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("nos")
    @Expose
    private String nos;
    @SerializedName("payment_system_detail")
    @Expose
    private List<PaymentSystemDetail> paymentSystemDetail = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNos() {
        return nos;
    }

    public void setNos(String nos) {
        this.nos = nos;
    }

    public List<PaymentSystemDetail> getPaymentSystemDetail() {
        return paymentSystemDetail;
    }

    public void setPaymentSystemDetail(List<PaymentSystemDetail> paymentSystemDetail) {
        this.paymentSystemDetail = paymentSystemDetail;
    }

}
