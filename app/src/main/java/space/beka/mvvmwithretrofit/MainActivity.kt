package space.beka.mvvmwithretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import space.beka.mvvmwithretrofit.databinding.ActivityMainBinding
import space.beka.mvvmwithretrofit.view.UserAdapter
import space.beka.mvvmwithretrofit.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    private var adapters= UserAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.refresh()

    observeViewModel()
    }

    private fun observeViewModel() {
        userViewModel.users.observe(this , Observer {
            it.let {
                adapters.updateList(it)
            }
            binding.rv.apply {
                adapter = adapters
            }
        })
    }
}