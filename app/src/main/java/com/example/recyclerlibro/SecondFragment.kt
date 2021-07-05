package com.example.recyclerlibro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recyclerlibro.databinding.FragmentSecondBinding
import com.squareup.picasso.Picasso


class SecondFragment : Fragment() {
    private var url:String =""

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override  fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val args = arguments
        val index = args?.getString("url").toString()
        println("argumentosURL: $args")
        url = arguments?.getString("url").toString()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        Picasso.get()
            .load(url)
            .placeholder(R.drawable.content)
            .error(R.drawable.content)
            .into(binding.vistaImageView)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}