package com.example.admin.demoroom

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.admin.demoroom.entity.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var db : AppDatabase ? = null
    var userAdapter: UserAdapter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = AppDatabase.getAppDatabase(this)
        userAdapter = UserAdapter(ArrayList(), this)
        rcvUser.adapter = userAdapter
        rcvUser.layoutManager = LinearLayoutManager(this)
        btSave.setOnClickListener {
            val user = User()
            user.uid = 1
            user.firstName = editText.text.toString()
            Log.d("MainAct", "123"+ db?.userDao()?.insertUser(user) )
        }

        btRefresh.setOnClickListener {
            val listUser = db?.userDao()?.allUser
            listUser?.let {
                userAdapter?.onChangeData(it)
            }
        }
    }
}
