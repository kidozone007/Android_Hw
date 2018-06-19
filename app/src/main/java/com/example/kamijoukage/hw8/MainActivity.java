package com.example.kamijoukage.hw8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText mTxtCost,mTxtDate;
    private DatePicker mdtp_date;
    private Spinner mSpnCategory;
    private Button mBtnAdd,mBtnSee;
    private ArrayList<String> userDate = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpnCategory = (Spinner) findViewById(R.id.spn_meal);
        mTxtCost = (EditText) findViewById(R.id.edt_date);
        mTxtDate = (EditText) findViewById(R.id.edt_purchased);
        mdtp_date = (DatePicker) findViewById(R.id.dtp_date);
        mBtnAdd = (Button) findViewById(R.id.btn_input);
        mBtnSee = (Button) findViewById(R.id.btn_log);

        mdtp_date.setOnDateChangedListener(dtpDateOnDateChanged);
        mBtnAdd.setOnClickListener(btnInputOnClick);
        mBtnSee.setOnClickListener(btnLogOnClick);

        mTxtCost.setEnabled(false);
    }

    private DatePicker.OnDateChangedListener dtpDateOnDateChanged = new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
            year+=1;
            mTxtCost.setText(year+"/"+month+"/"+day);
        }
    };

    private View.OnClickListener btnInputOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String strDate=Integer.toString(mdtp_date.getYear())+"/"+Integer.toString(mdtp_date.getMonth()+1)+"/"+Integer.toString(mdtp_date.getDayOfMonth());
            String strMeal=mSpnCategory.getSelectedItem().toString();
            String strPurchased=mTxtDate.getText().toString();
            String inputData=strDate+" "+strMeal+" "+strPurchased;
            userDate.add(inputData);
            Toast.makeText(MainActivity.this,strPurchased,Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener btnLogOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,LogActivity.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("userData",userDate);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };
}
