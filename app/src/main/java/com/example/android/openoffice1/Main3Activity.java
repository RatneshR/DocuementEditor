package com.example.android.openoffice1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main3Activity extends AppCompatActivity {
    EditText editTextFileName,editTextData;
    Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editTextFileName = (EditText) findViewById(R.id.editText1);
        editTextData = (EditText) findViewById(R.id.editText2);
        saveButton = (Button) findViewById(R.id.button1);

        //Performing action on save button
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String filename = editTextFileName.getText().toString();
                String data = editTextData.getText().toString();

                try {
                    File myFile = new File("/sdcard/" + filename);
                    myFile.createNewFile();
                    FileOutputStream fOut = new

                            FileOutputStream(myFile);
                    OutputStreamWriter myOutWriter = new

                            OutputStreamWriter(fOut);
                    myOutWriter.append(data);
                    myOutWriter.close();
                    fOut.close();

                    Toast.makeText(getApplicationContext(), filename + " saved", Toast.LENGTH_LONG).show();


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });

    }
}
