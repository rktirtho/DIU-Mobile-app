
package com.tirtho.com.tirtho.user;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfile {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug_name")
    @Expose
    private String slugName;
    @SerializedName("site_tag")
    @Expose
    private Object siteTag;
    @SerializedName("roll_no")
    @Expose
    private Integer rollNo;
    @SerializedName("reg_code")
    @Expose
    private String regCode;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("reg_sl_no")
    @Expose
    private Integer regSlNo;
    @SerializedName("department_id")
    @Expose
    private Integer departmentId;
    @SerializedName("batch_id")
    @Expose
    private Integer batchId;
    @SerializedName("shift_id")
    @Expose
    private Integer shiftId;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone_no")
    @Expose
    private String phoneNo;
    @SerializedName("adm_frm_sl")
    @Expose
    private String admFrmSl;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("blood_group")
    @Expose
    private String bloodGroup;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("birth_place")
    @Expose
    private String birthPlace;
    @SerializedName("parmanent_address")
    @Expose
    private String parmanentAddress;
    @SerializedName("mailing_address")
    @Expose
    private String mailingAddress;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("marital_status")
    @Expose
    private String maritalStatus;
    @SerializedName("adm_date")
    @Expose
    private String admDate;
    @SerializedName("birth_or_nid_no")
    @Expose
    private String birthOrNidNo;
    @SerializedName("father_name")
    @Expose
    private String fatherName;
    @SerializedName("father_cellno")
    @Expose
    private String fatherCellno;
    @SerializedName("father_occupation")
    @Expose
    private String fatherOccupation;
    @SerializedName("father_nid_no")
    @Expose
    private String fatherNidNo;
    @SerializedName("mother_name")
    @Expose
    private String motherName;
    @SerializedName("mother_cellno")
    @Expose
    private String motherCellno;
    @SerializedName("mother_occupation")
    @Expose
    private String motherOccupation;
    @SerializedName("mother_nid_no")
    @Expose
    private String motherNidNo;
    @SerializedName("guardian_name")
    @Expose
    private String guardianName;
    @SerializedName("guardian_cellno")
    @Expose
    private String guardianCellno;
    @SerializedName("guardian_occupation")
    @Expose
    private String guardianOccupation;
    @SerializedName("emergency_name")
    @Expose
    private String emergencyName;
    @SerializedName("emergency_cellno")
    @Expose
    private String emergencyCellno;
    @SerializedName("emergency_occupation")
    @Expose
    private String emergencyOccupation;
    @SerializedName("emergency_address")
    @Expose
    private String emergencyAddress;
    @SerializedName("emergency_relation")
    @Expose
    private String emergencyRelation;
    @SerializedName("diu_email")
    @Expose
    private String diuEmail;
    @SerializedName("wifi_username")
    @Expose
    private String wifiUsername;
    @SerializedName("mac_address")
    @Expose
    private Object macAddress;
    @SerializedName("about_me")
    @Expose
    private Object aboutMe;
    @SerializedName("show_profile_publicly")
    @Expose
    private String showProfilePublicly;
    @SerializedName("profile_photo")
    @Expose
    private String profilePhoto;
    @SerializedName("social_links")
    @Expose
    private List<Object> socialLinks = null;
    @SerializedName("educations")
    @Expose
    private List<Object> educations = null;
    @SerializedName("has_cv")
    @Expose
    private String hasCv;

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

    public String getSlugName() {
        return slugName;
    }

    public void setSlugName(String slugName) {
        this.slugName = slugName;
    }

    public Object getSiteTag() {
        return siteTag;
    }

    public void setSiteTag(Object siteTag) {
        this.siteTag = siteTag;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getRegSlNo() {
        return regSlNo;
    }

    public void setRegSlNo(Integer regSlNo) {
        this.regSlNo = regSlNo;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAdmFrmSl() {
        return admFrmSl;
    }

    public void setAdmFrmSl(String admFrmSl) {
        this.admFrmSl = admFrmSl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getParmanentAddress() {
        return parmanentAddress;
    }

    public void setParmanentAddress(String parmanentAddress) {
        this.parmanentAddress = parmanentAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAdmDate() {
        return admDate;
    }

    public void setAdmDate(String admDate) {
        this.admDate = admDate;
    }

    public String getBirthOrNidNo() {
        return birthOrNidNo;
    }

    public void setBirthOrNidNo(String birthOrNidNo) {
        this.birthOrNidNo = birthOrNidNo;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherCellno() {
        return fatherCellno;
    }

    public void setFatherCellno(String fatherCellno) {
        this.fatherCellno = fatherCellno;
    }

    public String getFatherOccupation() {
        return fatherOccupation;
    }

    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    public String getFatherNidNo() {
        return fatherNidNo;
    }

    public void setFatherNidNo(String fatherNidNo) {
        this.fatherNidNo = fatherNidNo;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherCellno() {
        return motherCellno;
    }

    public void setMotherCellno(String motherCellno) {
        this.motherCellno = motherCellno;
    }

    public String getMotherOccupation() {
        return motherOccupation;
    }

    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
    }

    public String getMotherNidNo() {
        return motherNidNo;
    }

    public void setMotherNidNo(String motherNidNo) {
        this.motherNidNo = motherNidNo;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianCellno() {
        return guardianCellno;
    }

    public void setGuardianCellno(String guardianCellno) {
        this.guardianCellno = guardianCellno;
    }

    public String getGuardianOccupation() {
        return guardianOccupation;
    }

    public void setGuardianOccupation(String guardianOccupation) {
        this.guardianOccupation = guardianOccupation;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getEmergencyCellno() {
        return emergencyCellno;
    }

    public void setEmergencyCellno(String emergencyCellno) {
        this.emergencyCellno = emergencyCellno;
    }

    public String getEmergencyOccupation() {
        return emergencyOccupation;
    }

    public void setEmergencyOccupation(String emergencyOccupation) {
        this.emergencyOccupation = emergencyOccupation;
    }

    public String getEmergencyAddress() {
        return emergencyAddress;
    }

    public void setEmergencyAddress(String emergencyAddress) {
        this.emergencyAddress = emergencyAddress;
    }

    public String getEmergencyRelation() {
        return emergencyRelation;
    }

    public void setEmergencyRelation(String emergencyRelation) {
        this.emergencyRelation = emergencyRelation;
    }

    public String getDiuEmail() {
        return diuEmail;
    }

    public void setDiuEmail(String diuEmail) {
        this.diuEmail = diuEmail;
    }

    public String getWifiUsername() {
        return wifiUsername;
    }

    public void setWifiUsername(String wifiUsername) {
        this.wifiUsername = wifiUsername;
    }

    public Object getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(Object macAddress) {
        this.macAddress = macAddress;
    }

    public Object getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(Object aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getShowProfilePublicly() {
        return showProfilePublicly;
    }

    public void setShowProfilePublicly(String showProfilePublicly) {
        this.showProfilePublicly = showProfilePublicly;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public List<Object> getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(List<Object> socialLinks) {
        this.socialLinks = socialLinks;
    }

    public List<Object> getEducations() {
        return educations;
    }

    public void setEducations(List<Object> educations) {
        this.educations = educations;
    }

    public String getHasCv() {
        return hasCv;
    }

    public void setHasCv(String hasCv) {
        this.hasCv = hasCv;
    }

}
