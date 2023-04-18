package space.beka.mvvmwithretrofit.data.api

import io.reactivex.Single
import retrofit2.http.GET
import space.beka.mvvmwithretrofit.model.User

interface UserApi {
    @GET("posts")
    fun getUser():Single<List<User>>
}