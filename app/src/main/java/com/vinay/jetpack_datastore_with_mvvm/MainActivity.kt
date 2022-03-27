package com.vinay.jetpack_datastore_with_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.vinay.jetpack_datastore_with_mvvm.data_store.DSRepository
import com.vinay.jetpack_datastore_with_mvvm.databinding.ActivityMainBinding
import com.vinay.jetpack_datastore_with_mvvm.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = mainViewModel

        mainViewModel.userData.observe(this, Observer {
            binding.etName.setText(it.name)
            binding.etPhone.setText(it.phone)
            binding.etEmail.setText(it.email)
        })

    }
}