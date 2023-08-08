package com.rajibul.expensetracker.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rajibul.expensetracker.R

@Database(version = 1, entities = [ExpenseEntity::class, CategoryEntity::class])
abstract class ExpenseDatabase : RoomDatabase(){
    abstract fun expenseDao(): ExpenseDao
    companion object{
        private var expenseDatabase : ExpenseDatabase ?= null

        fun getDatabase(context: Context) : ExpenseDatabase{
            if(expenseDatabase == null){
                expenseDatabase = Room.databaseBuilder(context,
                    ExpenseDatabase::class.java,
                    context.resources.getString(
                        R.string.app_name))
                    .build()
            }

            return expenseDatabase!!
        }
    }

}