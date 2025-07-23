package org.amosjuda

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val reading = Scanner(System.`in`)
    println("Enter the game code to search:")
    val gameId = reading.nextLine()

    val address = "https://www.cheapshark.com/api/1.0/games?id=$gameId"

    val client = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(address))
        .build()

    val response = client.send(request, BodyHandlers.ofString())
    val json = response.body()

    val gson = Gson()
    var myGame: Game? = null

    val result = runCatching {
        val myInfoGame = gson.fromJson(json, InfoGame::class.java)
        myGame = Game(
            myInfoGame.info.title,
            myInfoGame.info.thumb
        )
    }

    result.onFailure { exception ->
        when (exception) {
            is JsonSyntaxException -> {
                println("Game does not exist or invalid ID. Try another ID.")
            }
            is NullPointerException -> {
                println("Game data is incomplete or invalid. Try another ID.")
            }
            else -> {
                println("An unexpected error occurred: ${exception.message}")
            }
        }
    }

    result.onSuccess {
        println(myGame)
        println("Do you want to enter a custom description? S/N")
        val option = reading.nextLine()
        if(option.equals("s", true)){
            println("Enter custom description for the game")
            val customDescription = reading.nextLine()
            myGame?.description = customDescription
        } else {
            myGame?.description = myGame.title
        }
        println(myGame)
    }
}