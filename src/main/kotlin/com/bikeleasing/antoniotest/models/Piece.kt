/*
File: Piece
Author: Antonio Masotti <masotti@bikeleasing.de>
Date: 05.03.23
*/

package com.bikeleasing.antoniotest.models

sealed class Piece(private val position: String) {

    /**
     * Get the position of the piece
     *
     * @return String
     */
    private fun getPosition(): String {
        return position
    }

    /**
     * Describe the piece
     * @return String
     *
     * @author Antonio Masotti
     * @since 05.03.23
     *
     * ***Example***
     * ```
     * val piece = Pawn("a2")
     * piece.describe()
     * ```
     * ***Output***
     * ```
     * "Pawn in position a2"
     * ```
     */
    fun describe(): String {
        return when (this) {
            is Pawn -> "Paw in position ${this.getPosition()}"
            is Rook -> "Rook in position ${this.getPosition()}"
            is Knight -> "Knight in position ${this.getPosition()}"
            is Bishop -> "Bishop in position ${this.getPosition()}"
            is Queen -> "Queen in position ${this.getPosition()}"
            is King -> "King in position ${this.getPosition()}"
        }
        }


    fun validatePosition(position: String): Boolean {
        val column = position.first()
        val row = position.drop(1).toInt()
        return column in 'a'..'h' && row in 1..8
    }

    companion object BoardValidator {
        fun validateChessBoard(pieces: List<Piece>): Boolean {
            val positions = mutableListOf<String>()
            pieces.forEach { piece ->
                positions.add(piece.getPosition())
            }
            val comparison = positions.size == positions.distinct().size
            if (!comparison) {
                println("Invalid chess board, there are two pieces in the same position")
                println("Positions: $positions")
            }
            return comparison
        }
    }

}

class InvalidPositionException(message: String) : Exception(message)
class Pawn(position: String) : Piece(position)
class Rook(position: String) : Piece(position)
class Knight(position: String) : Piece(position)
class Bishop(position: String) : Piece(position)
class Queen(position: String) : Piece(position)
class King(position: String) : Piece(position)