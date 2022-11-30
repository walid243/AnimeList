package com.example.animelist.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.animelist.`interface`.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.animelist.model.Character
class Repository {

    private val apiInterface = ApiInterface.create()
    var dataInfo = MutableLiveData<List<Character>?>()

    fun fetchAllCharacters(): MutableLiveData<List<Character>?> {
        val call = apiInterface.getCharacters()
        call.enqueue(object: Callback<List<Character>> {
            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                Log.e("ERROR", t.message.toString())
                dataInfo.postValue(null)
            }

            override fun onResponse(
                call: Call<List<Character>>,
                response: Response<List<Character>>
            ) {
                if (response.isSuccessful) {
                    dataInfo.value = response.body()
                }
            }
        })
        return dataInfo
    }
}
