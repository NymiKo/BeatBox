package com.easyprog.android.beatbox

import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.SoundPool
import android.util.Log
import com.easyprog.android.beatbox.model.Sound
import java.io.IOException

class BeatBox(private val assets: AssetManager) {

    companion object {
        private const val SOUNDS_FOLDER = "sample_sounds"
        private const val MAX_SOUNDS = 5
    }

    val sounds: List<Sound>
    private val soundPool = SoundPool.Builder().setMaxStreams(MAX_SOUNDS).build()

    init {
        sounds = loadSounds()
    }

    private fun loadSounds(): List<Sound> {
        val soundNames: Array<String>

        try {
            soundNames = assets.list(SOUNDS_FOLDER)!!
        } catch (e: Exception) {
            return emptyList()
        }

        val sounds = mutableListOf<Sound>()
        soundNames.forEach { filename ->
            val assetPath = "$SOUNDS_FOLDER/$filename"
            val sound = Sound(assetPath)

            try {
                load(sound)
                sounds.add(sound)
            } catch (ioe: IOException) {
                Log.e("ERROR", "Невозможно загрузить звук $filename", ioe)
            }
        }
        return sounds
    }

    private fun load(sound: Sound) {
        val afd: AssetFileDescriptor = assets.openFd(sound.assetPath)
        val soundId = soundPool.load(afd, 1)
        sound.soundId = soundId
    }

    fun play(sound: Sound) {
        sound.soundId?.let {
            soundPool.play(it, 1.0f, 1.0f, 1, 0, 1.0f)
        }
    }

    fun release() {
        soundPool.release()
    }
}