package com.test.ny.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.ny.databinding.AdapterSectionBinding
import com.test.ny.model.Section


class SectionAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var sectionList = mutableListOf<Section>()
    lateinit var context:Context

    fun setSection(context: Context,list: List<Section>) {
        this.context = context
        this.sectionList = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterSectionBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val section = sectionList[position]
        holder.binding.title.text = "Title: "+ section.title
        holder.binding.type.text = "Section: "+ section.section

        var url = section.media.get(0).`media-metadata`.get(0).url
        Glide.with(holder.itemView.context).load(url).into(holder.binding.imageview)

        holder.itemView.setOnClickListener(View.OnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(section.url)
            context.startActivity(i)
        })
    }

    override fun getItemCount(): Int {
        return sectionList.size
    }
}

class MainViewHolder(val binding: AdapterSectionBinding) : RecyclerView.ViewHolder(binding.root) {

}