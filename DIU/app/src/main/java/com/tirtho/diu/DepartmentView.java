package com.tirtho.diu;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DepartmentView extends AppCompatActivity {
    RelativeLayout bgImage;
    TextView deptName, tvChairmanName, tvIntroduction, tvMission, tvVission, tvDesignation;
    ImageView ivChariman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_view);
        bgImage = findViewById(R.id.rl);
        deptName = findViewById(R.id.tv_dept);
        tvChairmanName = findViewById(R.id.tv_chairName);
        tvDesignation = findViewById(R.id.tv_chai_desig);
        ivChariman = findViewById(R.id.iv_chairman);

        tvIntroduction = findViewById(R.id.tv_introduction);
        tvMission = findViewById(R.id.tv_mission);
        tvVission = findViewById(R.id.tv_vission);



        ivChariman = findViewById(R.id.iv_chairman);


        String departmentName = getIntent().getStringExtra("dept_name");

        this.setTitle(departmentName);

        final String[] departments = {
                "Department of Business AdministrationService",
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
            case "Department of Business AdministrationService":
                setter(getResources().getString(R.string.dept_business_introduction)
                        , getResources().getString(R.string.dept_business_mission)
                        , getResources().getString(R.string.dept_business_vission)
                        , "Md. Siddique Alam Khan"
                        , getResources().getDrawable(R.drawable.char_bba)
                        , "Associate Professor \u0026 Chairman"
                        );

                bgImage.setBackgroundResource(R.drawable.bg_bba);


                break;
            case "Department of Civil Engineering":
                setter(getResources().getString(R.string.dept_civil_introduction)
                        , getResources().getString(R.string.dept_civil_mission)
                        , getResources().getString(R.string.dept_civil_vission)
                        , "Md. Mahfujur Rahman"
                        , getResources().getDrawable(R.drawable.char_civil)
                        , "Chairman \u0026 Assistant Professor"
                );

                bgImage.setBackgroundResource(R.drawable.bg_civil);

                break;
            case "Department of CSE":
                setter(getResources().getString(R.string.dept_cse_introduction)
                        , getResources().getString(R.string.dept_cse_mission)
                        , getResources().getString(R.string.dept_cse_vission)
                        , "Dr. A.T.M. Mahbubur Rahman Sarker"
                        , getResources().getDrawable(R.drawable.char_cse)
                        , "Dean (Faculty of Science \u0026 Eng.) \u0026 Chairman"
                );


                bgImage.setBackgroundResource(R.drawable.bg_bba);

                break;
            case "Department of EETE":
                setter(getResources().getString(R.string.dept_eete_introduction)
                        , getResources().getString(R.string.dept_eete_mission)
                        , getResources().getString(R.string.dept_eete_vission)
                        , "Md.Abdul Based"
                        , getResources().getDrawable(R.drawable.char_eee)
                        , "Associate Professor \u0026 Chairman"
                );

                bgImage.setBackgroundResource(R.drawable.bg_eee);

                break;
            case "Department of English":
                setter(getResources().getString(R.string.dept_english_introduction)
                        , getResources().getString(R.string.dept_english_mission)
                        , getResources().getString(R.string.dept_english_vission)
                        , "S. Jubair Al Ahmed"
                        , getResources().getDrawable(R.drawable.char_english)
                        , "Chairman \u0026 Assistant Professor"
                );


                bgImage.setBackgroundResource(R.drawable.bg_engliah);

                break;
            case "Department of Law":
                setter(getResources().getString(R.string.dept_law_introduction)
                        , getResources().getString(R.string.dept_law_mission)
                        , getResources().getString(R.string.dept_law_vission)
                        , "Md. Raisul Islam Sourav"
                        , getResources().getDrawable(R.drawable.char_law)
                        , "Chairman \u0026 Assistant Professor"
                );


                bgImage.setBackgroundResource(R.drawable.bg_lay);

                break;
            case "Department of Pharmacy":
                setter(getResources().getString(R.string.dept_pharmecy_introduction)
                        , getResources().getString(R.string.dept_pharmecy_mission)
                        , getResources().getString(R.string.dept_pharmecy_vission)
                        , "Professor Farida Begum"
                        , getResources().getDrawable(R.drawable.char_pharmacy)
                        , "Chairman, Department of Pharmacy"
                );

                bgImage.setBackgroundResource(R.drawable.bg_pharmacy);

                break;
            case "Department of Sociology":
                setter(getResources().getString(R.string.dept_sociology_introduction)
                        , getResources().getString(R.string.dept_sociology_mission)
                        , getResources().getString(R.string.dept_sociology_vission)
                        , "Abdur Rahim Mollah"
                        , getResources().getDrawable(R.drawable.char_sociology)
                        , "Associate Professor \u0026 Chairman"
                );

                break;
            case "Department of Economics":
                setter(getResources().getString(R.string.dept_economics_introduction)
                        , getResources().getString(R.string.dept_economics_mission)
                        , getResources().getString(R.string.dept_economics_vission)
                        , ""
                        , getResources().getDrawable(R.drawable.prof_placeholder)
                        , ""
                );


                bgImage.setBackgroundResource(R.drawable.bg_engliah);

                break;
            case "Department of Political Science":
                setter(getResources().getString(R.string.dept_political_science_introduction)
                        , getResources().getString(R.string.dept_political_science_mission)
                        , getResources().getString(R.string.dept_political_science_vission)
                        , "Md. Mahfujur Rahman"
                        , getResources().getDrawable(R.drawable.char_ps)
                        , "Chairman \u0026 Assistant Professor"
                );

                bgImage.setBackgroundResource(R.drawable.bg_civil);

                break;



        }
    }

    void setter(String introduction, String mission, String vision, String charmanName, Drawable image, String designation ){
        tvIntroduction.setText(introduction);
        tvMission.setText(mission);
        tvVission.setText(vision);
        tvChairmanName.setText(charmanName);
        tvDesignation.setText(designation);

        ivChariman.setImageDrawable(image);





    }

}
