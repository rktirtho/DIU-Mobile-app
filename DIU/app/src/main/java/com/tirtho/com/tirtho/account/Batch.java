
package com.tirtho.com.tirtho.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Batch {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("department_id")
    @Expose
    private String departmentId;
    @SerializedName("group_id")
    @Expose
    private String groupId;
    @SerializedName("shift_id")
    @Expose
    private String shiftId;
    @SerializedName("campus_id")
    @Expose
    private String campusId;
    @SerializedName("said_fee")
    @Expose
    private String saidFee;
    @SerializedName("common_scholarship")
    @Expose
    private String commonScholarship;
    @SerializedName("no_of_semester")
    @Expose
    private String noOfSemester;
    @SerializedName("duration_of_sem_m")
    @Expose
    private String durationOfSemM;
    @SerializedName("no_seat")
    @Expose
    private String noSeat;
    @SerializedName("sess")
    @Expose
    private String sess;
    @SerializedName("valid_d_idcard")
    @Expose
    private String validDIdcard;
    @SerializedName("active_status")
    @Expose
    private String activeStatus;
    @SerializedName("class_str_date")
    @Expose
    private String classStrDate;
    @SerializedName("creator_id")
    @Expose
    private String creatorId;
    @SerializedName("last_date_of_adm")
    @Expose
    private String lastDateOfAdm;
    @SerializedName("batch_name")
    @Expose
    private String batchName;
    @SerializedName("reg_card_printed")
    @Expose
    private String regCardPrinted;
    @SerializedName("splitted")
    @Expose
    private String splitted;
    @SerializedName("parent_batch_id")
    @Expose
    private Object parentBatchId;
    @SerializedName("splited_by")
    @Expose
    private Object splitedBy;
    @SerializedName("splited_approved_by")
    @Expose
    private Object splitedApprovedBy;
    @SerializedName("splited_approved_at")
    @Expose
    private Object splitedApprovedAt;
    @SerializedName("splited_at")
    @Expose
    private Object splitedAt;
    @SerializedName("payment_system_id")
    @Expose
    private String paymentSystemId;
    @SerializedName("paymemt_system")
    @Expose
    private PaymemtSystem paymemtSystem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    public String getCampusId() {
        return campusId;
    }

    public void setCampusId(String campusId) {
        this.campusId = campusId;
    }

    public String getSaidFee() {
        return saidFee;
    }

    public void setSaidFee(String saidFee) {
        this.saidFee = saidFee;
    }

    public String getCommonScholarship() {
        return commonScholarship;
    }

    public void setCommonScholarship(String commonScholarship) {
        this.commonScholarship = commonScholarship;
    }

    public String getNoOfSemester() {
        return noOfSemester;
    }

    public void setNoOfSemester(String noOfSemester) {
        this.noOfSemester = noOfSemester;
    }

    public String getDurationOfSemM() {
        return durationOfSemM;
    }

    public void setDurationOfSemM(String durationOfSemM) {
        this.durationOfSemM = durationOfSemM;
    }

    public String getNoSeat() {
        return noSeat;
    }

    public void setNoSeat(String noSeat) {
        this.noSeat = noSeat;
    }

    public String getSess() {
        return sess;
    }

    public void setSess(String sess) {
        this.sess = sess;
    }

    public String getValidDIdcard() {
        return validDIdcard;
    }

    public void setValidDIdcard(String validDIdcard) {
        this.validDIdcard = validDIdcard;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getClassStrDate() {
        return classStrDate;
    }

    public void setClassStrDate(String classStrDate) {
        this.classStrDate = classStrDate;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getLastDateOfAdm() {
        return lastDateOfAdm;
    }

    public void setLastDateOfAdm(String lastDateOfAdm) {
        this.lastDateOfAdm = lastDateOfAdm;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getRegCardPrinted() {
        return regCardPrinted;
    }

    public void setRegCardPrinted(String regCardPrinted) {
        this.regCardPrinted = regCardPrinted;
    }

    public String getSplitted() {
        return splitted;
    }

    public void setSplitted(String splitted) {
        this.splitted = splitted;
    }

    public Object getParentBatchId() {
        return parentBatchId;
    }

    public void setParentBatchId(Object parentBatchId) {
        this.parentBatchId = parentBatchId;
    }

    public Object getSplitedBy() {
        return splitedBy;
    }

    public void setSplitedBy(Object splitedBy) {
        this.splitedBy = splitedBy;
    }

    public Object getSplitedApprovedBy() {
        return splitedApprovedBy;
    }

    public void setSplitedApprovedBy(Object splitedApprovedBy) {
        this.splitedApprovedBy = splitedApprovedBy;
    }

    public Object getSplitedApprovedAt() {
        return splitedApprovedAt;
    }

    public void setSplitedApprovedAt(Object splitedApprovedAt) {
        this.splitedApprovedAt = splitedApprovedAt;
    }

    public Object getSplitedAt() {
        return splitedAt;
    }

    public void setSplitedAt(Object splitedAt) {
        this.splitedAt = splitedAt;
    }

    public String getPaymentSystemId() {
        return paymentSystemId;
    }

    public void setPaymentSystemId(String paymentSystemId) {
        this.paymentSystemId = paymentSystemId;
    }

    public PaymemtSystem getPaymemtSystem() {
        return paymemtSystem;
    }

    public void setPaymemtSystem(PaymemtSystem paymemtSystem) {
        this.paymemtSystem = paymemtSystem;
    }

}
