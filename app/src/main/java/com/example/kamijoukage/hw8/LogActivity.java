package com.example.kamijoukage.hw8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LogActivity extends AppCompatActivity {

    private ListView mLtvRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        mLtvRecord = (ListView) findViewById(R.id.lst_log);

        Bundle bundle = this.getIntent().getExtras();
        ArrayList<String> userData = bundle.getStringArrayList("userData");

        for (int i=0;i<userData.size();i++)
        {
            userData.set(i,"@string/str_item"+i+" "+userData.get(i));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,userData);
        mLtvRecord.setAdapter(adapter);
    }
}
