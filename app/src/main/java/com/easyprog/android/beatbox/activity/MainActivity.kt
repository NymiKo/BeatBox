package com.easyprog.android.beatbox.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.easyprog.android.beatbox.BeatBox
import com.easyprog.android.beatbox.R
import com.easyprog.android.beatbox.adapter.SoundAdapter
import com.easyprog.android.beatbox.databinding.ActivityMainBinding
import com.easyprog.android.beatbox.utils.SimpleOnSeekBarChangeListener
import com.easyprog.android.beatbox.viewmodel.BeatBoxViewModel
import com.easyprog.android.beatbox.viewmodel.BeatBoxViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var beatBoxViewModel: BeatBoxViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factoryViewModel = BeatBoxViewModelFactory(assets)
        beatBoxViewModel = ViewModelProvider(this, factoryViewModel)[BeatBoxViewModel::class.java]

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = SoundAdapter(beatBoxViewModel.beatBox)
        }

        binding.textSoundSpeed.text = getString(R.string.speed_sound, "0")

        binding.seekbarSoundSpeed.setOnSeekBarChangeListener(SimpleOnSeekBarChangeListener { progress ->
            binding.textSoundSpeed.text = getString(R.string.speed_sound, progress.toString())
            beatBoxViewModel.beatBox.speedSound = progress.toFloat() / 100
        })
    }
}