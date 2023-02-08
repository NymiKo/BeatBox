package com.easyprog.android.beatbox.viewmodel

import com.easyprog.android.beatbox.model.Sound

class SoundViewModel {
    var sound: Sound? = null
        set(sound) {
            field = sound
        }

    val title: String? get() = sound?.name
}