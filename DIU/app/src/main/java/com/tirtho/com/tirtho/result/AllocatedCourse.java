
package com.tirtho.com.tirtho.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllocatedCourse {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("credit")
    @Expose
    private String credit;
    @SerializedName("improvable_mark")
    @Expose
    private String improvableMark;
    @SerializedName("total_mark")
    @Expose
    private String totalMark;
    @SerializedName("course_type")
    @Expose
    private String courseType;
    @SerializedName("marks")
    @Expose
    private Marks marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getImprovableMark() {
        return improvableMark;
    }

    public void setImprovableMark(String improvableMark) {
        this.improvableMark = improvableMark;
    }

    public String getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(String totalMark) {
        this.totalMark = totalMark;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public Marks getMarks() {
        return marks;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }

}
