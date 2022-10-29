package org.wit.charitymark.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.wit.charitymark.databinding.CardCharitymarkBinding
import org.wit.charitymark.models.CharitymarkModel

interface CharitymarkListener {
    fun onCharitymarkClick(charitymark: CharitymarkModel)
}

class CharitymarkAdapter constructor(private var charitymarks: List<CharitymarkModel>,
                                   private val listener: CharitymarkListener) :
    RecyclerView.Adapter<CharitymarkAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardCharitymarkBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val charitymark = charitymarks[holder.adapterPosition]
        holder.bind(charitymark, listener)
    }

    override fun getItemCount(): Int = charitymarks.size

    class MainHolder(private val binding: CardCharitymarkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(charitymark: CharitymarkModel, listener: CharitymarkListener) {
            binding.charitymarkTitle.text = charitymark.title
            binding.description.text = charitymark.description
            binding.charitymarkEventdate.text = charitymark.eventdate
            binding.charitymarkEventcounty.text = charitymark.eventcounty

            // initialise imageView from model using Picasso
            Picasso.get().load(charitymark.image).resize(200,200).into(binding.imageIcon)
            binding.root.setOnClickListener { listener.onCharitymarkClick(charitymark) }
        }
    }
}