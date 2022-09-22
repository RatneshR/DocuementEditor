package com.example.android.openoffice1;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class Main7Activity extends AppCompatActivity {
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        editText1 = (EditText) findViewById(R.id.editText3);
        Button btn = (Button)findViewById(R.id.share1);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String file_name = editText1.getText().toString();

                String path = Environment.getExternalStorageDirectory().toString() +"/" + file_name  ;
                File file = new File(path);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/*");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + file.getAbsolutePath()));
                startActivity(Intent.createChooser(intent,"Share File With!!"));

            }
        });
    }
}
