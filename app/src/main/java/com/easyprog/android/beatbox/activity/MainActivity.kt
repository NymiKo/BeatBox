package com.easyprog.android.beatbox.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.easyprog.android.beatbox.BeatBox
import com.easyprog.android.beatbox.R
import com.easyprog.android.beatbox.adapter.SoundAdapter
import com.easyprog.android.beatbox.databinding.ActivityMainBinding
import com.easyprog.android.beatbox.utils.SimpleOnSeekBarChangeListener

class MainActivity : AppCompatActivity() {

    private lateinit var beatBox: BeatBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        beatBox = BeatBox(assets)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = SoundAdapter(beatBox)
        }

        binding.textSoundSpeed.text = getString(R.string.speed_sound, "0")

        binding.seekbarSoundSpeed.setOnSeekBarChangeListener(SimpleOnSeekBarChangeListener{ progress ->
            binding.textSoundSpeed.text = getString(R.string.speed_sound, progress.toString())
            beatBox.speedSound = progress.toFloat() / 100
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        beatBox.release()
    }
}