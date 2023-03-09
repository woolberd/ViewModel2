package com.example.viewmodel2.ui.fragments.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.viewmodel2.databinding.FragmentSecondMainBinding

class SecondMainFragment : Fragment() {

    private lateinit var binding: FragmentSecondMainBinding
    private var viewModel: SecondMainViewModel? = null
    private val args by navArgs<SecondMainFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[SecondMainViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() = with(binding) {
        txtTitleDetail.text = args.title
        val model = args.image
        Glide.with(imageDetail.context).load(model).into(imageDetail)
    }


}