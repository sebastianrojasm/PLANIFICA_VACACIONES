package com.example.planifica_vacaciones

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.planifica_vacaciones.R
import com.example.planifica_vacaciones.viewmodel.PlaceViewModel

// File: DetailPlaceActivity.kt
class DetailPlaceActivity : AppCompatActivity() {
    private lateinit var placeViewModel: PlaceViewModel
    private var placeId: Long = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_place)

        // Get the ID of the selected place (received from the previous activity)
        placeId = intent.getLongExtra("EXTRA_PLACE_ID", -1)

        // Assume you have a ViewModel named PlaceViewModel that handles getting place details
        placeViewModel = PlaceViewModel(application)  // Adjust with your actual ViewModel initialization

        // Logic to get details of the place with the selected ID from your ViewModel or Database
        val selectedPlace = getDetailPlace(placeId)

        // Update the UI with the place information
        showDetailPlace(selectedPlace)
    }

    private fun getDetailPlace(placeId: Long): Place {
        // Logic to get the detail of the place from your ViewModel or Database
        // Returns the Place object with the detail
        // Assume you have a method in PlaceViewModel to get place details by ID
        return placeViewModel.getPlaceById(placeId)
    }

    private fun showDetailPlace(place: Place) {
        // Logic to display the details of the place on the UI
        // Update the views (ImageViews, TextViews, MapView, etc.) with the details of the place
        // You can use the properties of the Place object to display information
    }
}
