package com.example.finsl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class main extends AppCompatActivity {
    TextView mName, mEmail, mPhone, mBranch;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName   = findViewById(R.id.nameText);
        mEmail  = findViewById(R.id.emailText);
        mPhone  = findViewById(R.id.phoneText);
        mBranch = findViewById(R.id.branchText);
        fAuth   = FirebaseAuth.getInstance();
        fStore  = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();
        DocumentReference doc = fStore.collection("Students").document(userID);
        doc.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                mPhone.setText(documentSnapshot.getString("Phone"));
                mName.setText(documentSnapshot.getString("Name"));
                mEmail.setText(documentSnapshot.getString("Email"));
                mBranch.setText(documentSnapshot.getString("Branch"));
            }
        });

    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class)
        );
        finish();
    }

    public void openDash(View view) {
        startActivity(new Intent(getApplicationContext(),DashBoard.class));
    }
}
