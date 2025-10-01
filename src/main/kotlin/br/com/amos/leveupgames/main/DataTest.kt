package br.com.amos.leveupgames.main

import br.com.amos.leveupgames.data.DataBase
import br.com.amos.leveupgames.data.GamesDAO
import br.com.amos.leveupgames.model.Game


fun main(){
    val em = DataBase.getEntityManager()
    val dao = GamesDAO(em)

    val game = Game(
        "The Last of Us Part I",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        5.99,
        "A post-apocalyptic survival adventure set in a world infested with zombies and warring factions."
    )

    val game2 = Game(
        "Dandara",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293",
        9.99,
        "Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania."
    )

    dao.addGame(game)
    dao.addGame(game2)

    val games = dao.getGames()
    games.forEach { println(it) }
    em.close()
}