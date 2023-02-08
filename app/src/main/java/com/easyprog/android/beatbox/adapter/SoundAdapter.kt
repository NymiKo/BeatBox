package com.easyprog.android.beatbox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.easyprog.android.beatbox.R
import com.easyprog.android.beatbox.databinding.ListItemSoundBinding

class SoundAdapter : RecyclerView.Adapter<SoundAdapter.SoundHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
        val binding = ListItemSoundBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SoundHolder(binding)
    }

    override fun onBindViewHolder(holder: SoundHolder, position: Int) {

    }

    override fun getItemCount(): Int = 0

    inner class SoundHolder(private val binding: ListItemSoundBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}