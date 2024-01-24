package com.example.storieapp.UI

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.storieapp.databinding.FragmentStoriesBinding
import com.example.storieapp.Adapters.storiesListAdapter
import com.example.storieapp.ViewModels.storiesViewModel


class storiesFragment : Fragment() {
    private var _binding: FragmentStoriesBinding? = null
    private val binding get() = _binding!!
    private val viewModal : storiesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStoriesBinding.inflate(inflater, container, false)
        val view = binding.root

        setupstorieNameList();
        setupstorieList();
        return view
    }

    fun setupstorieNameList(){
            val adapter =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, viewModal.storieListNames)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinner.adapter = adapter


        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                viewModal.setstorieListValue(selectedItem);
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case when nothing is selected
            }
        }
    }

    fun setupstorieList(){
        viewModal.storiesList.observe(viewLifecycleOwner){
            binding.recyclerView.adapter = storiesListAdapter(it)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.isNestedScrollingEnabled = true
    }
}