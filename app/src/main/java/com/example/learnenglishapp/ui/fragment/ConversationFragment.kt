package com.example.learnenglishapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.learnenglishapp.ui.activity.ListenAndRepeatListActivity
import com.example.learnenglishapp.ui.activity.ListenAndWriteListActivity
import com.example.learnenglishapp.R

class ConversationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Gắn layout của fragment vào
        return inflater.inflate(R.layout.fragment_conversation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Gắn sự kiện cho button
        val btnWrite = view.findViewById<Button>(R.id.button2)
        val btnRepeat = view.findViewById<Button>(R.id.button3)
        btnWrite.setOnClickListener {
            // Mở LessonDetailActivity
            val intent = Intent(requireContext(), ListenAndWriteListActivity::class.java)
            startActivity(intent)
        }

        btnRepeat.setOnClickListener{
            val intent =  Intent(requireContext(), ListenAndRepeatListActivity::class.java)
            startActivity(intent)
        }
    }
}
