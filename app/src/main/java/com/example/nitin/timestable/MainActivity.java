package com.example.nitin.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    public void generateTimesTable(int num){
        ArrayList<String> content = new ArrayList<String>();
        for(int i = 1; i<=10; i++){
            content.add(num + "*" + i + "=" + Integer.toString(num*i));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, content);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        listView = findViewById(R.id.listView);
        int startPos = 6;
        seekBar.setProgress(startPos);
        generateTimesTable(startPos);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int num;
                if(progress<min){
                    num = min;
                    seekBar.setProgress(min);
                }
                else{
                    num = progress;
                }
                Log.i("Seekbar at", Integer.toString(num));
                generateTimesTable(num);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
