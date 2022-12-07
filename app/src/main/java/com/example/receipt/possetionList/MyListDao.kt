package com.example.receipt.possetionList

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.receipt.recycle.MyList

@Dao
interface MyListDao {
    @Query("SELECT * FROM mylist")
    fun getAll(): List<MyList>

    @Query("SELECT * FROM mylist WHERE storage = '냉장보관'" )
    fun getRefri(): List<MyList>

    @Query("SELECT * FROM mylist WHERE storage = '냉동보관'" )
    fun getIce(): List<MyList>

    @Query("SELECT * FROM mylist WHERE storage = '상온보관'" )
    fun getRoom(): List<MyList>

    @Insert(onConflict = REPLACE)
    fun insert(mylist: MyList)

    @Delete
    fun delete(mylist: MyList)

    @Update
    fun update(mylist: MyList)
}