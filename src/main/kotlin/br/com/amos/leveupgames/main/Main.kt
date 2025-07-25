package org.amosjuda.br.com.amos.leveupgames.main

import br.com.amos.leveupgames.model.Gamer
import br.com.amos.leveupgames.services.ApiConsumption
import com.google.gson.JsonSyntaxException
import org.amosjuda.br.com.amos.leveupgames.model.Game
import transformIntoAge
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val gamer = Gamer.createGamer(sc)
    println("registration completed successfully. Gamer data:")
    println(gamer)

    println("Age of Gamer: " + gamer.birthDate?.transformIntoAge())

    do {
        println("Enter the game code to search:")
        val gameId = sc.nextLine()

        ApiConsumption().gameSearch(gameId)
            .onSuccess { infoGame ->
                runCatching {
                    Game(infoGame.info.title, infoGame.info.thumb)
                }.onSuccess { game ->
                    println(game)
                    println("Do you want to enter a custom description? S/N")
                    val option = sc.nextLine()
                    if (option.equals("s", true)) {
                        println("Enter custom description for the game")
                        game.description = sc.nextLine()
                        println(game)
                    } else {
                        game.description = game.title
                    }
                    gamer.wantedGames.add(game)
                }.onFailure { exception ->
                    println("Game data is incomplete or invalid. Try another ID.")
                }
            }
            .onFailure { exception ->
                when (exception) {
                    is JsonSyntaxException -> println("Game does not exist or invalid ID. Try another ID.")
                    else -> println("An unexpected error occurred: ${exception.message}")
                }
            }
        println("Want to search for a new game? S/N")
        val response = sc.nextLine()
    } while (response.equals("s",true))

    println("Wanted games:")
    println(gamer.wantedGames)

    println("\nGames sorted by titles: ")
    gamer.wantedGames.sortBy {
        it?.title
    }
    gamer.wantedGames.forEach {
        println("Title: " + it?.title)
    }

    val filterGames = gamer.wantedGames.filter {
        it?.title?.contains("Batman", true) ?: false
    }
    println("\nFiltered games:")
    println(filterGames)

    println("\nDo you want to delete a game from the original list? S/N")
    val option = sc.nextLine()
    if(option.equals("s",true)) {
        println(gamer.wantedGames)
        println("\nInform the position of the game you want to delete: ")
        val position = sc.nextInt()
        gamer.wantedGames.removeAt(position)
    }

    println("\n Updated list:")
    println(gamer.wantedGames)

    println("Search completed successfully.")
}