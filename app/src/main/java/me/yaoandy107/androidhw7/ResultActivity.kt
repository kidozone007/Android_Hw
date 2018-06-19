package me.yaoandy107.androidhw7

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        et_count.setText(intent.getStringExtra("count"))
        et_win.setText(intent.getStringExtra("win"))
        et_draw.setText(intent.getStringExtra("draw"))
        et_lose.setText(intent.getStringExtra("lose"))
        btn_back.setOnClickListener {
            onBackPressed()
        }
    }
}