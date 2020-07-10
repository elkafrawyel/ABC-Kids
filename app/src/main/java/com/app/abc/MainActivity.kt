package com.app.abc

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.app.abc.games.GamesActivity
import com.app.abc.letters.LettersActivity
import com.app.abc.sings.SingsActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.translate)
        sings.startAnimation(animation)
        play.startAnimation(animation)
        letters.startAnimation(animation)

        sings.setOnClickListener {
            openSings()
        }

        play.setOnClickListener {
            openGames()
        }

        letters.setOnClickListener {
            openLetters()
        }
    }

    private fun openSings() {
        startActivity(Intent(this, SingsActivity::class.java))
    }

    private fun openGames() {
        startActivity(Intent(this, GamesActivity::class.java))
    }

    private fun openLetters() {
        startActivity(Intent(this, LettersActivity::class.java))
    }
}