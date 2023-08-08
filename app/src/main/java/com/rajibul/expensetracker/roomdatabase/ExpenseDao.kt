package com.rajibul.expensetracker.roomdatabase

import androidx.core.view.WindowInsetsCompat.Type.InsetsType
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExpenseDao {
    @Insert
    fun insertExpense(expenseEntity: ExpenseEntity)
    @Insert
    fun insertCategory(categoryEntity: CategoryEntity)

    @Query("SELECT * FROM categoryentity")
    fun getCategories() : List<CategoryEntity>
}