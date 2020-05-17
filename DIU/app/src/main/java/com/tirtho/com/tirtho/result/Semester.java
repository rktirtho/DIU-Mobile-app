
package com.tirtho.com.tirtho.result;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Semester {

    @SerializedName("semester")
    @Expose
    private String semester;
    @SerializedName("exempted")
    @Expose
    private String exempted;
    @SerializedName("total_subject")
    @Expose
    private String totalSubject;
    @SerializedName("total_credit")
    @Expose
    private String totalCredit;
    @SerializedName("total_semester_gpa")
    @Expose
    private String totalSemesterGpa;
    @SerializedName("average_grade")
    @Expose
    private String averageGrade;
    @SerializedName("semester_result")
    @Expose
    private String semesterResult;

    @SerializedName("allocated_courses")
    @Expose
    private List<AllocatedCourse> allocatedCourses = null;

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getExempted() {
        return exempted;
    }

    public void setExempted(String exempted) {
        this.exempted = exempted;
    }

    public String getTotalSubject() {
        return totalSubject;
    }

    public void setTotalSubject(String totalSubject) {
        this.totalSubject = totalSubject;
    }

    public String getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(String totalCredit) {
        this.totalCredit = totalCredit;
    }

    public String getTotalSemesterGpa() {
        return totalSemesterGpa;
    }

    public void setTotalSemesterGpa(String totalSemesterGpa) {
        this.totalSemesterGpa = totalSemesterGpa;
    }

    public void setTotalSemesterGpa(Double totalSemesterGpa) {
        this.totalSemesterGpa = totalSemesterGpa.toString();
    }

    public String getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(String averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String getSemesterResult() {
        return semesterResult;
    }

    public void setSemesterResult(String semesterResult) {
        this.semesterResult = semesterResult;
    }

    public List<AllocatedCourse> getAllocatedCourses() {
        return allocatedCourses;
    }

    public void setAllocatedCourses(List<AllocatedCourse> allocatedCourses) {
        this.allocatedCourses = allocatedCourses;
    }

    public void setAllocatedCourses(String allocatedCourses) {

    }


}
