package com.example.planifica_vacaciones

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.planifica_vacaciones.R
//import com.example.planifica_vacaciones.db.Place
import com.example.planifica_vacaciones.Place

//Este adaptador se encarga de proporcionar vistas que representan elementos de datos individuales en un RecyclerView.
class PlaceAdapter(private val places: List<Place>) : RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {

    inner class PlaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val placeName: TextView = itemView.findViewById(R.id.tvPlaceName)
        val placeDescription: TextView = itemView.findViewById(R.id.tvPlaceDescription)
    }

    //Crea nuevas instancias de PlaceViewHolder cuando se necesitan.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false)
        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val currentPlace = places[position]
        holder.placeName.text = currentPlace.name
        holder.placeDescription.text = currentPlace.description
    }

    //Devuelve la cantidad total de elementos en la lista
    override fun getItemCount(): Int {
        return places.size
    }
}