package com.app.abc.letters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.app.abc.R
import com.bumptech.glide.Glide

class LettersSliderAdapter() : PagerAdapter() {

    private val letters = ArrayList<Letter>()

    override fun isViewFromObject(view: View, item: Any): Boolean {
        return view == item as ConstraintLayout
    }

    override fun getCount(): Int {
        return letters.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context)
            .inflate(R.layout.letter_item, container, false) as ConstraintLayout

        val image = view.findViewById<ImageView>(R.id.image)
        val letter = view.findViewById<TextView>(R.id.letter)

        container.addView(view)

        Glide.with(container.context)
            .load(letters[position].handShape)
            .into(image)

        letter.text = letters[position].letter

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    fun submitList(imagesList: List<Letter>) {
        letters.clear()
        letters.addAll(imagesList)
        notifyDataSetChanged()
    }

}