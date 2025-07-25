package br.com.amos.leveupgames.services

import br.com.amos.leveupgames.model.Gamer
import br.com.amos.leveupgames.model.InfoGamerJson
import br.com.amos.leveupgames.utility.createGamer
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import org.amosjuda.br.com.amos.leveupgames.model.InfoGame
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ApiConsumption {
    private fun dataConsumer(address: String): String {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build()

        val response = client.send(request, BodyHandlers.ofString())
        val json = response.body()
        return response.body()
    }

    fun gameSearch(id: String): Result<InfoGame>{
        val address = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = dataConsumer(address)
        val gson = Gson()
        return runCatching {
            if(json == "[]"){
                throw JsonSyntaxException("Received empty JSON array for game ID: $id")
            }
            gson.fromJson(json, InfoGame::class.java)
        }
    }

    fun gamersSearch(): List<Gamer?>{
        val address = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = dataConsumer(address)
        val gson = Gson()

        val myTypeGamer = object : TypeToken<List<InfoGamerJson>>() {}.type
        val gamerList: List<InfoGamerJson> = gson.fromJson(json, myTypeGamer)

        val convertedListGamer = gamerList.mapNotNull { infoGamerJson ->
            infoGamerJson.createGamer().also { gamer ->
                if (gamer == null) {
                    println("Skipping entry due to null name or email: $infoGamerJson")
                }
            }
        }

        return convertedListGamer
    }
}