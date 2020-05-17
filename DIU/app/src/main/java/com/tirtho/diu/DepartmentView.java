package com.tirtho.diu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DepartmentView extends AppCompatActivity {
    RelativeLayout bgImage;
    TextView deptName, tvChairmanName, tvIntroduction, tvMission, tvVission;
    ImageView ivChariman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_view);
        bgImage = findViewById(R.id.rl);
        deptName = findViewById(R.id.tv_dept);
        tvChairmanName = findViewById(R.id.tv_chairName);

        tvIntroduction = findViewById(R.id.tv_introduction);
        tvMission = findViewById(R.id.tv_mission);
        tvVission = findViewById(R.id.tv_vission);

        ivChariman = findViewById(R.id.iv_chairman);


        String departmentName = getIntent().getStringExtra("dept_name");

        this.setTitle(departmentName);

        final String[] departments = {
                "Department of Business Administration",
                "Department of Civil Engineering",
                "Department of CSE",
                "Department of EETE",
                "Department of English",
                "Department of Pharmacy",
                "Department of Sociology",
                "Department of Economics",
                "Department of Political Science"
        };
        deptName.setText(departmentName);


        switch (departmentName) {
            case "Department of Business Administration":
                setter(getResources().getString(R.string.dept_business_introduction)
                        , getResources().getString(R.string.dept_business_mission)
                        , getResources().getString(R.string.dept_business_vission));

                break;
            case "Department of Civil Engineering":
                setter(getResources().getString(R.string.dept_civil_introduction)
                        , getResources().getString(R.string.dept_civil_mission)
                        , getResources().getString(R.string.dept_civil_vission));
                break;
            case "Department of CSE":
                setter(getResources().getString(R.string.dept_cse_introduction)
                        , getResources().getString(R.string.dept_cse_mission)
                        , getResources().getString(R.string.dept_cse_vission));
                break;
            case "Department of EETE":
                setter(getResources().getString(R.string.dept_eete_introduction)
                        , getResources().getString(R.string.dept_eete_mission)
                        , getResources().getString(R.string.dept_eete_vission));
                break;
            case "Department of English":
                setter(getResources().getString(R.string.dept_english_introduction)
                        , getResources().getString(R.string.dept_english_mission)
                        , getResources().getString(R.string.dept_english_vission));
                break;
            case "Department of Pharmacy":
                setter(getResources().getString(R.string.dept_pharmecy_introduction)
                        , getResources().getString(R.string.dept_pharmecy_mission)
                        , getResources().getString(R.string.dept_pharmecy_vission));
                break;
            case "Department of Sociology":
                setter(getResources().getString(R.string.dept_sociology_introduction)
                        , getResources().getString(R.string.dept_sociology_mission)
                        , getResources().getString(R.string.dept_sociology_vission));
                break;
            case "Department of Economics":
                setter(getResources().getString(R.string.dept_economics_introduction)
                        , getResources().getString(R.string.dept_economics_mission)
                        , getResources().getString(R.string.dept_economics_vission));
                break;
            case "Department of Political Science":
                setter(getResources().getString(R.string.dept_political_science_introduction)
                        , getResources().getString(R.string.dept_political_science_mission)
                        , getResources().getString(R.string.dept_political_science_vission));
                break;



        }
    }

    void setter(String introduction, String mission, String vision){
        tvIntroduction.setText(introduction);
        tvMission.setText(mission);
        tvVission.setText(vision);

    }

}
