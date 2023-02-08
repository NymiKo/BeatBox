package com.easyprog.android.beatbox.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.easyprog.android.beatbox.BeatBox
import com.easyprog.android.beatbox.model.Sound

class SoundViewModel(private val beatBox: BeatBox) : BaseObservable() {

    fun onButtonClicked() {
        sound?.let {
            beatBox.play(it)
        }
    }

    var sound: Sound? = null
        set(sound) {
            field = sound
            notifyChange()
        }

    @get:Bindable
    val title: String?
        get() = sound?.name
}