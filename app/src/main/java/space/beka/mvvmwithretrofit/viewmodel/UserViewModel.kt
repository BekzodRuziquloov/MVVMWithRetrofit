package space.beka.mvvmwithretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import space.beka.mvvmwithretrofit.data.api.UserService
import space.beka.mvvmwithretrofit.model.User

class UserViewModel : ViewModel() {
    val users = MutableLiveData<List<User>>()
    private val userService: UserService = UserService()
    private val disposable: CompositeDisposable = CompositeDisposable()
    fun refresh() {
        fetchDataFromRemoteApi()
    }

    private fun fetchDataFromRemoteApi() {
        disposable.add(
            userService.getUsers().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<User>>() {
                    override fun onSuccess(value: List<User>?) {
                        users.value = value
                    }
                    override fun onError(e: Throwable?) {
                        e!!.printStackTrace()
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}