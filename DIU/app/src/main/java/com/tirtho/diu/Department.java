package com.tirtho.diu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tirtho.com.tirtho.diu.custome.list.CustomClubList;
import com.tirtho.pojo.StudentCommunity;

import java.util.ArrayList;
import java.util.List;

public class Department extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        final List<StudentCommunity> departments = new ArrayList<>();
        departments.add(new StudentCommunity(R.drawable.dept_business, "Department of Business AdministrationService"));
        departments.add(new StudentCommunity(R.drawable.dept_cvl, "Department of Civil Engineering"));
        departments.add(new StudentCommunity(R.drawable.dept_com, "Department of CSE"));
        departments.add(new StudentCommunity(R.drawable.dept_comm, "Department of Economics"));
        departments.add(new StudentCommunity(R.drawable.dept_eee, "Department of EETE"));
        departments.add(new StudentCommunity(R.drawable.dept_english, "Department of English"));
        departments.add(new StudentCommunity(R.drawable.dept_law, "Department of Law"));
        departments.add(new StudentCommunity(R.drawable.dept_pharmacy, "Department of Pharmacy"));
        departments.add(new StudentCommunity(R.drawable.dept_comm, "Department of Sociology"));
        departments.add(new StudentCommunity(R.drawable.dept_comm, "Department of Political Science"));
        listView = findViewById(R.id.list_dept);






        CustomClubList deptList = new CustomClubList(this, R.layout.model_student_community,departments);
        listView.setAdapter(deptList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Department.this, DepartmentView.class);
                intent.putExtra("dept_name", departments.get(position).getName());
                intent.putExtra("dept_code", position);
                startActivity(intent);

            }
        });


    }
}
