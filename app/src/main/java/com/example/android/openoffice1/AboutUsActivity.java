package com.example.android.openoffice1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class AboutUsActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        toolbar = (Toolbar)findViewById(R.id.toolbar2);

        toolbar.setTitle("About Us!!!");
        toolbar.setSubtitle("The Developers.");
    }
}
