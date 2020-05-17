
package com.tirtho.com.tirtho.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GradePointSystemDetail {

    @SerializedName("pc_mark")
    @Expose
    private String pcMark;
    @SerializedName("letter")
    @Expose
    private String letter;
    @SerializedName("in_word")
    @Expose
    private String inWord;
    @SerializedName("grade_point")
    @Expose
    private String gradePoint;

    public String getPcMark() {
        return pcMark;
    }

    public void setPcMark(String pcMark) {
        this.pcMark = pcMark;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getInWord() {
        return inWord;
    }

    public void setInWord(String inWord) {
        this.inWord = inWord;
    }

    public String getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(String gradePoint) {
        this.gradePoint = gradePoint;
    }

}
