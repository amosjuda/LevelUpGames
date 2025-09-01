package br.com.amos.leveupgames.main

import br.com.amos.leveupgames.model.Period
import br.com.amos.leveupgames.model.SignaturePlan
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

    val gamerCamila = gamersList.get(5)
    gamerCamila?.plan = SignaturePlan("PRATA", 9.90, 3, 0.15)

    gamerCamila?.gameRent(gameResidentVillage, period1)
    gamerCamila?.gameRent(gameSpiderman, period2)
    gamerCamila?.gameRent(gameTheLastofUsPartI, period3)
    gamerCamila?.gameRent(gameTheLastofUsPartI, period3)
    println(gamerCamila?.rentedGames)

    gamerCamila?.recommended(7)
    gamerCamila?.recommended(10)
    gamerCamila?.recommended(8)
    println(gamerCamila)

    gamerCamila?.gameRent(gameResidentVillage, period1)

    println(gamerCamila?.rentedGames)
}