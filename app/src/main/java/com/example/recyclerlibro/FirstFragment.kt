package com.example.recyclerlibro

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerlibro.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
open class FirstFragment : Fragment(), ItemAdapter.ItemClickListener  {

    private var _binding: FragmentFirstBinding? = null
    private lateinit  var recycler : RecyclerView
    private lateinit  var lista : List<Item>


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        recycler= binding.recycler
        recycler.layoutManager = LinearLayoutManager(context)
        llenarLista()
        var adapter = ItemAdapter(this.lista, this)
        recycler.adapter = adapter
        Toast.makeText(context, "Notificación larga", Toast.LENGTH_LONG).show()




        return binding.root


    }

    private fun llenarLista() {
        lista = listOf(
            Item("Sabrina","Cabral"),
            Item("Sabrina","Cabral"),
            Item("Sabrina","Cabral"),
            Item("Sabrina","Cabral"),
            Item("Sabrina","Cabral"),
            Item("Sabrina","Cabral"),
            Item("Sabrina","Cabral"),
            Item("Sabrina","Cabral"),
            Item("Sabrina","Cabral"),
            Item("Sabrina","Cabral"),
            Item("Sabrina","Cabral"),
            Item("Sabrina","Cabral"))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    override fun onItemClick(elelement: Any) {

        Toast.makeText(context, "Notificación larga", Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

    }
}