package br.com.amos.leveupgames.services

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import org.amosjuda.br.com.amos.leveupgames.model.InfoGame
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ApiConsumption {
    fun gameSearch(id: String): Result<InfoGame>{
        val address = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build()

        val response = client.send(request, BodyHandlers.ofString())
        val json = response.body()
        val gson = Gson()
        return runCatching {
            if(json == "[]"){
                throw JsonSyntaxException("Received empty JSON array for game ID: $id")
            }
            gson.fromJson(json, InfoGame::class.java)
        }
    }
}