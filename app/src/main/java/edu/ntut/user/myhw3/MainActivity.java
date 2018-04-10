package edu.ntut.user.myhw3;

import android.content.res.Resources;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MainActivity self;

    private Spinner mSpAge;
    private RadioGroup mRadGrpSex;
    private RadioButton mRadBtnSexRange1;
    private RadioButton mRadBtnSexRange2;
    private CheckBox mMusic,mSing,mDance,mTravel,mReading,mWriting,mClimbing,mSwim,mEating,mDrawing;
    private TextView mTxtSug;
    private TextView mTxtHub;

    private Button mBtnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self = this;

        mRadGrpSex = (RadioGroup) findViewById(R.id.radGrpSex);
        mRadBtnSexRange1 = (RadioButton) findViewById(R.id.radBtnSexRange1);
        mRadBtnSexRange2 = (RadioButton) findViewById(R.id.radBtnSexRange2);
        mSpAge = (Spinner) findViewById(R.id.spnAge);

        mMusic=(CheckBox) findViewById(R.id.chkHabit_Music);
        mSing=(CheckBox) findViewById(R.id.chkHabit_Sing);
        mDance=(CheckBox) findViewById(R.id.chkHabit_Dance);
        mTravel=(CheckBox) findViewById(R.id.chkHabit_Travel);
        mReading=(CheckBox) findViewById(R.id.chkHabit_Reading);
        mWriting=(CheckBox) findViewById(R.id.chkHabit_Writing);
        mClimbing=(CheckBox) findViewById(R.id.chkHabit_Climbing);
        mSwim=(CheckBox) findViewById(R.id.chkHabit_Swim);
        mEating=(CheckBox) findViewById(R.id.chkHabit_Eating);
        mDrawing=(CheckBox) findViewById(R.id.chkHabit_Drawing);

        mBtnOK = (Button) findViewById(R.id.btnOK);
        mTxtSug = (TextView) findViewById(R.id.txtSug);
        mTxtHub = (TextView) findViewById(R.id.txtHub);

        mRadGrpSex.setOnCheckedChangeListener(spAge_OnCheckedChange);
        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private RadioGroup.OnCheckedChangeListener spAge_OnCheckedChange = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int id) {
            RadioButton target = (RadioButton) radioGroup.findViewById(id);
            Resources res = getResources();
            ArrayAdapter<String> adapter;

            if (target == mRadBtnSexRange1) {
                adapter = new ArrayAdapter<String>(self, android.R.layout.simple_list_item_1, res.getStringArray(R.array.maleAge_list));
            }
            else {
                adapter = new ArrayAdapter<String>(self, android.R.layout.simple_list_item_1, res.getStringArray(R.array.femaleAge_list));
            }

            mSpAge.setAdapter(adapter);
        }
    };


    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            MarriageSuggestion ms = new MarriageSuggestion();
            String sexStr="";
            if(mRadBtnSexRange1.isChecked()){
                sexStr="male";
            }
            else{
                sexStr="female";
            }

            if(mRadBtnSexRange1.isChecked()){
                switch(mSpAge.getSelectedItem().toString()) {
                    case "小於30歲":
                        mTxtSug.setText(ms.getSuggestion(sexStr, 1));
                        break;
                    case "30~40歲":
                        mTxtSug.setText(ms.getSuggestion(sexStr, 2));
                        break;
                    case "大於40歲":
                        mTxtSug.setText(ms.getSuggestion(sexStr, 3));
                }
            }
            else {
                switch(mSpAge.getSelectedItem().toString()) {
                    case "小於28歲":
                        mTxtSug.setText(ms.getSuggestion(sexStr, 1));
                        break;
                    case "28~35歲":
                        mTxtSug.setText(ms.getSuggestion(sexStr, 2));
                        break;
                    case "大於35歲":
                        mTxtSug.setText(ms.getSuggestion(sexStr, 3));
                }
            }

            String habitInfo = "興趣: ";
            if (mMusic.isChecked()) {
                habitInfo += mMusic.getText().toString() + " ";
            }
            if (mSing.isChecked()) {
                habitInfo += mSing.getText().toString() + " ";
            }
            if (mDance.isChecked()) {
                habitInfo += mDance.getText().toString() + " ";
            }
            if (mTravel.isChecked()) {
                habitInfo += mTravel.getText().toString() + " ";
            }
            if (mReading.isChecked()) {
                habitInfo += mReading.getText().toString() + " ";
            }
            if (mWriting.isChecked()) {
                habitInfo += mWriting.getText().toString() + " ";
            }
            if (mClimbing.isChecked()) {
                habitInfo += mClimbing.getText().toString() + " ";
            }
            if (mSwim.isChecked()) {
                habitInfo += mSwim.getText().toString() + " ";
            }
            if (mEating.isChecked()) {
                habitInfo += mEating.getText().toString() + " ";
            }
            if (mDrawing.isChecked()) {
                habitInfo += mDrawing.getText().toString() + " ";
            }


            mTxtHub.setText(habitInfo);
        }
    };
}
