
package com.tirtho.com.tirtho.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("total_credit_required")
    @Expose
    private Integer totalCreditRequired;
    @SerializedName("exempted_credit")
    @Expose
    private Integer exemptedCredit;
    @SerializedName("total_credit_earned")
    @Expose
    private Integer totalCreditEarned;
    @SerializedName("cgpa")
    @Expose
    private String cgpa;
    @SerializedName("grade_letter")
    @Expose
    private String gradeLetter;

    public Integer getTotalCreditRequired() {
        return totalCreditRequired;
    }

    public void setTotalCreditRequired(Integer totalCreditRequired) {
        this.totalCreditRequired = totalCreditRequired;
    }

    public Integer getExemptedCredit() {
        return exemptedCredit;
    }

    public void setExemptedCredit(Integer exemptedCredit) {
        this.exemptedCredit = exemptedCredit;
    }

    public Integer getTotalCreditEarned() {
        return totalCreditEarned;
    }

    public void setTotalCreditEarned(Integer totalCreditEarned) {
        this.totalCreditEarned = totalCreditEarned;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa.toString();
    }
    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getGradeLetter() {
        return gradeLetter;
    }

    public void setGradeLetter(String gradeLetter) {
        this.gradeLetter = gradeLetter;
    }

}
