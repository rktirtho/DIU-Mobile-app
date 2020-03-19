
package com.tirtho.com.tirtho.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TuitionFee {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("purpose_pay_id")
    @Expose
    private String purposePayId;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("student_id")
    @Expose
    private String studentId;
    @SerializedName("receipt_no")
    @Expose
    private String receiptNo;
    @SerializedName("cashorbank")
    @Expose
    private String cashorbank;
    @SerializedName("receive_by")
    @Expose
    private String receiveBy;
    @SerializedName("bank_id")
    @Expose
    private String bankId;
    @SerializedName("varified_by")
    @Expose
    private String varifiedBy;
    @SerializedName("is_varified")
    @Expose
    private String isVarified;
    @SerializedName("date_bank")
    @Expose
    private String dateBank;
    @SerializedName("pay_date")
    @Expose
    private String payDate;
    @SerializedName("purpose_pay")
    @Expose
    private PurposePay purposePay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurposePayId() {
        return purposePayId;
    }

    public void setPurposePayId(String purposePayId) {
        this.purposePayId = purposePayId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getCashorbank() {
        return cashorbank;
    }

    public void setCashorbank(String cashorbank) {
        this.cashorbank = cashorbank;
    }

    public String getReceiveBy() {
        return receiveBy;
    }

    public void setReceiveBy(String receiveBy) {
        this.receiveBy = receiveBy;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getVarifiedBy() {
        return varifiedBy;
    }

    public void setVarifiedBy(String varifiedBy) {
        this.varifiedBy = varifiedBy;
    }

    public String getIsVarified() {
        return isVarified;
    }

    public void setIsVarified(String isVarified) {
        this.isVarified = isVarified;
    }

    public String getDateBank() {
        return dateBank;
    }

    public void setDateBank(String dateBank) {
        this.dateBank = dateBank;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public PurposePay getPurposePay() {
        return purposePay;
    }

    public void setPurposePay(PurposePay purposePay) {
        this.purposePay = purposePay;
    }

}
