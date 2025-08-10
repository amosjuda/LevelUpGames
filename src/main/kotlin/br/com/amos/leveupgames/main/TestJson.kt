package br.com.amos.leveupgames.main

import br.com.amos.leveupgames.services.ApiConsumption

fun main(){
    val consumption = ApiConsumption()
    val gamersList = consumption.gamersSearch()
    val listJsonGame = consumption.searchGameJson()

//    println(gamersList)
//    println(listJsonGame)

    val gamerCaroline = gamersList.get(3)
    val gameResidentVillage = listJsonGame.get(10)

    println(gamerCaroline)
    println(gameResidentVillage)

    val rent = gamerCaroline?.gameRent(gameResidentVillage)
    println(rent)
}