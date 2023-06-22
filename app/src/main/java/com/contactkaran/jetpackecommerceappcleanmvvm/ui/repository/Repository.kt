package com.contactkaran.jetpackecommerceappcleanmvvm.ui.repository

import com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.ItemDao
import com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.ListDao
import com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.StoreDao
import com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.models.Item
import com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.models.ShoppingList
import com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.models.Store

class Repository(
    private val listDao: ListDao,
    private val storeDao: StoreDao,
    private val itemDao: ItemDao
) {
    val store = storeDao.getAllStores()
    val getItemsWithListAndStore = listDao.getItemsWithStoreAndList()

    //fun that returns filtered data
    fun getItemWithStoreAndList(id: Int) = listDao
        .getItemWithStoreAndListFilteredById(id)  //single item

    fun getItemWithStoreAndListFilteredById(id: Int) = listDao
        .getItemsWithStoreAndListFilteredById(id)  //items list, say using Category

    suspend fun insertList(shoppingList: ShoppingList){
        listDao.insertShoppingList(shoppingList)
    }

    suspend fun insertStore(store: Store){
        storeDao.insert(store)
    }

    suspend fun insertItem(item: Item){
        itemDao.insert(item)
    }

    suspend fun deleteItem(item: Item){
        itemDao.delete(item)
    }

    suspend fun updateItem(item: Item){
        itemDao.update(item)
    }
}