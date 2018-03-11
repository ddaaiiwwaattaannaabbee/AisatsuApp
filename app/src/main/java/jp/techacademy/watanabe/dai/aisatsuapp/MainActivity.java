package jp.techacademy.watanabe.dai.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.app.TimePickerDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        mTextView.setText(getAisatu(hourOfDay,minute));
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }

    private String getAisatu(int hourOfDay, int minute){

        String aisatu = "";

        if( 2<= hourOfDay && hourOfDay <=9 ){
            aisatu =  "おはよう";
        }else if ( 10<= hourOfDay && hourOfDay <=17 ){
            aisatu =  "こんにちは";
        }else if ( 18<= hourOfDay && hourOfDay <=23 ){
            aisatu =  "こんばんは";
        }else if ( 0<= hourOfDay && hourOfDay <=1 ){
            aisatu =  "こんばんは";
        }
        return aisatu;
    }

}
