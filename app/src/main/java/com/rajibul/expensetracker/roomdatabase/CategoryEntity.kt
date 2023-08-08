package com.rajibul.expensetracker.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String ?= null
)
