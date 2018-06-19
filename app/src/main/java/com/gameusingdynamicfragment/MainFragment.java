package com.gameusingdynamicfragment;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainFragment extends Fragment {

    public enum GameResultType {
        TYPE_A, TYPE_B, HIDE
    }

    public interface CallbackInterface {
        public void updateGameResult(int iCountSet,int iCountPlayerWin,int iCountComWin,int iCountDraw);
        public void enableGameResult(GameResultType type);
    };

    private static CallbackInterface mCallback;

    private ImageButton mImgBtnDice;
    private TextView mTxtResult;
    private static int miCountSet = 0,miCountPlayerWin = 0,miCountComWin = 0,miCountDraw = 0;

    private Button mBtnShowResult1,mBtnShowResult2,mBtnHiddenResult;

    private boolean mbShowResult = false;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (CallbackInterface) activity;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() +"must implement GameFragment.CallbackInterface.");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTxtResult = (TextView) getView().findViewById(R.id.txtResult);
        mImgBtnDice = (ImageButton) getView().findViewById(R.id.imgBtnDice);

        mImgBtnDice.setOnClickListener(imgBtnDiceOnClick);


        mBtnShowResult1 = (Button) getView().findViewById(R.id.btnShowResult1);
        mBtnShowResult2 = (Button) getView().findViewById(R.id.btnShowResult2);
        mBtnHiddenResult = (Button) getView().findViewById(R.id.btnHiddenResult);

        mBtnShowResult1.setOnClickListener(btnShowResult1OnClick);
        mBtnShowResult2.setOnClickListener(btnShowResult2OnClick);
        mBtnHiddenResult.setOnClickListener(btnHiddenResultOnClick);
    }

    private View.OnClickListener imgBtnDiceOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            final AnimationDrawable animationDrawable = (AnimationDrawable) mImgBtnDice.getDrawable();
            animationDrawable.start();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    animationDrawable.stop();
                    resultDice();
                }
            }, 1000);
        }
    };

    private View.OnClickListener btnShowResult1OnClick = new View.OnClickListener() {
        public void onClick(View v) {
            mCallback.enableGameResult(GameResultType.TYPE_A);
        }
    };

    private View.OnClickListener btnShowResult2OnClick = new View.OnClickListener() {
        public void onClick(View v) {
            mCallback.enableGameResult(GameResultType.TYPE_B);
        }
    };

    private void resultDice() {
        int iComPlay = (int)(Math.random()*5 + 1);
        miCountSet++;

        if (iComPlay > 4) {
            mTxtResult.setText(getString(R.string.result) +getString(R.string.user_draw));
            miCountComWin++;
        }
        else if (iComPlay >= 3) {
            mTxtResult.setText(getString(R.string.result) +getString(R.string.user_lose));
            miCountDraw++;
        }
        else {
            mTxtResult.setText(getString(R.string.result) +getString(R.string.user_win));
            miCountPlayerWin++;
        }
        updateResult();
    }

    private View.OnClickListener btnHiddenResultOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            mCallback.enableGameResult(GameResultType.HIDE);
        }
    };

    public static void updateResult() {
        mCallback.updateGameResult(miCountSet, miCountPlayerWin,miCountComWin, miCountDraw);
    }
}
