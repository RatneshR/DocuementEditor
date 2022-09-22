package com.example.android.openoffice1;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main5Activity extends AppCompatActivity {
    Button saveup;
    EditText editText,editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        saveup = (Button) findViewById(R.id.Savebutton);
        editText1 = (EditText) findViewById(R.id.editText2);
        editText = (EditText) findViewById(R.id.text_file_data);

        saveup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String filename=editText1.getText().toString();
                String data=editText.getText().toString();

                FileOutputStream fos;
                try {
                    File myFile = new File("/sdcard/"+filename);
                    myFile.createNewFile();
                    FileOutputStream fOut = new

                            FileOutputStream(myFile);
                    OutputStreamWriter myOutWriter = new

                            OutputStreamWriter(fOut);
                    myOutWriter.append(data);
                    myOutWriter.close();
                    fOut.close();

                    Toast.makeText(getApplicationContext(),filename + " saved",Toast.LENGTH_LONG).show();


                } catch (FileNotFoundException e) {e.printStackTrace();}
                catch (IOException e) {e.printStackTrace();}

            }

        });
    }

    public void getTextFile(View v){
        //You can provide the dir location from SD card root
        String filename = editText1.getText().toString();
        String data = getTextFileData(filename);

        //Display the text contents on a TextView
        editText.setText(data);
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
