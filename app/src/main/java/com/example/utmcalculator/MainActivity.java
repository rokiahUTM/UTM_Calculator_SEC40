package com.example.utmcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText courseNameET, courseCreditET, courseGradeET;
    EditText courseName2ET, courseCredit2ET, courseGrade2ET;
    TextView gradePointTV, gradePoint2TV;
    Button calculateBtn, resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseNameET = (EditText) findViewById(R.id.courseNameET);
        courseCreditET = (EditText) findViewById(R.id.courseCreditET);
        courseGradeET = (EditText) findViewById(R.id.courseGradeET);

        courseName2ET = (EditText) findViewById(R.id.courseNameET2);
        courseCredit2ET = (EditText) findViewById(R.id.courseCreditET2);
        courseGrade2ET = (EditText) findViewById(R.id.courseGradeET2);

        gradePointTV = (TextView) findViewById(R.id.coursePointTV);
        gradePoint2TV = (TextView) findViewById(R.id.coursePointTV2);

        calculateBtn = (Button) findViewById(R.id.calculateGPABtn);
        resetBtn = (Button) findViewById(R.id.resetBtn);

        displayGradePoint();
    }

    private Double getGradePoint(String grade){
        Double gradePoint=0.0;
        switch (grade) {
            case "A+":
                gradePoint = 4.0;
                break;
            case "A":
                gradePoint = 4.0;
                break;
            case "A-":
                gradePoint = 3.67;
                break;
            case "B+":
                gradePoint = 3.33;
                break;
            case "B":
                gradePoint = 3.00;
                break;
            case "B-":
                gradePoint = 2.67;
                break;
            case "C+":
                gradePoint = 2.33;
                break;
            case "C":
                gradePoint = 2.0;
                break;
            case "C-":
                gradePoint = 1.67;
                break;
            case "D+":
                gradePoint = 1.33;
                break;
            case "D":
                gradePoint = 1.00;
                break;
            case "D-":
                gradePoint = 0.67;
                break;
            case "E":
                gradePoint = 0.0;
                break;
        }
        return gradePoint;
    }

    private boolean isEmpty(int stringLength){
        if (stringLength==0) return true;
        return false;
    }

    private void displayGradePoint(){
        courseGradeET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!isEmpty(courseCreditET.length())) {
                    int credit = Integer.parseInt(courseCreditET.getText().toString());
                    Double gradePoint = credit * getGradePoint(courseGradeET.getText().toString());
                    gradePointTV.setText(gradePoint.toString());
                }
                else courseCreditET.setError("This field is required");
            }
        });

    }

}



