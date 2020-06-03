package com.example.finsl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class DashBoard extends AppCompatActivity {
    Button mCalc,mCal,mYt,mRec,mSyl,mTo,mBack;
    private ArrayList<HashMap<String,Object>> items;
    List<PackageInfo> packs;
    private PackageManager pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        mCal    = findViewById(R.id.calBtn);
        mCalc   = findViewById(R.id.calcBtn);
        mYt     = findViewById(R.id.ytBtn);
        mRec    = findViewById(R.id.recBtn);
        mSyl    = findViewById(R.id.sylBtn);
        mTo     = findViewById(R.id.toDoBtn);
        mBack   = findViewById(R.id.backBtn);
        mCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openCal();
            }
        });
        mCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculator();
            }
        });
        mYt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYt();
            }
        });
        mRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recorder();
            }
        });
        mSyl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Syllabus.class));
            }
        });
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),main.class));
            }
        });
    }


    public void openCal() {
        try {
            Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
            builder.appendPath("time");
            ContentUris.appendId(builder, Calendar.getInstance().getTimeInMillis());
            Intent intent = new Intent(Intent.ACTION_VIEW)
                    .setData(builder.build());
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(DashBoard.this, "App not Found",Toast.LENGTH_SHORT).show();
        }
    }
    public void openYt() {
        try {

            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
            startActivity(launchIntent);
        } catch (Exception e) {
            Toast.makeText(DashBoard.this, "App not Found",Toast.LENGTH_SHORT).show();
        }
    }
    public void Recorder() {
        try {
            int ACTIVITY_RECORD_SOUND = 0;
            Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
            startActivityForResult(intent, ACTIVITY_RECORD_SOUND);
        } catch (Exception e) {
            Toast.makeText(DashBoard.this, "App not Found",Toast.LENGTH_SHORT).show();
        }
    }
    public void openCalculator(){
        items =new ArrayList<HashMap<String,Object>>();
        pm = getPackageManager();
        packs = pm.getInstalledPackages(0);
        for (PackageInfo pi : packs)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("appName", pi.applicationInfo.loadLabel(pm));
            map.put("packageName", pi.packageName);
            items.add(map);
        }
        int d=0;
        if(items.size()>=1){
            int j=0;
            for(j=0;j<items.size();j++){
                String AppName = (String) items.get(j).get("appName");
                if(AppName.matches("Calculator"))
                {
                    d=j;
                    break;
                }
            }
            String packageName = (String) items.get(d).get("packageName");

            Intent i = pm.getLaunchIntentForPackage(packageName);
            if (i != null){
                Toast.makeText(DashBoard.this,"STARTING",Toast.LENGTH_SHORT).show();

                startActivity(i);}
            else {
                Toast.makeText(DashBoard.this,"SORRY I CANT OPEN CALCULATOR :(",Toast.LENGTH_SHORT).show();

            }
        }


        else{
            Toast.makeText(DashBoard.this,"SORRY I CANT START CALCULATOR :(",Toast.LENGTH_SHORT).show();


        }

    }

}
