package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_title, container, false
        )
        // fragments don't have setContentView
        // we are using data binding, using FragmentTitleBinding and inflate method
        // passing in the following parameters :
        // 1. inflater{passed in the onCreateView constructor}
        // 2. layout file, 3.container{parent Activity} , 4.false for not attaching the fragment to the parent activity

        binding.playButton.setOnClickListener {view : View ->
            Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)
            // findNavController is a function that returns the view's parent fragment's host controller
            // in other words gives an instance of the navigation controller
            // the id is of the action can be found in the properties if the arrow in the navigation graph
            // the above line can also be written as -
            // "view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)"
        }

        // THE SIMPLEST WAY TO WRITE THE ABOVE clickListener is -
        // binding.playButton.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment))

        setHasOptionsMenu(true)
        // turns on the menu in the fragment

        return binding.root
        // returning the root of the binding layout
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
        // inflating the menu
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController()) || super.onOptionsItemSelected(item)
    }
}