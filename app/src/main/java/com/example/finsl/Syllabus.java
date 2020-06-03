package com.example.finsl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Syllabus extends AppCompatActivity {
    Spinner sp_sem,sp_sub,sp_mod,sp_branch;
    ArrayList<String> semester,mod;
    ArrayAdapter<String> semester_adaper,mod_adapter;
    String sub,module;
    Button mSubmit;

    ArrayList<String> sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8,branch,sem0;
    ArrayAdapter<String> subject_adapter,branch_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        int i = 1;
        final Intent intent = new Intent(getApplicationContext(),Module.class);
        mSubmit = findViewById(R.id.submitBtn);
        sp_sem = findViewById(R.id.sp_semester);
        sp_sub = findViewById(R.id.sp_subject);
        sp_mod = findViewById(R.id.sp_module);
        sp_branch = findViewById(R.id.sp_branch);
        mod = new ArrayList<>();
        mod.add("Select One");
        branch = new ArrayList<>();
        initialize();
        sem0.add("Select One");
        branch.add("Select One");
        branch.add("Electrical Engineering");
        branch.add("Computer Science And Engineering");
        branch.add("Civil Engineering");
        branch.add("Instrumentation and Electronics Engineering");
        branch.add("Information Technology");
        branch.add("Mechanical Engineering");
        branch.add("Textile Engineering");
        branch.add("Biotechnology");
        branch.add("Fashion and Apparel Technology");
        branch_adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spineer_layout, branch);
        sp_branch.setAdapter(branch_adapter);
        semester = new ArrayList<>();
        semester.add("Select One");
        while (i < 9) {
            semester.add(i+"");
            i++;
        }

        semester_adaper = new ArrayAdapter<>(getApplicationContext(), R.layout.spineer_layout, semester);
        sp_sem.setAdapter(semester_adaper);


        sp_branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    Clear();
                    sem0.add("Select One");sem1.add("Select One");sem2.add("Select One");sem3.add("Select One");sem4.add("Select One");sem5.add("Select One");sem6.add("Select One");sem7.add("Select One");sem8.add("Select One");
                    sem1.add("Physics");
                    sem2.add("Chemistry");
                    sem3.add("Electrical Circuit Analysis");
                    sem4.add("Electrical Machine 2");
                    sem5.add("Power Electronics");
                    sem6.add("Electric Drives");
                    sem7.add("Artificial Intelligence");
                    sem8.add("Machine Learning");

                }
                if (position == 2) {
                    Clear();
                    sem1.add("Chemistry");
                    sem2.add("Physics");
                    sem3.add("Ada");
                    sem4.add("OS");
                    sem5.add("AI");
                    sem6.add("ML");
                    sem7.add("Linux");
                    sem8.add("power");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        subject_adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.spineer_layout,sem0);
        sp_sub.setAdapter(subject_adapter);
        sp_sem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position1, long id) {
                if (position1 == 0)
                    subject_adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.spineer_layout,sem0);
                if (position1 == 1)
                    subject_adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spineer_layout, sem1);
                if (position1 == 2)
                    subject_adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spineer_layout, sem2);
                if (position1 == 3)
                    subject_adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spineer_layout, sem3);
                if (position1 == 4)
                    subject_adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spineer_layout, sem4);
                if (position1 == 5)
                    subject_adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spineer_layout, sem5);
                if (position1 == 6)
                    subject_adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spineer_layout, sem6);
                if (position1 == 7)
                    subject_adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spineer_layout, sem7);
                if (position1 == 8)
                    subject_adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spineer_layout, sem8);
                sp_sub.setAdapter(subject_adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                subject_adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.spineer_layout,sem0);
                sp_sub.setAdapter(subject_adapter);
            }
        });
        sp_sub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>0) {
                    sub = sp_sub.getSelectedItem().toString();
                    if (position == 1)
                    {
                        mod.clear();
                        mod.add("Select One");
                        mod.add(""+1);
                        mod.add(""+2);
                        mod.add(""+3);

                    }
                }
                else
                    sub = null;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mod_adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.spineer_layout, mod);
        sp_mod.setAdapter(mod_adapter);
        sp_mod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position>0)
                    module = sp_mod.getSelectedItem().toString();
                else
                    module = null;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sub != null && module!=null) {
                    intent.putExtra("sub", sub);
                    intent.putExtra("mod",module);
                    startActivity(intent);
                }
                else
                    Toast.makeText(Syllabus.this,"Check subject or module",Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void initialize()
    {
        sem0 = new ArrayList<>();
        sem1 = new ArrayList<>();
        sem2 = new ArrayList<>();
        sem3 = new ArrayList<>();
        sem4 = new ArrayList<>();
        sem5 = new ArrayList<>();
        sem6 = new ArrayList<>();
        sem7 = new ArrayList<>();
        sem8 = new ArrayList<>();
    }
    public void Clear()
    {
        sem0.clear();
        sem1.clear();
        sem2.clear();
        sem3.clear();
        sem4.clear();
        sem5.clear();
        sem6.clear();
        sem7.clear();
        sem8.clear();
    }
}