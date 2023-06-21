package com.contactkaran.jetpackecommerceappcleanmvvm.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.ItemsWithStoreAndList
import com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.models.Item
import com.contactkaran.jetpackecommerceappcleanmvvm.ui.Category
import com.contactkaran.jetpackecommerceappcleanmvvm.ui.Graph
import com.contactkaran.jetpackecommerceappcleanmvvm.ui.repository.Repository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: Repository = Graph.repository
): ViewModel(){

    var state by mutableStateOf(HomeState())
        private set

    init {
        getItems()
    }

    private fun getItems(){
        viewModelScope.launch {
            repository.getItemsWithListAndStore.collectLatest {
                state = state.copy(
                    items = it
                )
            }
        }
    }

    private fun deleteItems(item: Item){
        viewModelScope.launch {
            repository.deleteItem(item)
        }
    }

    fun onCategoryChange(category: Category){
        state = state.copy(category = category)
        filterBy(category.id)
    }

    fun onItemCheckedChange(item: Item, isChecked: Boolean){
        viewModelScope.launch {
            repository.updateItem(
                item = item.copy(
                    isChecked = isChecked
                )
            )
        }
    }

    private fun filterBy(shoppingListId: Int){
        if(shoppingListId != 1000001){
            viewModelScope.launch {
                repository.getItemWithStoreAndListFilteredById(
                    shoppingListId
                ).collectLatest {
                    state = state.copy(items = it)
                }
            }
        } else {
            getItems()  //items without filtering
        }
    }


}


data class HomeState(
    val items: List<ItemsWithStoreAndList> = emptyList(),
    val category: Category = Category(),
    val itemChecked: Boolean = false
)