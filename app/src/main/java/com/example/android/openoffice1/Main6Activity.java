package com.example.android.openoffice1;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class Main6Activity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        editText = (EditText) findViewById(R.id.editText);
    }

    public void deleteFile(View view) {
        String FILE_NAME = editText.getText().toString();
        File sdCardDir = Environment.getExternalStorageDirectory();


        File file = new File(sdCardDir,FILE_NAME);

        if(file.exists()){
            deleteFile(FILE_NAME);
            file.delete();
            Toast.makeText(getApplicationContext(),"File Delete Success",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"File Not Found",Toast.LENGTH_LONG).show();
        }
    }
}
