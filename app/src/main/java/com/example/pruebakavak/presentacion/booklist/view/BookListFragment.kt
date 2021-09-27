package com.example.pruebakavak.presentacion.booklist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.pruebakavak.R
import com.example.pruebakavak.databinding.FragmentBookListBinding

class BookListFragment: Fragment() {

    private var fragmentBookListBinding : FragmentBookListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentBookListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_book_list,
            container,
            false
        )
        return fragmentBookListBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}