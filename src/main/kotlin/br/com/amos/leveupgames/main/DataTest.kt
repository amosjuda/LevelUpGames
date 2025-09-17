package br.com.amos.leveupgames.main

import br.com.amos.leveupgames.data.GamesDAO
import br.com.amos.leveupgames.model.Game


fun main(){
    val dao = GamesDAO()

    val game = Game(
        "The Last of Us Part I",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        5.99,
        "A post-apocalyptic survival adventure set in a world infested with zombies and warring factions."
    )

    dao.addGame(game)

    val games = dao.getGames()
    games.forEach { println(it) }
}