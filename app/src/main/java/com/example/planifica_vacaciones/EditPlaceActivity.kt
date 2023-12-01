package com.example.planifica_vacaciones


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.planifica_vacaciones.PlaceViewModel


class EditPlaceActivity : AppCompatActivity() {
    private lateinit var lugarViewModel: PlaceViewModel
    private var lugarId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_place)

        lugarId = intent.getIntExtra(EXTRA_PLACE_ID, 0)

        lugarViewModel = ViewModelProvider(this).get(PlaceViewModel::class.java)

        lugarViewModel.getPlaceById(lugarId).observe(this, Observer { place ->
            // Update UI with place details for editing
            // ...

            // Example: Update an EditText with the place's name for editing
            editTextPlaceName.setText(place?.name)
        })
    }
}