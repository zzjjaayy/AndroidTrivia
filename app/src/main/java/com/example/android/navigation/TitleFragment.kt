package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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

        return binding.root
        // returning the root of the binding layout
    }
}