package com.example.storieapp.Adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.storieapp.R
import com.example.storieapp.API.Result


class storiesListAdapter(private var dataSet: List<Result> = emptyList()) :
    RecyclerView.Adapter<storiesListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView
        val abstractView: TextView

        init {
            titleView = view.findViewById(R.id.titleTextView)
            abstractView = view.findViewById(R.id.abstractTextView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.fragment_stories_list_details, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.abstractView.text = dataSet[position].abstract
        viewHolder.titleView.text = dataSet[position].title

        viewHolder.itemView.setOnClickListener{ view ->
            val bundle = Bundle()
            bundle.putString("abstract", dataSet[position].abstract)
            bundle.putString("title", dataSet[position].title)
            bundle.putString("byline", dataSet[position].byline)
            bundle.putString("published_date", dataSet[position].published_date)
            view.findNavController().navigate(R.id.action_storiesFragment_to_storieDetailsFragment, bundle)
        }
    }

    override fun getItemCount() = dataSet.size
}
