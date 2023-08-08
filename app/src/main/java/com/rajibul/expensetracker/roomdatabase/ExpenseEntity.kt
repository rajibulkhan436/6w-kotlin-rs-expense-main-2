package com.rajibul.expensetracker.roomdatabase

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = CategoryEntity::class, parentColumns = ["id"], childColumns = ["categoryId"])])
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String ?= null,
    var categoryId: Long ?= null
)
