
package com.tirtho.com.tirtho.result;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("transcript_data")
    @Expose
    private TranscriptData transcriptData;
    @SerializedName("student_info")
    @Expose
    private StudentInfo studentInfo;
    @SerializedName("grade_point_system_details")
    @Expose
    private List<GradePointSystemDetail> gradePointSystemDetails = null;

    public TranscriptData getTranscriptData() {
        return transcriptData;
    }

    public void setTranscriptData(TranscriptData transcriptData) {
        this.transcriptData = transcriptData;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public List<GradePointSystemDetail> getGradePointSystemDetails() {
        return gradePointSystemDetails;
    }

    public void setGradePointSystemDetails(List<GradePointSystemDetail> gradePointSystemDetails) {
        this.gradePointSystemDetails = gradePointSystemDetails;
    }

}
