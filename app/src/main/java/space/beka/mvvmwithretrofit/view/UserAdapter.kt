package space.beka.mvvmwithretrofit.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.beka.mvvmwithretrofit.databinding.UserItemBinding
import space.beka.mvvmwithretrofit.model.User

class UserAdapter(var list: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.Vh>() {
    inner class Vh(var itemRvBinding: UserItemBinding) :
        RecyclerView.ViewHolder(itemRvBinding.root) {
        fun onBind(user: User, position: Int) {
            itemRvBinding.userId.text = user.id.toString()
            itemRvBinding.sarlavha.text = user.sarlavha
            itemRvBinding.matn.text = user.matn
            itemRvBinding.oxirgiMuddat.text = user.oxirgi_muddat
            itemRvBinding.holat.text = user.holat
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    fun updateList(newUpdatedList: List<User>) {
        list.clear()
        list.addAll(newUpdatedList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size
}