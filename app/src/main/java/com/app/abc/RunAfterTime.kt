package com.app.abc

import android.os.Handler

class RunAfterTime {
    companion object {
        fun after(delay: Long, process: () -> Unit) {
            Handler().postDelayed({
                process()
            }, delay)
        }
    }
}