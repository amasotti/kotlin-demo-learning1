/*
File: PieceFactory
Author: Antonio Masotti <masotti@bikeleasing.de>
Date: 05.03.23
*/
/**
 * Factory class to create a list of pieces from a list of positions
 */
package com.bikeleasing.antoniotest.factory

import com.bikeleasing.antoniotest.models.*
import com.bikeleasing.antoniotest.models.Piece

annotation class TestAnnotation(val value: String) {}

/**
 * Factory class to create a list of pieces from a list of positions
 * @param positions List<String>
 *     List of positions as Strings
 *
 *     Example:
 *     ```
 *     val positions = listOf("Pdc3", "Rd1", "Nd8", "Bf1", "Qb1", "Kb3", "Bd2", "Ne2")
 *     ```
 *
 *     The first character of the string is the piece type:
 *     - P: Pawn
 *     - R: Rook
 *     - N: Knight
 *     - B: Bishop
 *     - Q: Queen
 *     - K: King
 *
 *     The second and third characters are the column and row of the position
 *     Example:
 *     ```
 *     val positions = listOf("Pdc3", "Rd1", "Nd8", "Bf1", "Qb1", "Kb3", "Bd2", "Ne2")
 *     ```
 *
 *     The column is a letter between a and h
 *     The row is a number between 1 and 8
 */
@TestAnnotation("Bla bla Bla")
class PieceFactory(private val positions: List<String>?) {

    /**
     * Test annotation
     */
    fun test() {
        val annotation = this::class.annotations.find { it is TestAnnotation } as TestAnnotation
        println(annotation.value)
    }

    /**
     * Create a list of pieces from a list of positions as Strings
     *
     * @return List<Piece>
     *
     * @throws InvalidPositionException
     */
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

