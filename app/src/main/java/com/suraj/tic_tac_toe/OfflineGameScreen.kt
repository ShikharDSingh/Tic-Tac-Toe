package com.suraj.tic_tac_toe

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.suraj.tic_tac_toe.ui.theme.GreyBackground
import com.suraj.tic_tac_toe.ui.theme.GreyT

@Composable
fun OffLineGameScreen(viewModel: GameViewModel){
    val state = viewModel.state
    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(GreyT)){

        }
        Column(modifier = Modifier
            .fillMaxSize()
            .background(GreyBackground),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly){

            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically) {

                Text("Player O: ${state.playerCircleCount}", fontSize = 16.sp)
                Text("Draw: ${state.drawCount}", fontSize = 16.sp)
                Text("Player X: ${state.playerCrossCount}", fontSize = 16.sp)

            }

            Text("Tic Tac Toe",
                fontSize = 50.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
            Box(modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .shadow(elevation = 15.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(RoundedCornerShape(20.dp))
                .background(GreyBackground),
                contentAlignment = Alignment.Center){
                BoardBase()
                LazyVerticalGrid(modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .aspectRatio(1f),
                    columns = GridCells.Fixed(3)){

                    viewModel.boardItems.forEach { (cellNo, boardCellValue) ->
                        item {
                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .clickable(interactionSource = MutableInteractionSource(),
                                    indication = null) {
                                    viewModel.onAction(UserAction.BoardTapped(cellNo))
                                },
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center) {
                                AnimatedVisibility(
                                    visible = viewModel.boardItems[cellNo] != BoardCellValue.NONE,
                                    enter = scaleIn(tween(500))
                                ) { if(boardCellValue == BoardCellValue.PLAYER_O){
                                    Circle()
                                }else if(boardCellValue == BoardCellValue.PLAYER_X){
                                    Cross()
                                }
                                }

                            }
                        }
                    }
                }
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center)
                { AnimatedVisibility(
                    visible = state.hasWon,
                    enter = fadeIn(tween(1000))
                ) {
                    DrawLine(state = state)
                }
                }

            }

            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically){
                Text(state.hintText,
                    fontSize = 24.sp,
                    fontStyle = FontStyle.Italic
                )
                Button(onClick = {
                    viewModel.onAction(UserAction.PlayAgainButtonClicked)
                }) {
                    Text(
                        "Play Again",
                        fontSize = 24.sp,
                        fontStyle = FontStyle.Italic
                    )
                }
            }

        }
    }

}

@Composable
fun DrawLine(state: GameState){
    when(state.victoryType){
        VictoryType.HORIZONTAL_TOP -> WinLine1()
        VictoryType.HORIZONTAL_MIDDLE -> WinLine2()
        VictoryType.HORIZONTAL_BOTTOM -> WinLine3()
        VictoryType.VERTICAL_LEFT -> WinLine4()
        VictoryType.VERTICAL_MIDDLE -> WinLine5()
        VictoryType.VERTICAL_RIGHT -> WinLine6()
        VictoryType.DIAGONAL_LEFT -> WinLine7()
        VictoryType.DIAGONAL_RIGHT -> WinLine8()
        VictoryType.None -> {}
    }
}
