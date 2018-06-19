package tw.com.ntut.ntut_android_hw;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLinearLayout;

    private TextView mTxtCost;
    private TextView mTxtDate;

    private DatePicker mDpkDate;
    private Spinner mSpnCategory;

    private Button mBtnAdd;
    private Button mBtnSee;

    private ArrayList<String> dataList;
    private int dataCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        mTxtCost = (TextView) findViewById(R.id.txtCost);
        mTxtDate = (TextView) findViewById(R.id.txtDate);

        mDpkDate = (DatePicker) findViewById(R.id.dpkDate);
        mSpnCategory = (Spinner) findViewById(R.id.spnCategory);

        mBtnAdd = (Button) findViewById(R.id.btnAdd);
        mBtnSee = (Button) findViewById(R.id.btnSee);

        registerForContextMenu(mLinearLayout);

        mDpkDate.setOnDateChangedListener(dpkDateOnDataChangedListener);

        mBtnAdd.setOnClickListener(btnAddOnClickListener);
        mBtnSee.setOnClickListener(btnSeeOnClickListener);

        dataList = new ArrayList<>();
        dataCount = 0;
    }

    private DatePicker.OnDateChangedListener dpkDateOnDataChangedListener = new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String result = String.valueOf(year) + "/"  + String.valueOf(monthOfYear + 1) + "/" + String.valueOf(dayOfMonth);
            mTxtDate.setText(result);
        }
    };

    private View.OnClickListener btnAddOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mTxtDate.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "請輸入日期", Toast.LENGTH_SHORT).show();
                return;
            }
            if (mTxtCost.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "請輸入金額", Toast.LENGTH_SHORT).show();
                return;
            }
            String count = "項目 " + String.valueOf(dataCount++);
            String date = mTxtDate.getText().toString();
            String category = mSpnCategory.getSelectedItem().toString();
            String cost = mTxtCost.getText().toString();
            Toast.makeText(MainActivity.this, cost, Toast.LENGTH_SHORT).show();
            dataList.add(count + "            " + date + "            " + category + "            " + cost);
        }
    };

    private View.OnClickListener btnSeeOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, RecordActivity.class);
            intent.putExtra("dataList", dataList);
            startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menu_background_music_start:
                intent = new Intent(MainActivity.this, MediaPlayService.class);
                startService(intent);
                break;
            case R.id.menu_background_music_stop:
                intent = new Intent(MainActivity.this, MediaPlayService.class);
                stopService(intent);
                break;
            case R.id.menu_background_about:
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("關於這個程式")
                        .setMessage("選單範例程式")
                        .setCancelable(false)
                        .setIcon(android.R.drawable.star_big_on)
                        .setPositiveButton("確定",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {}
                                }).show();
                break;
            case R.id.menu_background_exit:
                finish();
                break;

        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        onOptionsItemSelected(item);
        return true;
    }
}
