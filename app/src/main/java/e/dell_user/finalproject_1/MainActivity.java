package e.dell_user.finalproject_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mBtnShowResult;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //取得此Button的實體
        mBtnShowResult = (Button)findViewById(R.id.btn_score);

        //實做OnClickListener界面
        mBtnShowResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //初始化Intent物件
                Intent intent = new Intent(getBaseContext(),RunResultActivity.class);
                //從MainActivity 到Main2Activity
                //intent.setClass(MainActivity.this , ResultActivity.class);
                //開啟Activity
                startActivity(intent);
            }
        });
    }

}
