package com.easyprog.android.beatbox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easyprog.android.beatbox.databinding.ListItemSoundBinding
import com.easyprog.android.beatbox.model.Sound
import com.easyprog.android.beatbox.viewmodel.SoundViewModel

class SoundAdapter(private val sounds: List<Sound>) : RecyclerView.Adapter<SoundAdapter.SoundHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
        val binding =
            ListItemSoundBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SoundHolder(binding)
    }

    override fun onBindViewHolder(holder: SoundHolder, position: Int) {
        val sound = sounds[position]
        holder.bind(sound)
    }

    override fun getItemCount(): Int = sounds.size

    inner class SoundHolder(private val binding: ListItemSoundBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.viewModel = SoundViewModel()
        }

        fun bind(sound: Sound) {
            binding.apply {
                viewModel?.sound = sound
                executePendingBindings()
            }
        }
    }
}