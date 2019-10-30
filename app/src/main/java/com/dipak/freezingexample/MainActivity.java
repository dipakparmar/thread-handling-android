package com.dipak.freezingexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private boolean colorSet = true;
    Button button;
    private  static final int ACTUAL_PASS = 9234599;
    private  static final int RANGE = 50000000;
    TextView textResult;
    TextView textCount;
    TextView textAvg;
    private int count=0;
    private static double avarage = 0 ;
    private static int avgcount=0;
    private static long avgsum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.changeButton);
        textResult = findViewById(R.id.textViewResult);
        textCount = findViewById(R.id.textViewCount);
        textAvg = findViewById(R.id.textViewAvg);
    }

    public void changeColor(View view){

        if(colorSet){
            button.setBackgroundColor(Color.BLUE);

        }
        else {
            button.setBackgroundColor(Color.RED);
        }
        colorSet = !colorSet;

    }

    public  void guessPassword(View view){

        GuessPassword guessPassword = new GuessPassword();
        guessPassword.execute(ACTUAL_PASS, 10, 12,14);


//        long check = 0;
//
//
//        Random random = new Random();
//        textResult.setText("Starting Testing");
//        while (check != ACTUAL_PASS){
//            check = (long) random.nextInt(RANGE +1);
//
//            textCount.setText(count+"");
//            count++;
//
//
//
//
//
//        }
//
//        if(avgcount <5) {
//            avgsum = avgsum + count;
//            avgcount++;
//        }
//
//
//
//        long avgfull = avgsum/avgcount;
//        textResult.setText("Found Password:"+ check);
//        textAvg.setText("Average for "+avgcount+" guesses is "+ avgfull);
//        count = 0;

    }

    public class GuessPassword extends AsyncTask<Integer, Integer, String> {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textResult.setText(" Starting to guess!....");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textResult.setText(s);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            long check = 0;
            int password = integers[0];

            Random random = new Random();
            while (check != password){
                check = (long) random.nextInt(RANGE +1);

            }

            return "Found password: "+ check;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }
}
