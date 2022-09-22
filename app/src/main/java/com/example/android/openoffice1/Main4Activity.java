package com.example.android.openoffice1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main4Activity extends AppCompatActivity {
    TextView dispText;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        dispText = (TextView) findViewById(R.id.text_file_data);
        editText = (EditText) findViewById(R.id.editText2);

        Button btn = (Button)findViewById(R.id.share);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String file_name = editText.getText().toString();

                String path = Environment.getExternalStorageDirectory().toString() +"/" + file_name  ;
                File file = new File(path);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/*");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + file.getAbsolutePath()));
                startActivity(Intent.createChooser(intent,"Share File With!!"));

            }
        });
    }
    public void getTextFile(View v){
        //You can provide the dir location from SD card root
        String filename = editText.getText().toString();
        String data = getTextFileData(filename);

        //Display the text contents on a TextView
        dispText.setText(data);
    }

    public String getTextFileData(String fileName){
        //Get The Directory of SD Card
        File sdCardDir = Environment.getExternalStorageDirectory();

        //Get the Text file
        File txtFile = new File(sdCardDir,fileName);

        //Read the file Contents in a StringBuilder Object
        StringBuilder text = new StringBuilder();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(txtFile));
            String line;

            while((line = bufferedReader.readLine()) != null){
                text.append(line + '\n');
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            Log.e("No","File not found!!!") ;       } catch (IOException e) {
            Log.e("C2c","Error Occurred while reading text file !");
        }
        return text.toString();

    }

}
