package org.amosjuda.br.com.amos.leveupgames.main

import br.com.amos.leveupgames.services.ApiConsumption
import com.google.gson.JsonSyntaxException
import org.amosjuda.br.com.amos.leveupgames.model.Game
import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val reading = Scanner(System.`in`)
    println("Enter the game code to search:")
    val gameId = reading.nextLine()

    ApiConsumption().gameSearch(gameId)
        .onSuccess { infoGame ->
            runCatching {
                Game(infoGame.info.title, infoGame.info.thumb)
            }.onSuccess { game ->
                println(game)
                println("Do you want to enter a custom description? S/N")
                val option = reading.nextLine()
                if (option.equals("s", true)) {
                    println("Enter custom description for the game")
                    game.description = reading.nextLine()
                    println(game)
                } else {
                    game.description = game.title
                }
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
}