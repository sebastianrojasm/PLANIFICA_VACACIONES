package com.example.planifica_vacaciones

import android.os.Bundle
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import android.content.Intent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var lugarViewModel: PlaceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lugarViewModel = ViewModelProvider(this).get(PlaceViewModel::class.java)

        // Set up RecyclerView and adapter to display places
        val adapter = PlaceListAdapter()
        recyclerViewPlaces.adapter = adapter
        recyclerViewPlaces.layoutManager = LinearLayoutManager(this)

        lugarViewModel.allPlaces.observe(this, Observer { places ->
            // Update the cached copy of places in the adapter
            places?.let { adapter.setPlaces(it) }
        })
    }
}