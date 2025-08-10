package br.com.amos.leveupgames.utility

import br.com.amos.leveupgames.model.Game
import br.com.amos.leveupgames.model.InfoGameJson

fun InfoGameJson.createGame(): Game {
    return Game(
        title = this.title ?: "Title unavailable",
        cover = this.cover ?: "Cover unavailable",
        price = this.price ?: 0.0,
        description = this.description ?: "Description unavailable"
    )
}