package com.easyprog.android.beatbox.viewmodel

import android.content.res.AssetManager
import androidx.lifecycle.ViewModel
import com.easyprog.android.beatbox.BeatBox

class BeatBoxViewModel(asset: AssetManager): ViewModel() {

    val beatBox = BeatBox(asset)

    override fun onCleared() {
        super.onCleared()
        beatBox.release()
    }
}