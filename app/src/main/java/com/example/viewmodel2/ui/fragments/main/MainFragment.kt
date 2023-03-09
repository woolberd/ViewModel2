package com.example.viewmodel2.ui.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodel2.utils.adapter.MainAdapter
import com.example.viewmodel2.utils.model.MainModel
import com.example.viewmodel2.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private var list: ArrayList<MainModel> = ArrayList()
    private val mainAdapter = MainAdapter(this::onItemClick)
    private var viewModel: MainViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        clear()
        initialize()
        setupListener()
        setupObserves()
    }

    private fun setupObserves() {
        viewModel?.getModelList()?.observe(viewLifecycleOwner) {
            mainAdapter.setList(it)
        }
    }

    private fun setupListener() {
        binding.btnSwap.isInvisible = false
        binding.recyclerView.isInvisible = true

        binding.btnSwap.setOnClickListener {
            binding.btnSwap.isInvisible = true
            binding.recyclerView.isInvisible = false
        }
    }

    private fun initialize() {
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.recyclerView.adapter = mainAdapter
    }

    private fun clear() {
        list.clear()
    }

    private fun onItemClick(model: MainModel) {
        val text = model.title
        val image = model.image
        findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToSecondMainFragment()
                .setTitle(text).setImage(image)
        )
    }

}