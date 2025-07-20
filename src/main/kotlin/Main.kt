package org.amosjuda

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val client: HttpClient? = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146"))
        .build()

    val response: HttpResponse<String?>? = client!!
        .send(request, BodyHandlers.ofString())

    val json = response?.body()
    println(json)

    val gson = Gson()
    val myInfoGame = gson.fromJson(json, InfoGame::class.java)

    val myGame = Game(myInfoGame.info.title, myInfoGame.info.thumb)
    println(myGame)
}