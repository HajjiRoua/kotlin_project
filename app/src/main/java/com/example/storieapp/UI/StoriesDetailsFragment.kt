package com.example.storieapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.storieapp.databinding.FragmentStoriesDetailsBinding

/**
 * A simple [Fragment] subclass.
 * Use the [storiesDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class storiesDetailsFragment : Fragment() {
    private var binding: FragmentStoriesDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoriesDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { bundle ->
            val abstract = bundle.getString("abstract")
            val title = bundle.getString("title")
            val byline = bundle.getString("byline")
            val publishedDate = bundle.getString("published_date")
            // Set data to the binding
            binding?.apply {
                textAbstract.text = abstract
                textTitle.text = title
                textByline.text = byline
                textPublishedDate.text = publishedDate
            }
        }
    }
}