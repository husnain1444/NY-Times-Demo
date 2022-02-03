package com.test.ny.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.test.ny.adapter.SectionAdapter
import com.test.ny.databinding.ActivityMainBinding
import com.test.ny.network.MyViewModelFactory
import com.test.ny.network.RetrofitService
import com.test.ny.viewmodel.MainRepository
import com.test.ny.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private val adapter = SectionAdapter()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)
        binding.recyclerview.adapter = adapter

        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(MainViewModel::class.java)


        viewModel.sectionList.observe(this, {
            adapter.setSection(this,it)
        })

        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.loading.observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })

        viewModel.getAllSections()

    }
}