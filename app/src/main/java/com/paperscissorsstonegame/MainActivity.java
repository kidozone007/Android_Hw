package com.paperscissorsstonegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtComPlay, mTxtResult;
    private Button mBtnScissors, mBtnStone, mBtnPaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtComPlay = (TextView)findViewById(R.id.txtComPlay);
        mTxtResult = (TextView)findViewById(R.id.txtResult);
        mBtnScissors = (Button)findViewById(R.id.btnScissors);
        mBtnStone = (Button)findViewById(R.id.btnStone);
        mBtnPaper = (Button)findViewById(R.id.btnPaper);

        mBtnScissors.setOnClickListener(btnScissorsOnClick);
        mBtnStone.setOnClickListener(btnStoneOnClick);
        mBtnPaper.setOnClickListener(btnPaperOnClick);
    }

    private View.OnClickListener btnPaperOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            GameSystem game = new GameSystem();
            game.playGame(3);

            String strComputerChoice[] = {getString(R.string.use_scissors), getString(R.string.use_stone), getString(R.string.use_paper)};
            mTxtComPlay.setText(strComputerChoice[game.getComputerChoice() - 1]);

            String strResults[] = {getString(R.string.user_lose), getString(R.string.user_win), getString(R.string.user_draw)};
            mTxtResult.setText(getString(R.string.text_result) + strResults[game.getResult()]);
        }
    };

    private View.OnClickListener btnStoneOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            GameSystem game = new GameSystem();
            game.playGame(2);

            String strComputerChoice[] = {getString(R.string.use_scissors), getString(R.string.use_stone), getString(R.string.use_paper)};
            mTxtComPlay.setText(strComputerChoice[game.getComputerChoice() - 1]);

            String strResults[] = {getString(R.string.user_lose), getString(R.string.user_win), getString(R.string.user_draw)};
            mTxtResult.setText(getString(R.string.text_result) + strResults[game.getResult()]);
        }
    };

    private View.OnClickListener btnScissorsOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            GameSystem game = new GameSystem();
            game.playGame(1);

            String strComputerChoice[] = {getString(R.string.use_scissors), getString(R.string.use_stone), getString(R.string.use_paper)};
            mTxtComPlay.setText(strComputerChoice[game.getComputerChoice() - 1]);

            String strResults[] = {getString(R.string.user_lose), getString(R.string.user_win), getString(R.string.user_draw)};
            mTxtResult.setText(getString(R.string.text_result) + strResults[game.getResult()]);
        }
    };
}
