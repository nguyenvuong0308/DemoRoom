package com.example.admin.demoroom.dao;

import com.example.admin.demoroom.entity.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {
    @Query("Select * from user")
    List<User> getAllUser();

    @Query("Select * from user where first_name LIKE :firstName")
    List<User> findUserByFirstName(String firstName);

    @Update
    int insertUser(User user);

    @Delete
    void deleteUser(User user);
}
