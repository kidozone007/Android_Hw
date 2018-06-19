package me.yaoandy107.androidhw7

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var userWin: Int = 0
    private var userDraw: Int = 0
    private var userLose: Int = 0
    private var count:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_draw.setOnClickListener {
            drawDice()
        }
        btn_score.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            val bundle = Bundle()
            bundle.putString("count", count.toString())
            bundle.putString("win", userWin.toString())
            bundle.putString("draw", userDraw.toString())
            bundle.putString("lose", userLose.toString())
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    private fun drawDice() {
        val animationDrawable = iv_dice.drawable as AnimationDrawable
        animationDrawable.start()
        Handler().postDelayed({
            count++
            val random = (Math.random() * 6 + 1).toInt()
            when (random) {
                1, 2 -> {
                    userWin++
                    Toast.makeText(baseContext, "玩家贏", Toast.LENGTH_SHORT).show()
                }
                3, 4 -> {
                    userDraw++
                    Toast.makeText(baseContext, "平手", Toast.LENGTH_SHORT).show()
                }
                5, 6 -> {
                    userLose++
                    Toast.makeText(baseContext, "電腦贏", Toast.LENGTH_SHORT).show()
                }
            }
            animationDrawable.stop()
            animationDrawable.selectDrawable(random - 1)
        }, 1000)
    }
}
