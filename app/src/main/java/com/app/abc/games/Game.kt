package com.app.abc.games

import com.app.abc.sings.Sing

data class Game(
    val id: Int,
    var video: Int,
    var answer1: Sing,
    var answer2: Sing,
    var answer3: Sing,
    var correct: Int
)