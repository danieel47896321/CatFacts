package com.example.catfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.example.catfacts.adapter.MainAdapter
import com.example.catfacts.api.CatJson

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonGetFact: Button
    private lateinit var progressBar: ProgressBar
    private var factList = ArrayList<CatJson>()
    private var mainAdapter: MainAdapter = MainAdapter(factList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init() {
        recyclerView = findViewById(R.id.recyclerView)
        buttonGetFact = findViewById(R.id.buttonGetFact)
        progressBar = findViewById(R.id.progressBar)
        recyclerView.adapter = mainAdapter
        buttonGetFact()
    }
    private fun buttonGetFact() {
        buttonGetFact.setOnClickListener {

        }
    }
}