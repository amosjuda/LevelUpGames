package br.com.amos.leveupgames.main

import br.com.amos.leveupgames.services.ApiConsumption

fun main(){
    val consumption = ApiConsumption()
    val gamersList = consumption.gamersSearch()
    val apiGame = consumption.gameSearch("146")

    println(gamersList)
    println(apiGame)
}