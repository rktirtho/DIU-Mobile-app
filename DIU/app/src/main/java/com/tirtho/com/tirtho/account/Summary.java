
package com.tirtho.com.tirtho.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Summary {

    @SerializedName("batch")
    @Expose
    private Batch batch;
    @SerializedName("said_fee")
    @Expose
    private Integer saidFee;
    @SerializedName("nos")
    @Expose
    private Integer nos;
    @SerializedName("currentPayable")
    @Expose
    private Double currentPayable;
    @SerializedName("eximp-sem")
    @Expose
    private Integer eximpSem;
    @SerializedName("sum_of_tution_fee")
    @Expose
    private Integer sumOfTutionFee;
    @SerializedName("common_scholarship")
    @Expose
    private Integer commonScholarship;
    @SerializedName("actual_total_fee")
    @Expose
    private Integer actualTotalFee;
    @SerializedName("special_scholarship")
    @Expose
    private Integer specialScholarship;
    @SerializedName("per_semester_fee")
    @Expose
    private Integer perSemesterFee;
    @SerializedName("per_semester_fee_without_scholarship")
    @Expose
    private Integer perSemesterFeeWithoutScholarship;
    @SerializedName("total_paid")
    @Expose
    private Integer totalPaid;
    @SerializedName("total_current_due")
    @Expose
    private Double totalCurrentDue;
    @SerializedName("total_due")
    @Expose
    private Integer totalDue;

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Integer getSaidFee() {
        return saidFee;
    }

    public void setSaidFee(Integer saidFee) {
        this.saidFee = saidFee;
    }

    public Integer getNos() {
        return nos;
    }

    public void setNos(Integer nos) {
        this.nos = nos;
    }

    public Double getCurrentPayable() {
        return currentPayable;
    }

    public void setCurrentPayable(Double currentPayable) {
        this.currentPayable = currentPayable;
    }

    public Integer getEximpSem() {
        return eximpSem;
    }

    public void setEximpSem(Integer eximpSem) {
        this.eximpSem = eximpSem;
    }

    public Integer getSumOfTutionFee() {
        return sumOfTutionFee;
    }

    public void setSumOfTutionFee(Integer sumOfTutionFee) {
        this.sumOfTutionFee = sumOfTutionFee;
    }

    public Integer getCommonScholarship() {
        return commonScholarship;
    }

    public void setCommonScholarship(Integer commonScholarship) {
        this.commonScholarship = commonScholarship;
    }

    public Integer getActualTotalFee() {
        return actualTotalFee;
    }

    public void setActualTotalFee(Integer actualTotalFee) {
        this.actualTotalFee = actualTotalFee;
    }

    public Integer getSpecialScholarship() {
        return specialScholarship;
    }

    public void setSpecialScholarship(Integer specialScholarship) {
        this.specialScholarship = specialScholarship;
    }

    public Integer getPerSemesterFee() {
        return perSemesterFee;
    }

    public void setPerSemesterFee(Integer perSemesterFee) {
        this.perSemesterFee = perSemesterFee;
    }

    public Integer getPerSemesterFeeWithoutScholarship() {
        return perSemesterFeeWithoutScholarship;
    }

    public void setPerSemesterFeeWithoutScholarship(Integer perSemesterFeeWithoutScholarship) {
        this.perSemesterFeeWithoutScholarship = perSemesterFeeWithoutScholarship;
    }

    public Integer getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(Integer totalPaid) {
        this.totalPaid = totalPaid;
    }

    public Double getTotalCurrentDue() {
        return totalCurrentDue;
    }

    public void setTotalCurrentDue(Double totalCurrentDue) {
        this.totalCurrentDue = totalCurrentDue;
    }

    public Integer getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(Integer totalDue) {
        this.totalDue = totalDue;
    }

}
