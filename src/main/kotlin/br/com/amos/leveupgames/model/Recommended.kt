package br.com.amos.leveupgames.model

interface Recommended {
    val media: Double

    fun recommended(grade: Int)
}