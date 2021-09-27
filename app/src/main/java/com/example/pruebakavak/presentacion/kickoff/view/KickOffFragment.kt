package com.example.pruebakavak.presentacion.kickoff.view

import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebakavak.R
import com.example.pruebakavak.data.network.models.Book
import com.example.pruebakavak.data.network.repositories.KickOffNetworkRepository
import com.example.pruebakavak.databinding.FragmentKickOffBinding
import com.example.pruebakavak.domain.useCase.GetBookListUsesCase
import com.example.pruebakavak.presentacion.core.callback.OnItemClickListener
import com.example.pruebakavak.presentacion.core.callback.ResultCallBack
import com.example.pruebakavak.presentacion.kickoff.adapter.KickOffAdapter
import com.example.pruebakavak.presentacion.kickoff.viewModel.KickOffViewModel
import com.example.pruebakavak.presentacion.kickoff.viewModel.KickOffViewModelFactory

class KickOffFragment : Fragment(), OnItemClickListener<Book>,ResultCallBack<String> {

    private var fragmentKickOffBinding: FragmentKickOffBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentKickOffBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_kick_off,
            container,
            false
        )

        fragmentKickOffBinding?.kickOffFragmentViewModel =
            ViewModelProvider(this,
                KickOffViewModelFactory(
                    GetBookListUsesCase(KickOffNetworkRepository()),
                    this
                )
            ).get(KickOffViewModel::class.java)

        return fragmentKickOffBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentKickOffBinding?.kickOffFragmentViewModel?.typesOfBooksMLD?.observe(
            viewLifecycleOwner, { bookResponse ->

                if (bookResponse.books != null && bookResponse.books.isEmpty()){
                    fragmentKickOffBinding?.rvTypesOffBooks?.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = KickOffAdapter(bookResponse.books,this@KickOffFragment)
                    }
                }
            }
        )
    }

    override fun onItemClickListener(item: Book, type: String?) {
    }

    override fun onError(message: String, type: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

    }

    override fun onSucces(type: String) {
    }

}