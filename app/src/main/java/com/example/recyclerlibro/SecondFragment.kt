package com.example.recyclerlibro

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recyclerlibro.databinding.FragmentSecondBinding
import com.squareup.picasso.Picasso


class SecondFragment : Fragment() {
    private var name:String=""
    private var url:String =""
    private  var author:String=""
    private var des:String=""

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override  fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        name = arguments?.getString("name").toString()
        url = arguments?.getString("url").toString()
        author = arguments?.getString("author").toString()
        des = arguments?.getString("des").toString()

    }
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        binding.nameTextView.text = name
        binding.authorTextView.text = "author: $author"
        binding.descriptionTextView.text = des
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.missingbook)
            .error(R.drawable.missingbook)
            .into(binding.vistaImageView)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}