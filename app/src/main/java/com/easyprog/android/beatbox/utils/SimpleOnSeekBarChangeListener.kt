package com.easyprog.android.beatbox.utils

import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener

class SimpleOnSeekBarChangeListener(val block: (progress: Int) -> Unit): OnSeekBarChangeListener {

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        block(progress)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}