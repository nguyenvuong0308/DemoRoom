package com.example.admin.demoroom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.admin.demoroom.entity.User

class UserAdapter(var mListUser:  List<User>, var mContext : Context ) : RecyclerView.Adapter<UserAdapter.UserHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(LayoutInflater.from(mContext).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return mListUser.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.tvFirstName.text = mListUser[position].firstName
    }

    fun onChangeData(listUser: List<User>) {
        mListUser = listUser
        notifyDataSetChanged()
    }

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvFirstName = itemView as TextView
    }
}