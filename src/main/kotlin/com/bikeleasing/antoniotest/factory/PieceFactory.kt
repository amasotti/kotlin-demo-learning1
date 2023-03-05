/*
File: PieceFactory
Author: Antonio Masotti <masotti@bikeleasing.de>
Date: 05.03.23
*/

package com.bikeleasing.antoniotest.factory

import com.bikeleasing.antoniotest.models.*
import com.bikeleasing.antoniotest.models.Piece

class PieceFactory(val positions: List<String>?) {

    fun createPieces(): List<Piece> {
        val pieces = mutableListOf<Piece>()
        positions?.forEach { position ->
            pieces.add(
                when (position.uppercase().first()) {
                    'P' -> Pawn(position.drop(1))
                    'R' -> Rook(position.drop(1))
                    'N' -> Knight(position.drop(1))
                    'B' -> Bishop(position.drop(1))
                    'Q' -> Queen(position.drop(1))
                    'K' -> King(position.drop(1))
                    else -> throw InvalidPositionException("Invalid position: $position")
                }
            )
        }
        return pieces
    }
}