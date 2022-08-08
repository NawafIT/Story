package com.example.story

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.text.ParsePosition
import java.util.*
import kotlin.collections.ArrayList


class StoryAdapter(private val array:ArrayList<Story>, private val context:Context):
    RecyclerView.Adapter<StoryAdapter.DataHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup , view: Int): DataHolder {
        val data = DataHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.custom, parent, false))
        return data
    }

    override fun getItemCount(): Int {
        return array.size
    }
    override fun onBindViewHolder(holder: DataHolder , position: Int){
        val story:Story = array[position]
        holder.title.text = story.title
        holder.subtitle.text = story.subTitle
        holder.storyLetter.text= story.title.first().toString()

        generateColor(holder, position)

        holder.itemView.setOnClickListener{
            val i: Intent = Intent(context, StoryDetalis::class.java)
            i.putExtra("title", story.title)
            i.putExtra("description", story.description)
            context.startActivity(i)
        }

    }
    private fun generateColor(holder:DataHolder , position: Int){
        val r:Random = Random()
        val red = r.nextInt(255 + position)
        val green = r.nextInt(255 - position + 1)
        val blue = r.nextInt(255 + position + 1)
        holder.cardViewLetter.setCardBackgroundColor(Color.rgb(red,green,blue))




    }

    class DataHolder(view: View):RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.title)
        val subtitle: TextView = view.findViewById(R.id.subtitle)
        val storyLetter:TextView = view.findViewById(R.id.letter)
        val cardViewLetter: CardView = view.findViewById(R.id.cardView)
    }


}