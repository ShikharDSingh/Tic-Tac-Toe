package com.suraj.tic_tac_toe


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.suraj.tic_tac_toe.ui.theme.GreyBackground
import com.suraj.tic_tac_toe.ui.theme.GreyT

@Composable
fun HomeScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(GreyBackground),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(GreyT)){

        }

        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text("Tic Tac Toe",
                fontSize = 80.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
            Button(onClick = {

            }) {
                Text(text = "Play OffLine",
                    fontSize = 30.sp)
            }

            Button(onClick = {

            }) {
                Text(text = "Play Online",
                    fontSize = 30.sp)
            }

            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly) {
                SimpleTextField("Enter Id")

                Button(onClick = {

                }) {
                    Text(text = "Join",
                        fontSize = 30.sp)
                }
            }
        }
    }
}