/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.accessibility.AccessibilityRecord
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.android.navigation.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_won, container, false)
        binding.nextMatchButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_gameWonFragment_to_gameFragment))
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        if(getShareIntent().resolveActivity(activity!!.packageManager) != null) {
            inflater.inflate(R.menu.winner_menu, menu)
        }// the menu will inflate only when the package manager detects that some app can handle the request
    }

    private fun getShareIntent() : Intent{
        val args = GameWonFragmentArgs.fromBundle(arguments!!)
        val shareIntent = ShareCompat.IntentBuilder.from(activity!!)
                .setType("text/plain")
                .setText(getString(R.string.share_success_text, args.numQuestions, args.numCorrect))
                .intent
        return shareIntent
    }
    // NOTE:
    // had to change the function a bit to make it return an intent so that it can be used to
    // resolveActivity in package manager for the onCreateOptionsMenu and for the sharing purpose when clicked.

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}
