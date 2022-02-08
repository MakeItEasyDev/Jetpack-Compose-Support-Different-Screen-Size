package com.jetpack.supportdifferentscreensize

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Dimensions(
    val dimens_1: Dp,
    val dimens_2: Dp
)

val smallDimension = Dimensions(
    dimens_1 = 10.dp,
    dimens_2 = 10.dp
)

val sw420Dimension = Dimensions(
    dimens_1 = 20.dp,
    dimens_2 = 20.dp
)

class Typography(
    val fontSize_1: TextStyle
)

val textSmallDimension = Typography(
    fontSize_1 = TextStyle.Default.copy(fontSize = 15.sp)
)

val textSw420Dimensions = Typography(
    fontSize_1 = TextStyle.Default.copy(fontSize = 35.sp)
)






















