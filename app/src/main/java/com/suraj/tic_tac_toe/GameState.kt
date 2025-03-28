package com.suraj.tic_tac_toe


data class GameState(
    var playerCircleCount: Int = 0,
    var playerCrossCount: Int = 0,
    var drawCount: Int = 0,
    var hintText: String = "Player '0' turn",
    var currentTurn: BoardCellValue = BoardCellValue.PLAYER_O,
    var victoryType: VictoryType = VictoryType.None,
    var hasWon: Boolean = false
)

enum class BoardCellValue {
    PLAYER_X,
    PLAYER_O,
    NONE
}

enum class VictoryType{
    HORIZONTAL_TOP,
    HORIZONTAL_MIDDLE,
    HORIZONTAL_BOTTOM,
    VERTICAL_LEFT,
    VERTICAL_MIDDLE,
    VERTICAL_RIGHT,
    DIAGONAL_LEFT,
    DIAGONAL_RIGHT,
    None
}