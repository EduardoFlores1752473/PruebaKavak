package com.example.pruebakavak.presentacion.kickoff.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pruebakavak.R
import com.example.pruebakavak.data.network.models.Book
import com.example.pruebakavak.data.network.models.Results
import com.example.pruebakavak.data.network.models.TypesOfBooks
import com.example.pruebakavak.presentacion.core.callback.OnItemClickListener
import com.example.pruebakavak.presentacion.kickoff.view.KickOffFragment

class KickOffAdapter(

    private val bookList: List <Book>,
    private val onItemClickListener: OnItemClickListener <Book>

):RecyclerView.Adapter<KickOffAdapter. KickOffViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KickOffViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_kick_off, parent,false)
        return KickOffViewHolder(view)
    }

    override fun onBindViewHolder(holder: KickOffViewHolder, position: Int) {
        val books = bookList[position]
        Glide
            .with(holder.view.context)
            .load(books.img)
            .into (holder.imagen)
            holder.genre.text = books.genre
        holder.container.setOnClickListener {
            onItemClickListener.onItemClickListener(books)
        }
    }

    override fun getItemCount()= bookList.size

    class KickOffViewHolder (val view : View) : RecyclerView.ViewHolder(view){
        val imagen = view.findViewById<AppCompatImageView>(R.id.kickImageView)
        val genre = view.findViewById<TextView>(R.id.txtName)
        val container = view.findViewById<ConstraintLayout>(R.id.container)
    }
}
