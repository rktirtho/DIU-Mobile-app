package com.tirtho.com.tirtho.diu.custome.list;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tirtho.com.tirtho.result.Semester;
import com.tirtho.diu.R;

import java.util.List;

public class ResultCardAdepter extends ArrayAdapter<Semester> {

    List<Semester> semesters;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public ResultCardAdepter(Context context, int resource, List<Semester> semesters) {
        super(context, resource, semesters);
        this.context = context;
        this.resource = resource;
        this.semesters = semesters;
    }

    public ResultCardAdepter(Context context, int resource) {
        super(context, resource);
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(resource, null, false);


        //getting the view elements of the list from the view
        TextView tvsemester = view.findViewById(R.id.semester);
        TextView subject = view.findViewById(R.id.total_subject);
        TextView credit = view.findViewById(R.id.total_credit);
        TextView scgpa = view.findViewById(R.id.scgpa);
        TextView laterGrade = view.findViewById(R.id.lgrade);
        TextView result = view.findViewById(R.id.semester_result);

        Semester semester = semesters.get(position);

        tvsemester.setText("Semester "+semester.getSemester());
        subject.setText("Total Subject : "+semester.getTotalSubject());
        credit.setText("Total Credit : "+semester.getTotalCredit());
        scgpa.setText("SCGPA : "+semester.getTotalSemesterGpa());
        laterGrade.setText("Later Grade : "+semester.getAverageGrade());
        result.setText("Result : "+semester.getSemesterResult());


        return view;
    }


}

