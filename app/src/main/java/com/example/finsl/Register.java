package com.example.finsl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText mEmail, mName, mPhone, mPass, mBranch;
    Button mReg;
    TextView mLogin;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmail = findViewById(R.id.emailEditText);
        mName = findViewById(R.id.nameEditText);
        mPhone = findViewById(R.id.phoneEditText);
        mPass = findViewById(R.id.passwordEditText);
        mBranch = findViewById(R.id.branchEditText);
        mReg = findViewById(R.id.loginButton);
        mLogin = findViewById(R.id.signText);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        /*if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext().Login.class));
            finish();
        }*/

        mReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString().trim();
                String password = mPass.getText().toString().trim();
                final String name = mName.getText().toString();
                final String phone = mPhone.getText().toString();
                final String branch = mBranch.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is required!!");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mPass.setError("Password is required");
                    return;
                }
                if (password.length() < 6) {
                    mPass.setError("Password mus be greater or equal to 6 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //Register the user
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "User creation successful", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference doc = fStore.collection("Students").document(userID);
                            Map<String, Object> user = new HashMap<>();
                            user.put("Name", name);
                            user.put("Email", email);
                            user.put("Phone", phone);
                            user.put("Branch", branch);
                            doc.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "On success: user profile is created for" + userID);
                                }
                            });
                            startActivity(new Intent(getApplicationContext(), Login.class));
                        } else {
                            Toast.makeText(Register.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }
}
