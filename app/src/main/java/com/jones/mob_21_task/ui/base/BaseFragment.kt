package com.jones.mob_21_task.ui.base

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.jones.mob_21_task.R
import kotlinx.coroutines.launch

abstract class BaseFragment<T : ViewBinding> : Fragment() {

    protected lateinit var binding: T
    protected abstract val viewModel: BaseViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onFragmentResult()
        setupUIComponents()
        setupViewModelObserver()
    }

    protected open fun onFragmentResult() {}

    protected open fun setupUIComponents() {}

    protected open fun setupViewModelObserver() {
        lifecycleScope.launch {
            viewModel.error.collect {
                showSnackbar(it, true)
            }
        }

        lifecycleScope.launch {
            viewModel.success.collect {
                showSnackbar(it)
            }
        }
    }

    private fun showSnackbar(msg: String, isError: Boolean = false) {
        val sb = Snackbar.make(
            binding.root,
            msg,
            Snackbar.LENGTH_LONG
        )
        if (isError)
            sb.setBackgroundTint(
                ContextCompat.getColor(requireContext(), R.color.error)
            )
        sb.show()
    }
}

