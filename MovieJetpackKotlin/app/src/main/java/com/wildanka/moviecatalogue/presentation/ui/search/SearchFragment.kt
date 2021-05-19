package com.wildanka.moviecatalogue.presentation.ui.search

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.wildanka.moviecatalogue.R
import com.wildanka.moviecatalogue.databinding.SearchFragmentBinding


class SearchFragment : BottomSheetDialogFragment() {
    private lateinit var binding: SearchFragmentBinding
    private var isSearchMovie = false


    private lateinit var viewModel: SearchViewModel
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener { dialogInterface ->

            val bottomSheetDialog = dialogInterface as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { it ->
                val behaviour = BottomSheetBehavior.from(it)
                setupFullHeight(it)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.search_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.radioGroup.setOnCheckedChangeListener { _, _ -> changeTextHint() }

        binding.searchTitle.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                //search movie or tv show
                if (isSearchMovie){
                    query?.let {
                        viewModel.getSearchedMovies(it)?.observe(viewLifecycleOwner, {
                            if (it != null){
                                Log.e("TAG", "OQTS")
                                Toast.makeText(activity, "OQTS", Toast.LENGTH_SHORT).show()
                            }else{
                                Log.e("TAG", "OQTS Failed")
                                Toast.makeText(activity, "OQTS failed", Toast.LENGTH_SHORT).show()
                            }
                        })
                    }
                }

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        // TODO: Use the ViewModel
    }


    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }

    override fun onResume() {
        super.onResume()
        changeTextHint()
    }

    private fun changeTextHint(){
        if (binding.radioGroup.checkedRadioButtonId == R.id.rb_movie){
            isSearchMovie = true
            binding.searchTitle.queryHint = "Movie title"
        }else{
            isSearchMovie = false
            binding.searchTitle.queryHint = "TV Show title"
        }
    }
}