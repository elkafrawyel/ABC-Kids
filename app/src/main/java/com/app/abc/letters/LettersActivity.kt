package com.app.abc.letters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.abc.R
import kotlinx.android.synthetic.main.activity_letters.*
import kotlinx.android.synthetic.main.activity_letters.home

class LettersActivity : AppCompatActivity() {

    private val imageSliderAdapter = LettersSliderAdapter()
    private val letters = ArrayList<Letter>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letters)

        fillLetters()

        slider.adapter = imageSliderAdapter
        imageSliderAdapter.submitList(letters)

        home.setOnClickListener {
            finish()
        }
    }

    private fun fillLetters() {
        letters.add(Letter(R.drawable.a, "Aa"))
        letters.add(Letter(R.drawable.b, "Bb"))
        letters.add(Letter(R.drawable.c, "Cc"))
        letters.add(Letter(R.drawable.d, "Dd"))
        letters.add(Letter(R.drawable.e, "Ee"))
        letters.add(Letter(R.drawable.f, "Ff"))
        letters.add(Letter(R.drawable.g, "Gg"))
        letters.add(Letter(R.drawable.h, "Hh"))
        letters.add(Letter(R.drawable.i, "Ii"))
        letters.add(Letter(R.drawable.j, "Jj"))
        letters.add(Letter(R.drawable.k, "Kk"))
        letters.add(Letter(R.drawable.l, "Ll"))
        letters.add(Letter(R.drawable.m, "Mm"))
        letters.add(Letter(R.drawable.n, "Nn"))
        letters.add(Letter(R.drawable.o, "Oo"))
        letters.add(Letter(R.drawable.p, "Pp"))
        letters.add(Letter(R.drawable.q, "Qq"))
        letters.add(Letter(R.drawable.r, "Rr"))
        letters.add(Letter(R.drawable.s, "Ss"))
        letters.add(Letter(R.drawable.t, "Tt"))
        letters.add(Letter(R.drawable.u, "Uu"))
        letters.add(Letter(R.drawable.v, "Vv"))
        letters.add(Letter(R.drawable.w, "Ww"))
        letters.add(Letter(R.drawable.x, "Xx"))
        letters.add(Letter(R.drawable.y, "Yy"))
        letters.add(Letter(R.drawable.z, "Zz"))
    }
}