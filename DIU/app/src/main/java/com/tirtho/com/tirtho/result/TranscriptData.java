
package com.tirtho.com.tirtho.result;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TranscriptData {

//    @SerializedName("semesters")
//    @Expose
//    private List<List<Semester>> semesters = null;
    @SerializedName("results")
    @Expose
    private Results results;

//    public List<List<Semester>> getSemesters() {
//        return semesters;
//    }
//
//    public void setSemesters(List<List<Semester>> semesters) {
//        this.semesters = semesters;
//    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

}
