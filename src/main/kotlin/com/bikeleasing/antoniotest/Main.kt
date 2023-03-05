package com.bikeleasing.antoniotest

import com.bikeleasing.antoniotest.factory.PieceFactory
import com.bikeleasing.antoniotest.models.InvalidPositionException
import com.bikeleasing.antoniotest.models.Piece


fun main() {

    val positions = listOf("Pdc3", "Rd1", "Nd8", "Bf1", "Qb1", "Kb3", "Bd2", "Ne2")
    val pieceFactory = PieceFactory(positions)

    val pieces = pieceFactory.createPieces()

    describeSetUp(pieces)
    validateSetUp(pieces)

}


fun describeSetUp(pieces: List<Piece>) {
    pieces.forEach { piece ->
        println(piece.describe())
    }
}

fun validateSetUp(pieces: List<Piece>) {
    if (!Piece.BoardValidator.validateChessBoard(pieces)) {
        throw InvalidPositionException("Invalid chess board")
    } else {
        println("Valid chess board, let's the game begin!")
    }
}

