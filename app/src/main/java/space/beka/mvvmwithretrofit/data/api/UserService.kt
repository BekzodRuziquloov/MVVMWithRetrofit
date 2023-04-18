package space.beka.mvvmwithretrofit.data.api

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import space.beka.mvvmwithretrofit.model.User

class UserService {
    private val BASE_URL = "https://jsonplaceholder.typicode.com"

    private val api =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(UserApi::class.java)

    fun getUsers(): Single<List<User>> {
        return api.getUser()
    }
}