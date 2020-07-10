package com.app.abc.sings

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.app.abc.R
import com.app.abc.singsDetails.SingsDetails
import com.chad.library.adapter.base.BaseQuickAdapter
import kotlinx.android.synthetic.main.activity_sings.*
import kotlinx.android.synthetic.main.activity_sings_details.*


class SingsActivity : AppCompatActivity(), BaseQuickAdapter.OnItemChildClickListener {
    private var adapter = SingsAdapter().also {
        it.onItemChildClickListener = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sings)

        val sings = ArrayList<Sing>()
        sings.add(Sing(0, "bath", R.raw.v_bath, R.drawable.bath, R.raw.bath))
        sings.add(Sing(1, "black", R.raw.v_black, R.drawable.black, R.raw.black))
        sings.add(Sing(2, "boat", R.raw.v_boat, R.drawable.boat, R.raw.boat))
        sings.add(Sing(3, "book", R.raw.v_book, R.drawable.book, R.raw.book))
        sings.add(Sing(4, "butterfly", R.raw.v_butterfly, R.drawable.butterfly, R.raw.butterfly))
        sings.add(Sing(5, "candy", R.raw.v_candy, R.drawable.candy, R.raw.candy))
        sings.add(Sing(6, "car", R.raw.v_car, R.drawable.car, R.raw.car))
        sings.add(Sing(7, "cat", R.raw.v_cat, R.drawable.cat, R.raw.cat))
        sings.add(Sing(8, "deer", R.raw.v_deer, R.drawable.deer, R.raw.deer))
        sings.add(Sing(9, "dolphin", R.raw.v_dolphin, R.drawable.dolphin, R.raw.dolphin))
        sings.add(Sing(10, "donkey", R.raw.v_donkey, R.drawable.donkey, R.raw.donkey))
        sings.add(Sing(11, "fish", R.raw.v_fish, R.drawable.fish, R.raw.fish))
        sings.add(Sing(12, "horse", R.raw.v_horse, R.drawable.horse, R.raw.horse))
        sings.add(Sing(13, "ice cream", R.raw.v_ice_cream, R.drawable.ice_cream, R.raw.ice_cream))
        sings.add(Sing(14, "kangaroo", R.raw.v_kangaroo, R.drawable.kangaroo, R.raw.kangaroo))
        sings.add(Sing(15, "mouse", R.raw.v_mouse, R.drawable.mouse, R.raw.mouse))
        sings.add(Sing(16, "red", R.raw.v_red, R.drawable.red, R.raw.red))
        sings.add(Sing(17, "subway", R.raw.v_subway, R.drawable.subway, R.raw.subway))
        sings.add(Sing(18, "teacher", R.raw.v_teacher, R.drawable.teacher, R.raw.teacher))
        sings.add(Sing(19, "walk", R.raw.v_walk, R.drawable.walk, R.raw.walk))
        sings.add(Sing(20, "white", R.raw.v_white, R.drawable.white, R.raw.white))
        singsRv.adapter = adapter
        singsRv.setHasFixedSize(true)

        adapter.replaceData(sings)

        home.setOnClickListener {
            finish()
        }


    }


    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        val intent = Intent(this@SingsActivity, SingsDetails::class.java)
        intent.putExtra("index", position)
        startActivity(intent)
    }
}