package com.example.catfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.catfacts.adapter.MainAdapter
import com.example.catfacts.viewmodel.FactViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var factViewModel: FactViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonGetFact: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var mainAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init() {
        factViewModel = ViewModelProvider(this)[FactViewModel::class.java]
        recyclerView = findViewById(R.id.recyclerView)
        buttonGetFact = findViewById(R.id.buttonGetFact)
        progressBar = findViewById(R.id.progressBar)
        mainAdapter = MainAdapter(factViewModel.getList())
        recyclerView.adapter = mainAdapter
        buttonGetFact()
    }
    private fun buttonGetFact() {
        buttonGetFact.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            factViewModel.getFact().observe(this){ fact ->
                val currentSize = factViewModel.getList().size
                progressBar.visibility = View.GONE
                if(fact != null){
                    factViewModel.getList().add(fact)
                    mainAdapter.notifyItemRangeInserted(currentSize, factViewModel.getList().size)
                    recyclerView.smoothScrollToPosition(factViewModel.getList().size-1)
                }
            }
        }
    }
}