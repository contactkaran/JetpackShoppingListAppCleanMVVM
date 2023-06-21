package com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room

import androidx.compose.runtime.rememberCompositionContext
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.models.Item
import com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.models.ShoppingList
import com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.models.Store
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    //methods - CRUD ops

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item)


    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM items") //Get Items
    fun getAllItems(): Flow<List<Item>>

    @Query("SELECT * FROM items WHERE item_id =:itemId")  //pull single item
    fun getItem(itemId: Int): Flow<Item>
}

@Dao
interface StoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(store: Store)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(store: Store)

    @Delete
    suspend fun delete(store: Store)

    @Query("SELECT * FROM stores")
    fun getAllStores(): Flow<List<Store>>

    @Query("SELECT * FROM stores WHERE store_id=:storeId")
    fun getStore(storeId: Int): Flow<Store>

}

@Dao
interface ListDao {  //shoppingList

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingList(shoppingList: ShoppingList)

    //TODO - now lets join tables, next line has condition to join keywords

    @Query(
        """
        SELECT * FROM items AS I INNER JOIN shopping_list AS S
        ON I.listId = S.list_id INNER JOIN stores AS ST
        ON I.storeIdFK = ST.store_id
    """
    )
    fun getItemsWithStoreAndList():Flow<List<ItemsWithStoreAndList>>

//    @Query("""
//        SELECT * FROM items AS I INNER JOIN shopping_list AS S
//        ON I.listIdFK = S.list_id INNER JOIN stores AS ST
//        ON I.storeIdFK = ST.store_id WHERE ST.listIdFK =:listID
//    """)
//    fun getItemsWithStoreAndListFilteredById(listID: Int):Flow<List<ItemsWithStoreAndList>>
//


    @Query(
        """
        SELECT * FROM items AS I INNER JOIN shopping_list AS S
        ON I.listId = S.list_id INNER JOIN stores AS ST
        ON I.storeIdFK = ST.store_id WHERE S.list_id =:listID
    """
    )
    fun getItemsWithStoreAndListFilteredById(listID: Int):Flow<List<ItemsWithStoreAndList>>

    @Query(
        """
        SELECT * FROM items AS I INNER JOIN shopping_list AS S
        ON I.listId = S.list_id INNER JOIN stores AS ST
        ON I.storeIdFK = ST.store_id WHERE I.item_id =:itemID
    """
    )
    fun getItemWithStoreAndListFilteredById(itemID: Int):Flow<ItemsWithStoreAndList>
}

data class ItemsWithStoreAndList(
    @Embedded val item: Item,
    @Embedded val shoppingList: ShoppingList,
    @Embedded val store: Store
)



