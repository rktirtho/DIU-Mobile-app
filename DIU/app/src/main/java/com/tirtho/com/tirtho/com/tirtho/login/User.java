package com.tirtho.com.tirtho.com.tirtho.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("roll_no")
    @Expose
    private Integer rollNo;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug_name")
    @Expose
    private String slug_name;
    @SerializedName("reg_code")
    @Expose
    private String reg_code;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("profile_photo")
    @Expose
    private String profile_photo;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug_name() {
        return slug_name;
    }

    public void setSlug_name(String slug_name) {
        this.slug_name = slug_name;
    }

    public String getReg_code() {
        return reg_code;
    }

    public void setReg_code(String reg_code) {
        this.reg_code = reg_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }
}
