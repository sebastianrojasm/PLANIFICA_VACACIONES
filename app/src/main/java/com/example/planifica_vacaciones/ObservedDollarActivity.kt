package com.example.planifica_vacaciones
//*
import android.os.Bundle
import android.app.DownloadManager
import android.os.Bundle
import android.telecom.Call
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.ImageProcessor
import kotlinx.android.synthetic.main.activity_dolar_observado.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import javax.security.auth.callback.Callback
//*

//La función principal de este código es obtener el valor del dólar observado desde una
// API externa y actualizar la interfaz de usuario con ese valor.

class DollarObservationActivity : AppCompatActivity() {
    private lateinit var dollarViewModel: DollarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dollar_observation)

        // Call the function to get the observed dollar value from the API
        getObservedDollar()
    }

    private fun getObservedDollar() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://mindicador.cl/api")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.let {
                    val jsonResponse = it.string()
                    val jsonObject = JSONObject(jsonResponse)

                    // Get the value of the dollar from the JSON (in this example, assuming the dollar value is under "dolar")
                    val dollarValue = jsonObject.getJSONObject("dolar").getDouble("valor")

                    // Update the UI with the obtained dollar value
                    runOnUiThread {
                        textViewDollarValue.text = "$ $dollarValue" // Show the dollar value in a TextView
                    }
                }
            }
        })
    }
}
