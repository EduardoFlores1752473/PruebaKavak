package com.example.pruebakavak.presentacion.booklist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.pruebakavak.R

class FragmentBookList: Fragment() {

    private var fragmentBookListAdapBinding : FragmentBookListAdapBinding ? = null

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

        fragmentBookListAdapBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_book_list_adapter,
            container,
            false
        )
        return fragmentBookListAdapBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}