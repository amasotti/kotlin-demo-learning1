package com.bikeleasing.antoniotest.utils

fun readPositionsFromStdIn(): List<String>? {
    // Ask the user for a comma separated list of chess positions
    println("Enter a comma separated list of chess positions:")
    val input = readlnOrNull()

    if (input == null) {
        println("No input received. Exiting.")
        return null
    }

    // Split the input into a list of positions
    val positions = input.split(",")
    println("Received ${positions.size} positions.")
    println("Positions: $positions")

    return positions
}