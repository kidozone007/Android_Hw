package edu.ntut.user.myhw3;


import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Admin on 2018/3/25.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTest() {
        super(MainActivity.class);
    }
    private MainActivity mMainActivity;
    private Spinner mSpnSex;
    private RadioGroup mRadGrp;
    private RadioButton mRadBtnAgeRange1;
    private RadioButton mRadBtnAgeRange2;
    private RadioButton mRadBtnAgeRange3;
    private TextView mTxtNumFamily;
    private NumberPicker mNumPkrFamily;
    private Button mBtnOk;
    private TextView mTxtSug;
    private String selectedSex;

    @Before
    public void setUp() throws Exception{
        super.setUp();
        //完成初始化設定
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mMainActivity = (MainActivity) getActivity();
        mSpnSex = (Spinner) mMainActivity.findViewById(R.id.spnSex);
        mRadBtnAgeRange1 = (RadioButton) mMainActivity.findViewById(R.id.radBtnAgeRange1);
        mRadBtnAgeRange2 = (RadioButton) mMainActivity.findViewById(R.id.radBtnAgeRange2);
        mRadBtnAgeRange3 = (RadioButton) mMainActivity.findViewById(R.id.radBtnAgeRange3);
        mNumPkrFamily = (NumberPicker) mMainActivity.findViewById(R.id.numPkrFamply);
        mBtnOk = (Button) mMainActivity.findViewById(R.id.btnOK);
        mTxtSug = (TextView) mMainActivity.findViewById(R.id.txtSug);

        mRadBtnAgeRange1.setChecked(true);
        mNumPkrFamily.setValue(0);
    }
    @Test
    public void maleAge29(){
        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mSpnSex.setSelection(0);
                mRadBtnAgeRange1.setChecked(true);
                mRadBtnAgeRange2.setChecked(false);
                mRadBtnAgeRange3.setChecked(false);
                mNumPkrFamily.setValue(12);
                mBtnOk.performClick();
            }
        });
        try{
            Thread.sleep(5000);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        assertEquals(mMainActivity.getString(R.string.sug_not_hurry),mTxtSug.getText().toString());
    }
    @Test
    public void maleAge31(){
        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mSpnSex.setSelection(0);//選性別
                mRadBtnAgeRange1.setChecked(false);
                mRadBtnAgeRange2.setChecked(true);
                mRadBtnAgeRange3.setChecked(false);
                mNumPkrFamily.setValue(5);
                mBtnOk.performClick();
            }
        });
        try{
            Thread.sleep(5000);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        assertEquals(mMainActivity.getString(R.string.sug_find_couple),mTxtSug.getText().toString());
    }
    @Test
    public void maleAge41(){
        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mSpnSex.setSelection(0);//選性別
                mRadBtnAgeRange1.setChecked(false);
                mRadBtnAgeRange2.setChecked(false);
                mRadBtnAgeRange3.setChecked(true);
                mNumPkrFamily.setValue(3);
                mBtnOk.performClick();
            }
        });
        try{
            Thread.sleep(5000);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        assertEquals(mMainActivity.getString(R.string.sug_find_couple),mTxtSug.getText().toString());
    }
    @Test
    public void femaleAge29(){
        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mSpnSex.setSelection(1);
                mRadBtnAgeRange1.setChecked(true);
                mRadBtnAgeRange2.setChecked(false);
                mRadBtnAgeRange3.setChecked(false);
                mNumPkrFamily.setValue(3);
                mBtnOk.performClick();
            }
        });
        try{
            Thread.sleep(5000);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        assertEquals(mMainActivity.getString(R.string.sug_get_married),mTxtSug.getText().toString());
    }
    @Test
    public void femaleAge31(){
        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mSpnSex.setSelection(1);//選性別
                mRadBtnAgeRange1.setChecked(false);
                mRadBtnAgeRange2.setChecked(true);
                mRadBtnAgeRange3.setChecked(false);
                mNumPkrFamily.setValue(5);
                mBtnOk.performClick();
            }
        });
        try{
            Thread.sleep(5000);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        assertEquals(mMainActivity.getString(R.string.sug_find_couple),mTxtSug.getText().toString());
    }
    @Test
    public void femaleAge41(){
        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mSpnSex.setSelection(1);//選性別
                mRadBtnAgeRange1.setChecked(false);
                mRadBtnAgeRange2.setChecked(false);
                mRadBtnAgeRange3.setChecked(true);
                mNumPkrFamily.setValue(8);
                mBtnOk.performClick();
            }
        });
        try{
            Thread.sleep(5000);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        assertEquals(mMainActivity.getString(R.string.sug_get_married),mTxtSug.getText().toString());
    }

    @After
    public void tearDown() throws Exception{
        super.tearDown();
    }
}