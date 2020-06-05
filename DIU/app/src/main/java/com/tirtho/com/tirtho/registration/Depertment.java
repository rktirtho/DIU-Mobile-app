
package com.tirtho.com.tirtho.registration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Depertment {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("short_code")
    @Expose
    private String shortCode;
    @SerializedName("faculty")
    @Expose
    private String faculty;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("program_type")
    @Expose
    private String programType;

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

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

}
