package e.dell_user.finalproject_1;


import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    private ImageView mImgLot;
/*
    public EditText mEdtCountSet,
                    mEdtCountPlayerWin,
                    mEdtCountComWin,
                    mEdtCountDraw;
*/

    private Integer[] lotStatus = {
            R.drawable.lot01, R.drawable.lot02,
            R.drawable.lot03, R.drawable.lot04,
            R.drawable.lot05, R.drawable.lot06,
            R.drawable.lot07, R.drawable.lot08,
            R.drawable.lot09, R.drawable.lot10,
            R.drawable.lot11, R.drawable.lot12,
            R.drawable.lot13, R.drawable.lot14,
            R.drawable.lot15, R.drawable.lot16,
            R.drawable.lot17, R.drawable.lot18,
            R.drawable.lot19, R.drawable.lot20
    };

    // 新增統計遊戲局數和輸贏的變數
    private int miCountSet = 0,
            miCountPlayerWin = 0,
            miCountComWin = 0,
            miCountDraw = 0;

    private Button mBtnDrawLot;
    private Button mBtnShowResult;


//    private final static String TAG = "Result";
//    private int mTagCount = 0;

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mImgLot = (ImageView)findViewById(R.id.iv_lot);
        mBtnDrawLot = (Button)findViewById(R.id.btn_score);
        mBtnShowResult = (Button)findViewById(R.id.btn_score);

        mBtnDrawLot.setOnClickListener(btnDrawLotOnClick);
        mBtnShowResult.setOnClickListener(btnBack_OnClick);
    }

    private void throwDice() {
        // 全部局數 +1
        miCountSet++;

        // 骰子擲出來的點數
        int score = (int)(Math.random() * 20 + 1);

        // 顯示擲出來的圖
        mImgLot.setImageDrawable(getResources().getDrawable(lotStatus[score - 1]));

    }

    private View.OnClickListener btnDrawLotOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            // 取得動畫
            final AnimationDrawable animation = (AnimationDrawable) getResources().getDrawable(R.drawable.anim_draw_lot);
            // 設定顯示動畫
            mImgLot.setImageDrawable(animation);
            // 動畫開始
            animation.start();
            // 宣告 Handler
            Handler handler = new Handler();
            // 一秒鐘後停止動畫且擲出點數
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    animation.stop();
                    throwDice();
                }
            }, 1000);
        }
    };

    View.OnClickListener btnBack_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };

}

