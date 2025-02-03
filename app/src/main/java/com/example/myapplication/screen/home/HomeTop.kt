package com.example.myapplication.screen.home

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeTop() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        Text(text = "내 위치", fontSize = 20.sp)

        Text(text = "25.", fontSize = 35.sp)

        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(text = "최고: 18.", fontSize = 10.sp)
            Text(text = "최저: 3.", fontSize = 10.sp)
        }
    }
}

@Preview
@Composable
fun sdad() {
    HomeTop()
}