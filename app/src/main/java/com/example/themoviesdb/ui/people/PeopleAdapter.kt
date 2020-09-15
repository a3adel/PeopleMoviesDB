package com.example.themoviesdb.ui.people

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.ui.utils.OnRecyclerViewItemClickListener
import com.example.themoviesdb.R
import com.example.themoviesdb.data.models.Person
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_person_layout.view.*

class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.PersonViewHolder>() {
    lateinit var people: ArrayList<Person>
    lateinit var context: Context
    lateinit var onRecyclerViewItemClickListener: OnRecyclerViewItemClickListener
    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_person_layout, parent, false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return people.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        Picasso.get().load(people.get(position).getImageUrl()).into(holder.itemView.person_image)
        holder.itemView.person_name.text = people.get(position).name
        holder.itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                onRecyclerViewItemClickListener.onItemClicked(position)
            }
        })
    }


}