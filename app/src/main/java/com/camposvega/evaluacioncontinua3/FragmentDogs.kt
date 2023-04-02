package com.camposvega.evaluacioncontinua3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.camposvega.evaluacioncontinua3.data.DogResponse
import com.camposvega.evaluacioncontinua3.data.api.ApiClient.ApiClient.apiService
import com.camposvega.evaluacioncontinua3.data.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentDogs : Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_lista_dogs, container, false)
        recyclerView = view.findViewById(R.id.rv_dogs)
        val gridLayoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = gridLayoutManager
        obtenerImgRazas()
        return view
    }

    private fun obtenerImgRazas() {
        val apiService: ApiService = apiService
        apiService.getDogs().enqueue(object : Callback<DogResponse> {
            override fun onResponse(call: Call<DogResponse>, response: Response<DogResponse>) {
                if (response.isSuccessful) {
                    println(response.body())
                    val breedsList = response.body()?.message ?: emptyList()
                    recyclerView.adapter = DogAdapter(breedsList)
                }
            }
            override fun onFailure(call: Call<DogResponse>, t: Throwable) {
                println("Error consiguiendo datos")
            }
        })
    }
}