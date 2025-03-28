package com.suraj.tic_tac_toe


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.suraj.tic_tac_toe.ui.theme.Aqua
import com.suraj.tic_tac_toe.ui.theme.GreenishYellow

@Composable
fun BoardBase(){
    Canvas(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        drawLine(color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(size.width*(1f/3f), 0f),
            end = Offset(size.width*(1f/3f), size.height))

        drawLine(color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(size.width*(2f/3f), 0f),
            end = Offset(size.width*(2f/3f), size.height))

        drawLine(color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(0f, size.height*(1f/3f)),
            end = Offset(size.width,size.height*(1f/3f))
        )

        drawLine(color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(0f, size.height*(2f/3f)),
            end = Offset(size.width,size.height*(2f/3f))
        )
    }
}

@Composable
fun Cross(){
    Canvas(modifier = Modifier
        .size(60.dp)
        .padding(5.dp)) {
        drawLine(color = GreenishYellow,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(0f, 0f),
            end = Offset(size.width, size.height)
        )
        drawLine(color = GreenishYellow,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(0f, size.height),
            end = Offset(size.width, 0f)
        )
    }
}

@Composable
fun Circle(){
    Canvas(modifier = Modifier
        .size(60.dp)
        .padding(5.dp)) {
        drawCircle(color = Aqua,
            style = Stroke(width = 20f)
        )
    }
}

@Composable
fun WinLine1(){
    Canvas(modifier = Modifier
        .fillMaxSize()) {
        drawLine(color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(0f, size.height*1/6),
            end = Offset(size.width, size.height*1/6)
        )
    }
}
@Composable
fun WinLine2(){
    Canvas(modifier = Modifier
        .fillMaxSize()) {
        drawLine(color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(0f, size.height*3/6),
            end = Offset(size.width, size.height*3/6)
        )
    }
}
@Composable
fun WinLine3(){
    Canvas(modifier = Modifier
        .fillMaxSize()) {
        drawLine(color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(0f, size.height*5/6),
            end = Offset(size.width, size.height*5/6)
        )
    }
}
@Composable
fun WinLine4(){
    Canvas(modifier = Modifier
        .fillMaxSize()) {
        drawLine(color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(size.width*1/6, 0f),
            end = Offset(size.width*1/6, size.height)
        )
    }
}
@Composable
fun WinLine5(){
    Canvas(modifier = Modifier
        .fillMaxSize()) {
        drawLine(color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(size.width*3/6, 0f),
            end = Offset(size.width*3/6, size.height)
        )
    }
}
@Composable
fun WinLine6(){
    Canvas(modifier = Modifier
        .fillMaxSize()) {
        drawLine(color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(size.width*5/6, 0f),
            end = Offset(size.width*5/6, size.height)
        )
    }
}

@Composable
fun WinLine7(){
    Canvas(modifier = Modifier
        .fillMaxSize()) {
        drawLine(color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(0f, 0f),
            end = Offset(size.width, size.height)
        )
    }
}

@Composable
fun WinLine8(){
    Canvas(modifier = Modifier
        .fillMaxSize()) {
        drawLine(color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(0f, size.height),
            end = Offset(size.width, 0f)
        )
    }
}

@Composable
fun SimpleTextField(label: String) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(label,
            fontSize = 25.sp,
            color = Color.Black) },
        textStyle = TextStyle(fontSize = 25.sp,
            fontWeight = FontWeight.Bold),
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .padding(16.dp)
    )
}