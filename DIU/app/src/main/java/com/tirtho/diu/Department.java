package com.tirtho.diu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Department extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        listView = findViewById(R.id.list_dept);

        final String[] departments= {
                "Department of Business Administration",
                "Department of Civil Engineering",
                "Department of CSE",
                "Department of EETE",
                "Department of English",
                "Department of Law",
                "Department of Pharmacy",
                "Department of Sociology",
                "Department of Economics",
                "Department of Political Science"
        };

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.model_department,R.id.dept_name,departments);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Department.this, DepartmentView.class);
                intent.putExtra("dept_name", departments[position]);
                intent.putExtra("dept_code", position);
                startActivity(intent);

            }
        });


    }
}
