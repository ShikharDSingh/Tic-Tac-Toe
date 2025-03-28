package com.suraj.tic_tac_toe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    var state by mutableStateOf(GameState())
    var boardItems = mutableStateMapOf(
        1 to BoardCellValue.NONE,
        2 to BoardCellValue.NONE,
        3 to BoardCellValue.NONE,
        4 to BoardCellValue.NONE,
        5 to BoardCellValue.NONE,
        6 to BoardCellValue.NONE,
        7 to BoardCellValue.NONE,
        8 to BoardCellValue.NONE,
        9 to BoardCellValue.NONE
    )


    fun onAction(action: UserAction){
        when(action){
            is UserAction.BoardTapped -> {
                addMove(action.cellNo)
            }
            UserAction.PlayAgainButtonClicked ->{
                gameReset()
            }
        }
    }

    private fun gameReset(){
        boardItems.forEach{(i, _)->
            boardItems[i] = BoardCellValue.NONE
        }
        state = state.copy(
            hintText = "Player 0 turn",
            currentTurn = BoardCellValue.PLAYER_O,
            victoryType = VictoryType.None,
            hasWon = false
        )
    }

    private fun addMove(cellNo: Int) {
        if(boardItems[cellNo] != BoardCellValue.NONE){
            return
        }
        if(state.currentTurn == BoardCellValue.PLAYER_O){
            boardItems[cellNo] = BoardCellValue.PLAYER_O
            if (checkForVictory(BoardCellValue.PLAYER_O)){
                state = state.copy(
                    hintText = "Player O Won",
                    playerCircleCount = state.playerCircleCount + 1,
                    currentTurn = BoardCellValue.NONE,
                    hasWon = true
                )
            }else if (hasBoardFull()){
                state = state.copy(
                    hintText = "Game Draw",
                    drawCount = state.drawCount + 1
                )
            }else{
                state = state.copy(
                    hintText = "Player X turn",
                    currentTurn = BoardCellValue.PLAYER_X
                )
            }

        }else if(state.currentTurn == BoardCellValue.PLAYER_X){
            boardItems[cellNo] = BoardCellValue.PLAYER_X
            if (checkForVictory(BoardCellValue.PLAYER_X)){
                state = state.copy(
                    hintText = "Player X Won",
                    playerCrossCount = state.playerCrossCount + 1,
                    currentTurn = BoardCellValue.NONE,
                    hasWon = true
                )
            }else if (hasBoardFull()){
                state = state.copy(
                    hintText = "Game Draw",
                    drawCount = state.drawCount + 1
                )
            }else{
                state = state.copy(
                    hintText = "Player O turn",
                    currentTurn = BoardCellValue.PLAYER_O
                )
            }

        }
    }

    private fun checkForVictory(boardValue: BoardCellValue): Boolean {
        when{
            boardItems[1] == boardValue && boardItems[2] == boardValue && boardItems[3] == boardValue ->{
                state = state.copy(victoryType = VictoryType.HORIZONTAL_TOP)
                return true
            }
            boardItems[4] == boardValue && boardItems[5] == boardValue && boardItems[6] == boardValue ->{
                state = state.copy(victoryType = VictoryType.HORIZONTAL_MIDDLE)
                return true
            }
            boardItems[7] == boardValue && boardItems[8] == boardValue && boardItems[9] == boardValue ->{
                state = state.copy(victoryType = VictoryType.HORIZONTAL_BOTTOM)
                return true
            }
            boardItems[1] == boardValue && boardItems[4] == boardValue && boardItems[7] == boardValue ->{
                state = state.copy(victoryType = VictoryType.VERTICAL_LEFT)
                return true
            }
            boardItems[2] == boardValue && boardItems[5] == boardValue && boardItems[8] == boardValue ->{
                state = state.copy(victoryType = VictoryType.VERTICAL_MIDDLE)
                return true
            }
            boardItems[3] == boardValue && boardItems[6] == boardValue && boardItems[9] == boardValue ->{
                state = state.copy(victoryType = VictoryType.VERTICAL_RIGHT)
                return true
            }
            boardItems[1] == boardValue && boardItems[5] == boardValue && boardItems[9] == boardValue ->{
                state = state.copy(victoryType = VictoryType.DIAGONAL_LEFT)
                return true
            }
            boardItems[3] == boardValue && boardItems[5] == boardValue && boardItems[7] == boardValue ->{
                state = state.copy(victoryType = VictoryType.DIAGONAL_RIGHT)
                return true
            }
        }
        return false
    }

    private fun hasBoardFull(): Boolean {
        return !boardItems.containsValue(BoardCellValue.NONE)
    }
}