
package com.tirtho.com.tirtho.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Marks{

    @SerializedName("conti_total")
    @Expose
    private String contiTotal;
    @SerializedName("final_total")
    @Expose
    private String finalTotal;
    @SerializedName("course_total")
    @Expose
    private String courseTotal;
    @SerializedName("letter_grade")
    @Expose
    private String letterGrade;
    @SerializedName("grade_point")
    @Expose
    private String gradePoint;
    @SerializedName("status_mid")
    @Expose
    private String statusMid;
    @SerializedName("status_final")
    @Expose
    private String statusFinal;

    public String getContiTotal() {
        return contiTotal;
    }

    public void setContiTotal(String contiTotal) {
        this.contiTotal = contiTotal;
    }

    public String getFinalTotal() {
        return finalTotal;
    }

    public void setFinalTotal(String finalTotal) {
        this.finalTotal = finalTotal;
    }

    public String getCourseTotal() {
        return courseTotal;
    }

    public void setCourseTotal(String courseTotal) {
        this.courseTotal = courseTotal;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public String getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(String gradePoint) {
        this.gradePoint = gradePoint;
    }

    public String getStatusMid() {
        return statusMid;
    }

    public void setStatusMid(String statusMid) {
        this.statusMid = statusMid;
    }

    public String getStatusFinal() {
        return statusFinal;
    }

    public void setStatusFinal(String statusFinal) {
        this.statusFinal = statusFinal;
    }

}
