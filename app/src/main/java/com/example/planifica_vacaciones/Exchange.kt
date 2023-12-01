package com.example.planifica_vacaciones

import android.os.AsyncTask
import com.example.planifica_vacaciones.api.ExchangeListener

class Exchange(private val listener: ExchangeListener) : AsyncTask<Void?, Void?, Double>() {

    override fun doInBackground(vararg params: Void?): Double {
        // Logic to get the exchange rate from an API
        // Returns the value of the exchange rate
        // ...
    }

    override fun onPostExecute(result: Double) {
        // Called when the exchange retrieval task is completed
        listener.onExchangeObtained(result)
    }
}
