package com.app.abc.games

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import com.app.abc.R
import com.app.abc.RunAfterTime
import com.app.abc.sings.Sing
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_games.*
import kotlinx.android.synthetic.main.activity_games.simpleVideoView
import kotlinx.android.synthetic.main.activity_games.videoParent
import kotlinx.android.synthetic.main.activity_sings.home

class GamesActivity : AppCompatActivity() {
    private val games = ArrayList<Game>()
    private var gamePosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        home.setOnClickListener {
            finish()
        }

        fillData()

        setGame(position = gamePosition)

        play.setOnClickListener {
            playVideo(games[gamePosition].video)
        }

        answer1.setOnClickListener { checkAnswer(answerIndex = 1) }
        answer2.setOnClickListener { checkAnswer(answerIndex = 2) }
        answer3.setOnClickListener { checkAnswer(answerIndex = 3) }
    }

    private fun setGame(position: Int) {
        Glide.with(applicationContext).load(games[position].answer1.image).into(image1)
        name1.text = games[position].answer1.name
        Glide.with(applicationContext).load(games[position].answer2.image).into(image2)
        name2.text = games[position].answer2.name
        Glide.with(applicationContext).load(games[position].answer3.image).into(image3)
        name3.text = games[position].answer3.name

        counter.text = "${position + 1}/${games.size}"

        answer1.isSelected = false
        answer2.isSelected = false
        answer3.isSelected = false
    }


    private fun checkAnswer(answerIndex: Int) {
        if (answerIndex == games[gamePosition].correct) {
            //correct answer
            correct.visibility = View.VISIBLE
            wrong.visibility = View.GONE

            RunAfterTime.after(
                3000
            ) {
                correct.visibility = View.GONE
                wrong.visibility = View.GONE

                if (gamePosition == games.size - 1) {
                    //End Of Game
                    MaterialAlertDialogBuilder(this)
                        .setMessage("Test is done.")
                        .setPositiveButton(getString(R.string.play)) { dialog, which ->
                            finish()
                        }.show()
                } else {
                    gamePosition++
                    setGame(gamePosition)
                }
            }

        } else {
            //wrong answer
            wrong.visibility = View.VISIBLE
            correct.visibility = View.GONE

            when (games[gamePosition].correct) {
                1 -> answer1.isSelected = true
                2 -> answer2.isSelected = true
                3 -> answer3.isSelected = true
            }

            RunAfterTime.after(
                3000
            ) {
                correct.visibility = View.GONE
                wrong.visibility = View.GONE

                if (gamePosition == games.size - 1) {
                    //End Of Game
                    MaterialAlertDialogBuilder(this)
                        .setMessage("Test is done.")
                        .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                            finish()
                        }.show()
                } else {
                    gamePosition++
                    setGame(gamePosition)
                }
            }
        }
    }

    private fun fillData() {
        games.add(
            Game(
                0,
                //use fish video
                R.raw.fish,
                Sing(0, "bath", R.raw.v_bath, R.drawable.bath, R.raw.bath),
                Sing(1, "fish", R.raw.v_fish, R.drawable.fish, R.raw.fish),
                Sing(2, "mouse", R.raw.v_mouse, R.drawable.mouse, R.raw.mouse),
                2
            )
        )

        games.add(
            Game(
                1,
                //use cat video
                R.raw.cat,
                Sing(0, "cat", R.raw.v_cat, R.drawable.cat, R.raw.cat),
                Sing(1, "car", R.raw.v_car, R.drawable.car, R.raw.car),
                Sing(2, "deer", R.raw.v_deer, R.drawable.deer, R.raw.deer),
                1
            )
        )

        games.add(
            Game(
                2,
                //use book video
                R.raw.book,
                Sing(0, "boat", R.raw.v_boat, R.drawable.boat, R.raw.boat),
                Sing(1, "book", R.raw.v_book, R.drawable.book, R.raw.book),
                Sing(2, "butterfly", R.raw.v_butterfly, R.drawable.butterfly, R.raw.butterfly),
                2
            )
        )

        games.add(
            Game(
                3,
                //use horse video
                R.raw.horse,
                Sing(0, "horse", R.raw.v_horse, R.drawable.horse, R.raw.horse),
                Sing(1, "donkey", R.raw.v_donkey, R.drawable.donkey, R.raw.donkey),
                Sing(2, "red", R.raw.v_red, R.drawable.red, R.raw.red),
                1
            )
        )

        games.add(
            Game(
                4,
                //use walk video
                R.raw.walk,
                Sing(0, "teacher", R.raw.v_teacher, R.drawable.teacher, R.raw.teacher),
                Sing(1, "walk", R.raw.v_walk, R.drawable.walk, R.raw.walk),
                Sing(2, "subway", R.raw.v_subway, R.drawable.subway, R.raw.subway),
                2
            )
        )
    }

    private fun playVideo(video: Int) {

        videoParent.visibility = View.VISIBLE

        val mediaController =
            MediaController(this) // create an object of media controller

        mediaController.setAnchorView(simpleVideoView) // set anchor view for video view
        mediaController.hide()

        simpleVideoView.setVideoURI(
            Uri.parse("android.resource://$packageName/$video")
        )

        simpleVideoView.start()

        simpleVideoView.setOnCompletionListener {
            videoParent.visibility = View.GONE
        }

    }

    override fun onBackPressed() {
        if (videoParent.visibility == View.VISIBLE) {
            videoParent.visibility = View.GONE
            simpleVideoView.stopPlayback()
        } else
            super.onBackPressed()
    }
}