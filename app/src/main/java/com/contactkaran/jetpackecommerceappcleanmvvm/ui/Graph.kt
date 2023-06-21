package com.contactkaran.jetpackecommerceappcleanmvvm.ui

import android.content.Context
import com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.ShoppingListDatabase
import com.contactkaran.jetpackecommerceappcleanmvvm.ui.repository.Repository

object Graph {
    lateinit var db: ShoppingListDatabase
        private  set

    val repository by lazy {
        Repository(
            listDao = db.listDao(),
            storeDao = db.storeDao(),
            itemDao = db.itemDao()
        )
    }

    fun provide(context: Context){
        db = ShoppingListDatabase.getDatabase(context)
    }

}