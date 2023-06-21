package com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "shopping_list")
data class ShoppingList(
    @ColumnInfo(name = "list_id")
    @PrimaryKey
    val id: Int,
    val name: String,
    val desc: String
)

@Entity(tableName = "items")
data class Item(
    @ColumnInfo(name = "item_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val itemName: String,
    val quantity: String,
    val listId: Int,
    val storeIdFK: Int,
    val date: Date,
    val isChecked: Boolean
)

//connecting shoppingList with itemsTable, bring PrimaryKey from first table down to second
//listId ForeignKey

@Entity(tableName = "stores")
data class Store(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "store_id")
    val id: Int = 0,
    val listIdFK: Int  //linking here
)