package org.freedu.locationappnsda.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.freedu.locationappnsda.databinding.ItemUserBinding
import org.freedu.locationappnsda.model.User

class UserAdapter(private var userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        // Function to bind user data to the views
        fun bind(user: User) {
            binding.apply {
                displayNameTxt.text = user.displayName
                emailTxt.text = user.email
                locationTxt.text = user.location
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        // Inflate the layout for each item in the RecyclerView
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        // Return the size of the list
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        // Bind each item in the list to the view holder
        val user = userList[position]
        holder.bind(user)
    }

    // Method to update the RecyclerView with new data
    fun updateData(newList: List<User>) {
        userList = newList
        notifyDataSetChanged() // Notify RecyclerView to rebind the data
    }
}
