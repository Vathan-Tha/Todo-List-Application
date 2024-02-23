package com.vathana.myhomework7;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    int date = c.get(Calendar.DAY_OF_MONTH);
    TextView textlive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button setDateButton = (Button) findViewById(R.id.set_date);
        textlive = (TextView) findViewById(R.id.textView);
    }

    public void onsetDateButtonClick(View v) {
        BlankFragment2 dateFragment = new BlankFragment2();
        dateFragment.show(getSupportFragmentManager(),"datePicker");
    }
    public void onsetTimeButtonClick(View v) {
        BlankFragment3 dateFragment = new BlankFragment3();
        dateFragment.show(getSupportFragmentManager(),"timePicker");
    }
    private void calLiveday(int year1, int month1, int dayOfMonth) {
        int yearToDate;
        int monthToDay;
        int dayToDay;
        int liveDay;

        yearToDate = (year - year1) *365;
        if(month >= month1){
            monthToDay = (month - month1)*30;

        }else{
            monthToDay = ((month -month1)+12)*30-365;
        }
        dayToDay = date - dayOfMonth;
        liveDay = yearToDate + monthToDay + dayToDay;
        textlive.setText("Up time:" + liveDay + "Day");
    }


    public void onDialogExitClick(View v){
        ComfirmExitDialog();
    }

    private Dialog ComfirmExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("").setCancelable(false).setMessage("Are you sure ?").setPositiveButton("yes", ((dialog, which) -> {
            MainActivity.this.finish();
        })).setNegativeButton("no",((dialog, which) -> {
            dialog.dismiss();
        })).show();
        AlertDialog alert = builder.create();
        return alert;

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calLiveday(year, month, dayOfMonth);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        int yearToDate;
        int monthToDay;
        int dayToDay;
        int liveDay;

        yearToDate = (year - year) *365;
        if(month >= month){
            monthToDay = (month - month)*30;

        }else{
            monthToDay = ((month -month)+12)*30-365;
        }
        dayToDay = date - hourOfDay;
        liveDay = yearToDate + monthToDay + dayToDay;
        textlive.setText("Up time:" + liveDay + "Day");
    }

}