package br.com.amos.leveupgames.main

import br.com.amos.leveupgames.model.Period
import br.com.amos.leveupgames.services.ApiConsumption
import java.time.LocalDate

fun main(){
    val consumption = ApiConsumption()
    val gamersList = consumption.gamersSearch()
    val listJsonGame = consumption.searchGameJson()

//    println(gamersList)
//    println(listJsonGame)

    val gamerCaroline = gamersList[3]
    val gameResidentVillage = listJsonGame[10]
    val gameSpiderman = listJsonGame[13]
    val gameTheLastofUsPartI = listJsonGame[2]

//    println(gamerCaroline)
//    println(gameResidentVillage)

    val period1 = Period(LocalDate.now(), LocalDate.now().plusDays(7))
    val period2 = Period(LocalDate.now(), LocalDate.now().plusDays(3))
    val period3 = Period(LocalDate.now(), LocalDate.now().plusDays(10))

    gamerCaroline?.gameRent(gameResidentVillage, period1)
    gamerCaroline?.gameRent(gameSpiderman, period2)
    gamerCaroline?.gameRent(gameTheLastofUsPartI, period3)
    println(gamerCaroline?.rentedGames)
}