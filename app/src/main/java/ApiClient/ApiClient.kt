package apiClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var BASEURL="https://neworganicleaf.com/web-admin-login/api/"
    fun getRetrofit():Retrofit {

            return Retrofit.Builder().baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create()).build()

    }

}
