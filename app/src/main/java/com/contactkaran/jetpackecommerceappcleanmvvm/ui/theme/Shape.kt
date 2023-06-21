package com.contactkaran.jetpackecommerceappcleanmvvm.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(3.dp),
    medium = RoundedCornerShape(3.dp),
    large = RoundedCornerShape(
        topStart = 25.0.dp,
        topEnd = 25.0.dp,
        bottomEnd = 25.0.dp,
        bottomStart = 25.0.dp
    )
)