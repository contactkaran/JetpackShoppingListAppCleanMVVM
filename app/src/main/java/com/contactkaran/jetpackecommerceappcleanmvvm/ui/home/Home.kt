package com.contactkaran.jetpackecommerceappcleanmvvm.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.ItemsWithStoreAndList
import com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.models.Item
import com.contactkaran.jetpackecommerceappcleanmvvm.ui.Category
import com.contactkaran.jetpackecommerceappcleanmvvm.ui.Utils
import com.contactkaran.jetpackecommerceappcleanmvvm.ui.theme.Shapes
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen(onNavigate: (Int) -> Unit) {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val homeState = homeViewModel.state

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { onNavigate.invoke(-1) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
        }
    ) {

        LazyColumn {
            item {
                LazyRow {
                    //TODO - create a Composable to display each of the sliding categories
                    CategoryItem()
                }
            }
        }
    }
}


@Composable
fun CategoryItem(
    @DrawableRes iconRes: Int,
    title: String,
    selected: Boolean,
    onItemClick: () -> Unit
) {
    Card(modifier = Modifier
        .padding(top = 5.dp, bottom = 5.dp, start = 5.dp)
        .selectable(
            selected = selected,
            interactionSource = MutableInteractionSource(),
            indication = rememberRipple(),
            onClick = {onItemClick.invoke()}
        ),
        border = BorderStroke(2.dp, if(selected) MaterialTheme.colorScheme.primary.copy(.5f)
        else MaterialTheme.colorScheme.onSurface),
        shape = Shapes
    ) {

    }
}