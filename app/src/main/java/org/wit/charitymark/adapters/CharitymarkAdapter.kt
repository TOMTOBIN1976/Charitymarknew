package org.wit.charitymark.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.wit.charitymark.databinding.CardCharitymarkBinding
import org.wit.charitymark.models.CharitymarkModel

class CharitymarkAdapter constructor(private var charitymarks: List<CharitymarkModel>) :
    RecyclerView.Adapter<CharitymarkAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardCharitymarkBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val charitymark = charitymarks[holder.adapterPosition]
        holder.bind(charitymark)
    }

    override fun getItemCount(): Int = charitymarks.size

    class MainHolder(private val binding : CardCharitymarkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(charitymark: CharitymarkModel) {
            binding.charitymarkTitle.text = charitymark.title
            binding.description.text = charitymark.description
        }
    }
}